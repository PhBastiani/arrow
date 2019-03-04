package arrow.effects

import arrow.Kind
import arrow.core.getOrHandle
import arrow.core.left
import arrow.core.nonFatalOrThrow
import arrow.core.right
import arrow.effects.typeclasses.suspended.BIO
import arrow.effects.typeclasses.suspended.BIOPartialOf
import arrow.effects.typeclasses.suspended.bio.applicativeError.attempt
import arrow.effects.typeclasses.suspended.bio.applicativeError.raiseError
import arrow.effects.typeclasses.suspended.bio.concurrent.concurrent
import arrow.effects.typeclasses.suspended.bio.fx.fx
import arrow.effects.typeclasses.suspended.fix
import arrow.effects.typeclasses.suspended.fx.unsafeRun.runBlocking
import arrow.effects.typeclasses.suspended.toFx
import arrow.test.UnitSpec
import arrow.test.laws.ConcurrentLaws
import arrow.typeclasses.Eq
import arrow.unsafe
import io.kotlintest.runner.junit4.KotlinTestRunner
import io.kotlintest.shouldBe
import org.junit.runner.RunWith

@RunWith(KotlinTestRunner::class)
class BIOTest : UnitSpec() {

  fun <A> EQ(): Eq<Kind<BIOPartialOf<Throwable>, A>> = Eq { a, b ->
    unsafe {
      runBlocking {
        BIO<Throwable, Boolean> {
          try {
            (a.fix().fa() == b.fix().fa()).right()
          } catch (e: Throwable) {
            val errA = try {
              a.fix().fa()
              throw IllegalArgumentException()
            } catch (err: Throwable) {
              err.nonFatalOrThrow()
            }
            val errB = try {
              b.fix().fa()
              throw IllegalStateException()
            } catch (err: Throwable) {
              err.nonFatalOrThrow()
            }
            println("Found errors: $errA and $errB")
            (errA.message == errB.message).right()
          }
        }.toFx()
      }.getOrHandle { throw it }
    }
  }

  init {
    "Bio fx blocks" {
      val program: BIO<TestUserError, Int> =
        fx {
          val a = !effect { 1 }
          val b = !effect { 1 }
          a + b
        }
      unsafe { runBlocking { program.attempt().toFx() } } shouldBe 2.right().right()
    }

    "Bio fx error" {
      val program: BIO<TestUserError, Int> =
        fx {
          val a = !effect { 1 }
          val b: Int = !TestUserError.raiseError<TestUserError, Int>()
          a + b
        }
      unsafe { runBlocking { program.attempt().toFx() } } shouldBe TestUserError.left().right()
    }

    testLaws(ConcurrentLaws.laws(BIO.concurrent(), EQ(), EQ(), EQ()))
  }

}

object TestUserError
package arrow.core.test.generators

import arrow.core.Const
import arrow.core.Either
import arrow.core.Endo
import arrow.core.Eval
import arrow.core.Ior
import arrow.core.NonEmptyList
import arrow.core.NonEmptyList.Companion.fromListUnsafe
import arrow.core.Option
import arrow.core.Tuple10
import arrow.core.Tuple4
import arrow.core.Tuple5
import arrow.core.Tuple6
import arrow.core.Tuple7
import arrow.core.Tuple8
import arrow.core.Tuple9
import arrow.core.Validated
import arrow.core.align
import arrow.core.left
import arrow.core.right
import arrow.core.toOption
import io.kotlintest.properties.Gen
import io.kotlintest.properties.shrinking.DoubleShrinker
import io.kotlintest.properties.shrinking.FloatShrinker
import io.kotlintest.properties.shrinking.Shrinker

fun Gen.Companion.short(): Gen<Short> =
  Gen.choose(Short.MIN_VALUE.toInt(), Short.MAX_VALUE.toInt()).map { it.toShort() }

fun Gen.Companion.byte(): Gen<Byte> =
  Gen.choose(Byte.MIN_VALUE.toInt(), Byte.MAX_VALUE.toInt()).map { it.toByte() }

fun <A, B> Gen.Companion.functionAToB(gen: Gen<B>): Gen<(A) -> B> = gen.map { b: B -> { _: A -> b } }

fun <A> Gen.Companion.functionAAToA(gen: Gen<A>): Gen<(A, A) -> A> = gen.map { a: A -> { _: A, _: A -> a } }

fun <A, B> Gen.Companion.functionBAToB(gen: Gen<B>): Gen<(B, A) -> B> = gen.map { b: B -> { _: B, _: A -> b } }

fun <A, B> Gen.Companion.functionABToB(gen: Gen<B>): Gen<(A, B) -> B> = gen.map { b: B -> { _: A, _: B -> b } }

fun <A> Gen.Companion.functionToA(gen: Gen<A>): Gen<() -> A> = gen.map { a: A -> { a } }

fun Gen.Companion.throwable(): Gen<Throwable> = Gen.from(listOf(RuntimeException(), NoSuchElementException(), IllegalArgumentException()))

fun Gen.Companion.fatalThrowable(): Gen<Throwable> = Gen.from(listOf(ThreadDeath(), StackOverflowError(), OutOfMemoryError(), InterruptedException()))

fun Gen.Companion.doubleSmall(): Gen<Double> = object : Gen<Double> {
  override fun constants(): Iterable<Double> = emptyList()
  override fun random(): Sequence<Double> = (0 until 10_000).asSequence().map { it / 100.0 }
  override fun shrinker(): Shrinker<Double> = DoubleShrinker
}

fun Gen.Companion.floatSmall(): Gen<Float> = object : Gen<Float> {
  val literals = listOf(0F)
  override fun constants(): Iterable<Float> = literals
  override fun random(): Sequence<Float> = (0 until 10_000).asSequence().map { it / 100.0f }
  override fun shrinker() = FloatShrinker
}

fun Gen.Companion.intSmall(): Gen<Int> = Gen.oneOf(Gen.choose(Int.MIN_VALUE / 10000, -1), Gen.choose(0, Int.MAX_VALUE / 10000))

fun Gen.Companion.byteSmall(): Gen<Byte> = Gen.oneOf(Gen.choose(Byte.MIN_VALUE / 10, -1), Gen.choose(0, Byte.MAX_VALUE / 10)).map { it.toByte() }

fun Gen.Companion.shortSmall(): Gen<Short> = Gen.oneOf(Gen.choose(Short.MIN_VALUE / 1000, -1), Gen.choose(0, Short.MAX_VALUE / 1000)).map { it.toShort() }

fun Gen.Companion.longSmall(): Gen<Long> = Gen.oneOf(Gen.choose(Long.MIN_VALUE / 100000L, -1L), Gen.choose(0L, Long.MAX_VALUE / 100000L))

fun <A, B, C, D> Gen.Companion.tuple4(genA: Gen<A>, genB: Gen<B>, genC: Gen<C>, genD: Gen<D>): Gen<Tuple4<A, B, C, D>> =
  Gen.bind(genA, genB, genC, genD) { a: A, b: B, c: C, d: D -> Tuple4(a, b, c, d) }

fun <A, B, C, D, E> Gen.Companion.tuple5(genA: Gen<A>, genB: Gen<B>, genC: Gen<C>, genD: Gen<D>, genE: Gen<E>): Gen<Tuple5<A, B, C, D, E>> =
  Gen.bind(genA, genB, genC, genD, genE) { a: A, b: B, c: C, d: D, e: E -> Tuple5(a, b, c, d, e) }

fun <A, B, C, D, E, F> Gen.Companion.tuple6(genA: Gen<A>, genB: Gen<B>, genC: Gen<C>, genD: Gen<D>, genE: Gen<E>, genF: Gen<F>): Gen<Tuple6<A, B, C, D, E, F>> =
  Gen.bind(genA, genB, genC, genD, genE, genF) { a: A, b: B, c: C, d: D, e: E, f: F -> Tuple6(a, b, c, d, e, f) }

fun <A, B, C, D, E, F, G> Gen.Companion.tuple7(genA: Gen<A>, genB: Gen<B>, genC: Gen<C>, genD: Gen<D>, genE: Gen<E>, genF: Gen<F>, genG: Gen<G>): Gen<Tuple7<A, B, C, D, E, F, G>> =
  Gen.bind(genA, genB, genC, genD, genE, genF, genG) { a: A, b: B, c: C, d: D, e: E, f: F, g: G -> Tuple7(a, b, c, d, e, f, g) }

fun <A, B, C, D, E, F, G, H> Gen.Companion.tuple8(genA: Gen<A>, genB: Gen<B>, genC: Gen<C>, genD: Gen<D>, genE: Gen<E>, genF: Gen<F>, genG: Gen<G>, genH: Gen<H>): Gen<Tuple8<A, B, C, D, E, F, G, H>> =
  Gen.bind(Gen.tuple7(genA, genB, genC, genD, genE, genF, genG), genH) { tuple: Tuple7<A, B, C, D, E, F, G>, h: H -> Tuple8(tuple.first, tuple.second, tuple.third, tuple.fourth, tuple.fifth, tuple.sixth, tuple.seventh, h) }

fun <A, B, C, D, E, F, G, H, I> Gen.Companion.tuple9(genA: Gen<A>, genB: Gen<B>, genC: Gen<C>, genD: Gen<D>, genE: Gen<E>, genF: Gen<F>, genG: Gen<G>, genH: Gen<H>, genI: Gen<I>): Gen<Tuple9<A, B, C, D, E, F, G, H, I>> =
  Gen.bind(Gen.tuple8(genA, genB, genC, genD, genE, genF, genG, genH), genI) { tuple: Tuple8<A, B, C, D, E, F, G, H>, i: I -> Tuple9(tuple.first, tuple.second, tuple.third, tuple.fourth, tuple.fifth, tuple.sixth, tuple.seventh, tuple.eighth, i) }

fun <A, B, C, D, E, F, G, H, I, J> Gen.Companion.tuple10(genA: Gen<A>, genB: Gen<B>, genC: Gen<C>, genD: Gen<D>, genE: Gen<E>, genF: Gen<F>, genG: Gen<G>, genH: Gen<H>, genI: Gen<I>, genJ: Gen<J>): Gen<Tuple10<A, B, C, D, E, F, G, H, I, J>> =
  Gen.bind(Gen.tuple9(genA, genB, genC, genD, genE, genF, genG, genH, genI), genJ) { tuple: Tuple9<A, B, C, D, E, F, G, H, I>, j: J -> Tuple10(tuple.first, tuple.second, tuple.third, tuple.fourth, tuple.fifth, tuple.sixth, tuple.seventh, tuple.eighth, tuple.ninth, j) }

fun Gen.Companion.nonZeroInt(): Gen<Int> = Gen.int().filter { it != 0 }

fun Gen.Companion.intPredicate(): Gen<(Int) -> Boolean> =
  Gen.nonZeroInt().flatMap { num ->
    val absNum = Math.abs(num)
    Gen.from(
      listOf<(Int) -> Boolean>(
        { it > num },
        { it <= num },
        { it % absNum == 0 },
        { it % absNum == absNum - 1 }
      )
    )
  }

fun <A> Gen.Companion.endo(gen: Gen<A>): Gen<Endo<A>> = gen.map { a: A -> Endo<A> { a } }

fun <B> Gen.Companion.option(gen: Gen<B>): Gen<Option<B>> =
  gen.orNull().map { it.toOption() }

fun <E, A> Gen.Companion.either(genE: Gen<E>, genA: Gen<A>): Gen<Either<E, A>> {
  val genLeft = genE.map<Either<E, A>> { Either.Left(it) }
  val genRight = genA.map<Either<E, A>> { Either.Right(it) }
  return Gen.oneOf(genLeft, genRight)
}

fun <E, A> Gen<E>.or(genA: Gen<A>): Gen<Either<E, A>> = Gen.either(this, genA)

fun <E, A> Gen.Companion.validated(genE: Gen<E>, genA: Gen<A>): Gen<Validated<E, A>> =
  Gen.either(genE, genA).map { Validated.fromEither(it) }

fun <A> Gen.Companion.nonEmptyList(gen: Gen<A>): Gen<NonEmptyList<A>> =
  Gen.list(gen).filter(List<A>::isNotEmpty).map(::fromListUnsafe)

fun <A> Gen.Companion.sequence(genA: Gen<A>): Gen<Sequence<A>> =
  Gen.list(genA).map { it.asSequence() }

fun Gen.Companion.unit(): Gen<Unit> =
  create { Unit }

fun <A, B> Gen.Companion.ior(genA: Gen<A>, genB: Gen<B>): Gen<Ior<A, B>> =
  genA.alignWith(genB) { it }

fun <A, B> Gen.Companion.genConst(gen: Gen<A>): Gen<Const<A, B>> =
  gen.map {
    Const<A, B>(it)
  }

fun <A> Gen<A>.eval(): Gen<Eval<A>> =
  map { Eval.now(it) }

fun Gen.Companion.char(): Gen<Char> =
  Gen.from(('A'..'Z') + ('a'..'z') + ('0'..'9') + "!@#$%%^&*()_-~`,<.?/:;}{][±§".toList())

private fun <A, B, R> Gen<A>.alignWith(genB: Gen<B>, transform: (Ior<A, B>) -> R): Gen<R> =
  object : Gen<R> {
    override fun constants(): Iterable<R> =
      this@alignWith.constants()
        .align(genB.constants(), transform)

    override fun random(): Sequence<R> =
      this@alignWith.random()
        .align(genB.random(), transform)
  }

fun Gen.Companion.suspendFunThatReturnsEitherAnyOrAnyOrThrows(): Gen<suspend () -> Either<Any, Any>> =
  oneOf(
    suspendFunThatReturnsAnyRight(),
    suspendFunThatReturnsAnyLeft(),
    suspendFunThatThrows()
  )

fun Gen.Companion.suspendFunThatReturnsAnyRight(): Gen<suspend () -> Either<Any, Any>> =
  any().map { suspend { it.right() } }

fun Gen.Companion.suspendFunThatReturnsAnyLeft(): Gen<suspend () -> Either<Any, Any>> =
  any().map { suspend { it.left() } }

fun Gen.Companion.suspendFunThatThrows(): Gen<suspend () -> Either<Any, Any>> =
  throwable().map { suspend { throw it } } as Gen<suspend () -> Either<Any, Any>>

fun Gen.Companion.suspendFunThatThrowsFatalThrowable(): Gen<suspend () -> Either<Any, Any>> =
  fatalThrowable().map { suspend { throw it } } as Gen<suspend () -> Either<Any, Any>>

fun Gen.Companion.any(): Gen<Any> =
  oneOf(
    string() as Gen<Any>,
    int() as Gen<Any>,
    long() as Gen<Any>,
    float() as Gen<Any>,
    double() as Gen<Any>,
    bool() as Gen<Any>,
    uuid() as Gen<Any>,
    file() as Gen<Any>,
    localDate() as Gen<Any>,
    localTime() as Gen<Any>,
    localDateTime() as Gen<Any>,
    period() as Gen<Any>,
    throwable() as Gen<Any>,
    fatalThrowable() as Gen<Any>,
    unit() as Gen<Any>
  )

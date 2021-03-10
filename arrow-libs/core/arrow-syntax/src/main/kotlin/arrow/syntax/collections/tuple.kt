package arrow.syntax.collections

import arrow.core.Tuple4
import arrow.core.Tuple5
import arrow.core.Tuple6
import arrow.core.Tuple7
import arrow.core.Tuple8
import arrow.core.Tuple9
import arrow.core.Tuple10
import arrow.core.Tuple11
import arrow.core.Tuple12
import arrow.core.Tuple13
import arrow.core.Tuple14
import arrow.core.Tuple15
import arrow.core.Tuple16
import arrow.core.Tuple17
import arrow.core.Tuple18
import arrow.core.Tuple19
import arrow.core.Tuple20
import arrow.core.Tuple21
import arrow.core.Tuple22

operator fun <A, B, C> Pair<A, B>.plus(c: C): Triple<A, B, C> = Triple(this.first, this.second, c)
operator fun <A, B, C, D> Triple<A, B, C>.plus(d: D): Tuple4<A, B, C, D> = Tuple4(this.first, this.second, this.third, d)
operator fun <A, B, C, D, E> Tuple4<A, B, C, D>.plus(e: E): Tuple5<A, B, C, D, E> = Tuple5(this.first, this.second, this.third, this.fourth, e)
operator fun <A, B, C, D, E, F> Tuple5<A, B, C, D, E>.plus(f: F): Tuple6<A, B, C, D, E, F> = Tuple6(this.first, this.second, this.third, this.fourth, this.fifth, f)
operator fun <A, B, C, D, E, F, G> Tuple6<A, B, C, D, E, F>.plus(g: G): Tuple7<A, B, C, D, E, F, G> = Tuple7(this.first, this.second, this.third, this.fourth, this.fifth, this.sixth, g)
operator fun <A, B, C, D, E, F, G, H> Tuple7<A, B, C, D, E, F, G>.plus(h: H): Tuple8<A, B, C, D, E, F, G, H> = Tuple8(this.first, this.second, this.third, this.fourth, this.fifth, this.sixth, this.seventh, h)
operator fun <A, B, C, D, E, F, G, H, I> Tuple8<A, B, C, D, E, F, G, H>.plus(i: I): Tuple9<A, B, C, D, E, F, G, H, I> = Tuple9(this.first, this.second, this.third, this.fourth, this.fifth, this.sixth, this.seventh, this.eighth, i)
operator fun <A, B, C, D, E, F, G, H, I, J> Tuple9<A, B, C, D, E, F, G, H, I>.plus(j: J): Tuple10<A, B, C, D, E, F, G, H, I, J> = Tuple10(this.first, this.second, this.third, this.fourth, this.fifth, this.sixth, this.seventh, this.eighth, this.ninth, j)
operator fun <A, B, C, D, E, F, G, H, I, J, K> Tuple10<A, B, C, D, E, F, G, H, I, J>.plus(k: K): Tuple11<A, B, C, D, E, F, G, H, I, J, K> = Tuple11(this.first, this.second, this.third, this.fourth, this.fifth, this.sixth, this.seventh, this.eighth, this.ninth, this.tenth, k)
operator fun <A, B, C, D, E, F, G, H, I, J, K, L> Tuple11<A, B, C, D, E, F, G, H, I, J, K>.plus(l: L): Tuple12<A, B, C, D, E, F, G, H, I, J, K, L> = Tuple12(this.first, this.second, this.third, this.fourth, this.fifth, this.sixth, this.seventh, this.eighth, this.ninth, this.tenth, this.eleventh, l)
operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M> Tuple12<A, B, C, D, E, F, G, H, I, J, K, L>.plus(m: M): Tuple13<A, B, C, D, E, F, G, H, I, J, K, L, M> = Tuple13(this.first, this.second, this.third, this.fourth, this.fifth, this.sixth, this.seventh, this.eighth, this.ninth, this.tenth, this.eleventh, this.twelfth, m)
operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N> Tuple13<A, B, C, D, E, F, G, H, I, J, K, L, M>.plus(n: N): Tuple14<A, B, C, D, E, F, G, H, I, J, K, L, M, N> = Tuple14(this.first, this.second, this.third, this.fourth, this.fifth, this.sixth, this.seventh, this.eighth, this.ninth, this.tenth, this.eleventh, this.twelfth, this.thirteenth, n)
operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O> Tuple14<A, B, C, D, E, F, G, H, I, J, K, L, M, N>.plus(o: O): Tuple15<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O> = Tuple15(this.first, this.second, this.third, this.fourth, this.fifth, this.sixth, this.seventh, this.eighth, this.ninth, this.tenth, this.eleventh, this.twelfth, this.thirteenth, this.fourteenth, o)
operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> Tuple15<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O>.plus(p: P): Tuple16<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> = Tuple16(this.first, this.second, this.third, this.fourth, this.fifth, this.sixth, this.seventh, this.eighth, this.ninth, this.tenth, this.eleventh, this.twelfth, this.thirteenth, this.fourteenth, this.fifteenth, p)
operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q> Tuple16<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P>.plus(q: Q): Tuple17<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q> = Tuple17(this.first, this.second, this.third, this.fourth, this.fifth, this.sixth, this.seventh, this.eighth, this.ninth, this.tenth, this.eleventh, this.twelfth, this.thirteenth, this.fourteenth, this.fifteenth, this.sixteenth, q)
operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R> Tuple17<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q>.plus(r: R): Tuple18<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R> = Tuple18(this.first, this.second, this.third, this.fourth, this.fifth, this.sixth, this.seventh, this.eighth, this.ninth, this.tenth, this.eleventh, this.twelfth, this.thirteenth, this.fourteenth, this.fifteenth, this.sixteenth, this.seventeenth, r)
operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S> Tuple18<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R>.plus(s: S): Tuple19<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S> = Tuple19(this.first, this.second, this.third, this.fourth, this.fifth, this.sixth, this.seventh, this.eighth, this.ninth, this.tenth, this.eleventh, this.twelfth, this.thirteenth, this.fourteenth, this.fifteenth, this.sixteenth, this.seventeenth, this.eighteenth, s)
operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T> Tuple19<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S>.plus(t: T): Tuple20<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T> = Tuple20(this.first, this.second, this.third, this.fourth, this.fifth, this.sixth, this.seventh, this.eighth, this.ninth, this.tenth, this.eleventh, this.twelfth, this.thirteenth, this.fourteenth, this.fifteenth, this.sixteenth, this.seventeenth, this.eighteenth, this.nineteenth, t)
operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U> Tuple20<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T>.plus(u: U): Tuple21<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U> = Tuple21(this.first, this.second, this.third, this.fourth, this.fifth, this.sixth, this.seventh, this.eighth, this.ninth, this.tenth, this.eleventh, this.twelfth, this.thirteenth, this.fourteenth, this.fifteenth, this.sixteenth, this.seventeenth, this.eighteenth, this.nineteenth, this.twentieth, u)
operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V> Tuple21<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U>.plus(v: V): Tuple22<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V> = Tuple22(this.first, this.second, this.third, this.fourth, this.fifth, this.sixth, this.seventh, this.eighth, this.ninth, this.tenth, this.eleventh, this.twelfth, this.thirteenth, this.fourteenth, this.fifteenth, this.sixteenth, this.seventeenth, this.eighteenth, this.nineteenth, this.twentieth, this.twentyFirst, v)

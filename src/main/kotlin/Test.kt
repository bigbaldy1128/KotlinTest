import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking

/**
 * Created by wangjinzhao on 2017/9/28.
 */
fun main(args: Array<String>) = runBlocking {
    println(listOf(calc(43), calc(44))
            .map { p -> p.await() }
            .sum())
}

fun calc(x: Int) = async(CommonPool) {
    fibonacci(x)
}

fun fibonacci(x: Int): Int {
    return if (x <= 2) {
        1
    } else {
        fibonacci(x - 1) + fibonacci(x - 2)
    }
}

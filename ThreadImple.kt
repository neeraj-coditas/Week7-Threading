package week7

import java.util.concurrent.Executor
import kotlin.concurrent.thread

class Thread1 : Thread() {

    override fun run() {
        println("First Run Starts: ${currentThread().name}")

    }
}

class Thread2 : Runnable {

    override fun run() {
        // compute primes larger than minPrime
        println("Second Run starts: ${Thread.currentThread().name}")

    }
}

class Thread3 {
    fun startThread() {
        thread {     //Creates a background thread  (worker thread)
            println("Third Run Starts: ${Thread.currentThread().name}")
        }
    }
}

/*class DirectExecutor : Executor {
    override fun execute(q: Runnable) {
        q.run()
    }
}*/

class FourthThread : Thread() {
    override fun run() {
        for (i in 1..10) {
            if (i == 2) {

                Thread1().start()

            }
            println(i)

        }

    }
}


fun main() {

    println("Main program starts: ${Thread.currentThread().name}")


    val p = Thread1()
    p.start()

    val q = Thread2()
    Thread(q).start()

    val r = Thread3()
    r.startThread()

    val t = FourthThread()
    t.start()


    /* val s = DirectExecutor()
     s.execute(p)*/

}

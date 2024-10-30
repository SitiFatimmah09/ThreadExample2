import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ac.polbeng.sifa.threadexample2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnStartThread.setOnClickListener {
            startThread()
        }
    }

    private fun startThread() {
        val runnable = ExampleThread(10)
        Thread(runnable).start()
    }

    inner class ExampleThread(private val seconds: Int) : Runnable {
        override fun run() {
            for (i in 1..seconds) {
                println("Thread: $i")
                Thread.sleep(1000) // 1 second delay
            }
        }
    }
}

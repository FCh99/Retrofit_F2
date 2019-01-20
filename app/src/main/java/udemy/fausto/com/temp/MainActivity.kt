package udemy.fausto.com.temp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.LENGTH_SHORT
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.lang.Exception
import java.util.concurrent.TimeUnit



class MainActivity : AppCompatActivity() {

    val urlBaseString = "https://api.github.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var retrofit = Retrofit.Builder()
            .baseUrl(urlBaseString)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var service = retrofit.create(gitHubService::class.java)

        GlobalScope.launch {
            try {
                val repo = service.listRepos("FCh99")
                println(repo)
                val response = repo.execute()
                val bodyString = response.body().toString()
                println("----->bodyString: $bodyString")

            } catch (e: Exception) {
                println("Exception $e")

            }

        }


    }
}

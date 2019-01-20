package udemy.fausto.com.temp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface gitHubService {
    @GET("/users/{user}/repos")
    fun listRepos(@Path("user") user: String) : Call<List<Repo>>
}

// https://api.github.com/users/FCh99/repos
// FCH99, JakeWharton, Valexx55, sevi221


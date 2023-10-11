import com.example.compliancereporthomefinance.ResponseData
import com.example.compliancereporthomefinance.Root
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    // Define your API endpoints here
    @Headers(
        "api-key: d58d69ce274540b8a5969d054f16e83f",
        "Content-Type: application/json"
    )
    @POST("completions?api-version=2023-07-01-preview")
    fun getSomeData(@Body requestParser: Root?): Call<ResponseData>
    // Replace YourDataModel with your actual data model class
}
package com.turun.androidkotlin

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllMovies(): LiveData<PagingData<Movie>> {

        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                MoviePagingSource(retrofitService)
            }
            , initialKey = 1
        ).liveData
    }

}
/*
Bu kod parçacığı, "MainRepository" sınıfının tanımını içermektedir.
"MainRepository" sınıfı, "RetrofitService" nesnesini bir yapılandırıcı
ile özel bir değişken olarak alır ve "getAllMovies" adlı bir işlev içerir.

"getAllMovies" işlevi, "LiveData<PagingData<Movie>>" tipinde bir
veri döndürür. Bu veri, film verilerinin sayfalandırılmasını sağlar
 ve "Pager" sınıfını kullanarak oluşturulur. "PagingConfig" sınıfı,
  sayfalandırma için ayarları belirler ve bu ayarlar arasında sayfa boyutu,
   yer tutucuların etkinliği ve başlangıç yükleme boyutu gibi özellikler
   bulunabilir. "MoviePagingSource" sınıfı, verileri sayfalandırmak
   için kaynak olarak kullanılır ve "retrofitService" değişkeni ile bağlantı kurar. "liveData" özelliği,
sayfalandırılmış verileri "LiveData" olarak sağlar ve bu veriler, "MainRepository" sınıfı tarafından döndürülür.
 */
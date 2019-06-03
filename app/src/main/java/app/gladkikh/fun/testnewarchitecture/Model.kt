package app.gladkikh.`fun`.testnewarchitecture

import android.os.Handler
import java.util.*

class RepoModel {

    fun refreshData(onDataReadyCallback: OnDataReadyCallback) {
        Handler().postDelayed({
            onDataReadyCallback.onDataReady("new data ${Date().toString()}")
        }, 2000)
    }

    fun getRepositories(onRepositoryReadyCallback: OnRepositoryReadyCallback) {
        var arrayList = ArrayList<Repository>()
        var date = Date().toString()
        arrayList.add(Repository("First", "Owner 1 $date", 100 , false))
        arrayList.add(Repository("Second", "Owner 2 $date", 30 , true))
        arrayList.add(Repository("Third", "Owner 3 $date", 430 , false))

        Handler().postDelayed({ onRepositoryReadyCallback.onDataReady(arrayList) },2000)
    }
}

interface OnDataReadyCallback {
    fun onDataReady(data: String)
}

interface OnRepositoryReadyCallback {
    fun onDataReady(data : ArrayList<Repository>)
}
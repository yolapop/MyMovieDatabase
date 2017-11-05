package com.twins.mymoviedatabase

import android.os.Bundle
import com.twins.mymoviedatabase.auth.fragment.AuthFragment

class HostActivity : BaseActivity() {

    var fragment: BaseFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragment = AuthFragment()

        fragment?.let {
            title = it.title
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.container, it)
            transaction.commit()
        }
    }
}
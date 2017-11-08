package com.twins.mymoviedatabase

import android.os.Bundle
import com.twins.mymoviedatabase.auth.fragment.AuthFragment
import kotlinx.android.synthetic.main.activity_main.*

class HostActivity : BaseActivity() {

    var fragment: BaseFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBar(toolbar)

        fragment = AuthFragment()

        fragment?.let {
            title = it.title ?: getString(R.string.app_name)
            val transaction = fragmentManager.beginTransaction()
            transaction.add(R.id.container, it)
            transaction.commit()
        }
    }
}
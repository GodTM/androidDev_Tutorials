package sg.edu.nus.ngtk.is3261sep7

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class ActivityDynamicFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_fragment)

        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        val fragment1 = Fragment1()
        transaction.add(R.id.frameLayout1, fragment1)

        val fragment2 = Fragment2()
        transaction.add(R.id.frameLayout2, fragment2)

        transaction.commit()

    }
}

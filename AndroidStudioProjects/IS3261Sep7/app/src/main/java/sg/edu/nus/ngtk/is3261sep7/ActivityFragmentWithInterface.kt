package sg.edu.nus.ngtk.is3261sep7

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

class ActivityFragmentWithInterface : AppCompatActivity(), Fragment3.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_with_interface)

        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        val fragment3 = Fragment3()
        transaction.add(R.id.frameLayout3, fragment3)

        transaction.commit()

    }

    override fun onFragmentInteraction(str: String) {
       Toast.makeText(this, "received from fragment 3 " + str,
               Toast.LENGTH_LONG).show()
    }
}

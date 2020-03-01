package org.d3if4127.praassesment


import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_segitiga.*
import org.d3if4127.praassesment.databinding.FragmentSegitigaBinding

/**
 * A simple [Fragment] subclass.
 */
class segitigaFragment : Fragment() {

    var luas = 0.0
    var keliling = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentSegitigaBinding>(inflater, R.layout.fragment_segitiga, container, false)

        if (savedInstanceState != null) {
            binding.luasPrint.text = "Luas: ${savedInstanceState.getDouble("luas")}"
            binding.kelilingPrint.text = "Keliling: ${savedInstanceState.getDouble("keliling")}"
            binding.containerResult.visibility = View.VISIBLE
        }
        binding.btnCheck.setOnClickListener {
            try {
                var alas = Integer.parseInt(binding.iAlas.text.toString())
                var tinggi = Integer.parseInt(binding.iTinggi.text.toString())
                var sisi_miring = Math.sqrt(Math.pow(alas.toDouble(), 2.0) + Math.pow(tinggi.toDouble(), 2.0))

                luas = (alas.toDouble()* tinggi.toDouble())/2
                keliling = alas + tinggi + sisi_miring

                binding.luasPrint.text = "Luas: $luas"
                binding.kelilingPrint.text = "Keliling: $keliling"
                binding.containerResult.visibility = View.VISIBLE
            }catch (e: Exception) {
                Toast.makeText(this.context, "Pastikan input valid", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnShare.setOnClickListener {
            share()
        }
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putDouble("luas", luas)
        outState.putDouble("keliling", keliling)
        super.onSaveInstanceState(outState)
    }

    fun share() {
        val intentShare = this.activity.let {
            ShareCompat.IntentBuilder.from(it).setText(luas_print.text.toString() +" | "+ keliling_print.text.toString()).setType("text/plain").intent
        }

        try {
            startActivity(intentShare)
        }catch (e: Exception) {
            Toast.makeText(this.context, "Sharing not avaible", Toast.LENGTH_SHORT).show()
        }
    }

}

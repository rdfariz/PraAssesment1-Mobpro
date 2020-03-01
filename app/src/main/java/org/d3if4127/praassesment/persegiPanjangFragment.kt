package org.d3if4127.praassesment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_segitiga.*
import org.d3if4127.praassesment.databinding.FragmentPersegiPanjangBinding

/**
 * A simple [Fragment] subclass.
 */
class persegiPanjangFragment : Fragment() {

    var luas: Int = 0
    var keliling: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentPersegiPanjangBinding>(inflater, R.layout.fragment_persegi_panjang, container, false)

        if (savedInstanceState != null) {
            binding.luasPrint.text = "Luas ${savedInstanceState.getInt("luas")}"
            binding.kelilingPrint.text = "Keliling ${savedInstanceState.getInt("keliling")}"
            binding.containerResult.visibility = View.VISIBLE
        }

        binding.btnCheck.setOnClickListener {
            try {
                var panjang = Integer.parseInt(binding.iPanjang.text.toString())
                var lebar = Integer.parseInt(binding.iLebar.text.toString())

                luas = panjang * lebar
                keliling = 2 * (panjang + lebar)

                binding.luasPrint.text = "Luas $luas"
                binding.kelilingPrint.text = "Keliling $keliling"
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
        outState.putInt("luas", luas)
        outState.putInt("keliling", keliling)
        super.onSaveInstanceState(outState)
    }

    fun share() {
        val intentShare = this.activity.let {
            ShareCompat.IntentBuilder.from(it).setText(luas_print.text.toString()+" | "+keliling_print.text.toString()).setType("text/plain").intent
        }

        try {
            startActivity(intentShare)
        }catch (e: Exception) {
            Toast.makeText(this.context, "Sharing not avaible", Toast.LENGTH_SHORT).show()
        }
    }


}

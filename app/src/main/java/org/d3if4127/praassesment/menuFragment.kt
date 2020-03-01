package org.d3if4127.praassesment


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import org.d3if4127.praassesment.databinding.FragmentMenuBinding

/**
 * A simple [Fragment] subclass.
 */
class menuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentMenuBinding>(inflater, R.layout.fragment_menu, container, false)
        setHasOptionsMenu(true)

        binding.toSegitiga.setOnClickListener {view: View ->
            view.findNavController().navigate(R.id.action_menuFragment_to_segitigaFragment)
        }
        binding.toPersegiPanjang.setOnClickListener {view: View ->
            view.findNavController().navigate(R.id.action_menuFragment_to_persegiPanjangFragment)
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, view!!.findNavController()) || super.onOptionsItemSelected(item)
    }

}

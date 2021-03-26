package cl.dal.cars.view.listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager

import cl.dal.cars.R
import cl.dal.cars.databinding.FragmentListingBinding
import cl.dal.cars.view.detail.DetailFragment
import cl.dal.cars.vm.ListingViewModel
import timber.log.Timber

class ListingFragment: Fragment() {

    private lateinit var binding: FragmentListingBinding

    private val viewModel by viewModels<ListingViewModel>()

    private lateinit var adapter: CarAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListingBinding.inflate(inflater)

        initViews()

        registerObservers()

        return binding.root
    }

    private fun initViews() {
        adapter = CarAdapter()
        binding.rvCarList.adapter = adapter
        binding.rvCarList.layoutManager = GridLayoutManager(context, 1)
    }

    private fun registerObservers() {
        viewModel.getCars()

        viewModel.carList.observe(viewLifecycleOwner) { car ->
            car?.let {
                adapter.update(car)
            }
        }

        adapter.selected().observe(viewLifecycleOwner) {
            Timber.d("el auto seleccionado es ${it.id}")
            activity?.supportFragmentManager?.
            beginTransaction()?.
            replace(R.id.main_container, DetailFragment.newInstance(it.id.toString()))?.
            addToBackStack("detail")?.
            commit()
        }
    }
}
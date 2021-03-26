package cl.dal.cars.view.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import cl.dal.cars.R
import cl.dal.cars.databinding.FragmentDetailBinding
import cl.dal.cars.model.pojos.CarDetail
import cl.dal.cars.vm.DetailViewModel
import timber.log.Timber

private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {

    private var param1: String? = null

    private val detailViewModel by viewModels<DetailViewModel>()

    private lateinit var binding: FragmentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater)

        Timber.d("información para el auto $param1")

        detailViewModel.getDetail(param1!!)

        detailViewModel.carDetail.observe(viewLifecycleOwner) {
            showDetail(it)
        }

        return binding.root
    }

    private fun showDetail(detail: CarDetail?) {
        detail?.let {
            Timber.d("show detail for $detail")
            binding.tvDetailCarName.text = detail.name
            binding.tvDetailAcce.text = detail.acceleration
            binding.tvFeatures.text = detail.features
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Car id.
         * @return A new instance of fragment DetailFragment.
         */
        @JvmStatic
        fun newInstance(param1: String) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}
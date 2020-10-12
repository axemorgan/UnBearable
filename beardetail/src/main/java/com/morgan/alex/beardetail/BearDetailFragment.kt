package com.morgan.alex.beardetail

import android.content.Context
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alex.morgan.bearlist.Bear
import com.squareup.picasso.Picasso
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_bear_detail.*
import javax.inject.Inject

class BearDetailFragment : Fragment(), BearDetailContract.View {

    companion object {
        private const val ARG_BEAR = "bear"

        fun forBear(bear: Bear): BearDetailFragment {
            val fragment = BearDetailFragment()
            val args = Bundle()
            /* Should be Parcelled... */
            args.putSerializable(ARG_BEAR, bear)
            fragment.arguments = args
            return fragment
        }
    }

    @Inject
    lateinit var presenter: BearDetailContract.Presenter

    private lateinit var selectedBear: Bear

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bear_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        selectedBear = arguments?.getSerializable(ARG_BEAR) as Bear
        presenter.attachView(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

    override fun showName(name: String) {
        bear_detail_name.text = selectedBear.name
    }

    override fun showImage(url: String) {
        Picasso.with(requireContext())
            .load(selectedBear.profileImageUrl)
            .error(android.R.drawable.ic_dialog_alert)
            .placeholder(R.drawable.grey_bear)
            .resize(400, 400)
            .centerCrop()
            .into(bear_detail_image)
    }

    override fun getBearArgument(): Bear {
        return selectedBear
    }
}
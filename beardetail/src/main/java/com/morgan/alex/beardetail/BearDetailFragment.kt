package com.morgan.alex.beardetail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alex.morgan.bearlist.Bear
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_bear_detail.*

class BearDetailFragment : Fragment() {

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

    private lateinit var selectedBear: Bear

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bear_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        selectedBear = arguments?.getSerializable(ARG_BEAR) as Bear

        bear_detail_name.text = selectedBear.name

        Picasso.with(view.context)
            .load(selectedBear.profileImageUrl)
            .error(android.R.drawable.ic_dialog_alert)
            .placeholder(R.drawable.grey_bear)
            .resize(400, 400)
            .centerCrop()
            .into(bear_detail_image)
    }
}
package com.self_development.ba_iac.mainfuntion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.self_development.ba_iac.databinding.FragmentCommunityBinding

class communityFragment : Fragment() {

    private var _binding: FragmentCommunityBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCommunityBinding.inflate(inflater, container, false)
        binding.communityTap.setOnClickListener {
            Toast.makeText(context, "ㅎㅇ", Toast.LENGTH_SHORT).show()
        }

        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
package com.self_development.ba_iac.mainfuntion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.self_development.ba_iac.R
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

        binding.profileTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_communityFragment_to_studentProfileFragment)
        }

        binding.organizeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_communityFragment_to_organizeFragment)
        }

        binding.raidBossTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_communityFragment_to_raidBossFragment)
        }

        binding.questTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_communityFragment_to_questFragment)
        }

        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
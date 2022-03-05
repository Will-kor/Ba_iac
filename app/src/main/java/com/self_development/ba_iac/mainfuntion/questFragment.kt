package com.self_development.ba_iac.mainfuntion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.self_development.ba_iac.R
import com.self_development.ba_iac.databinding.FragmentCommunityBinding
import com.self_development.ba_iac.databinding.FragmentQuestBinding

class questFragment : Fragment() {

    private var _binding: FragmentQuestBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentQuestBinding.inflate(inflater, container, false)

        binding.profileTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_questFragment_to_studentProfileFragment)
        }

        binding.organizeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_questFragment_to_organizeFragment)
        }

        binding.communityTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_questFragment_to_communityFragment)
        }

        binding.raidBossTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_questFragment_to_raidBossFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
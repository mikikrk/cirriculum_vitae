package com.mnowak.cirriculumvitae.di.viewModel

import androidx.lifecycle.ViewModel
import com.mnowak.cirriculumvitae.feature.moreInfo.MoreInfoRepository
import com.mnowak.cirriculumvitae.feature.moreInfo.MoreInfoViewModel
import com.mnowak.cirriculumvitae.feature.moreInfo.MoreInfoViewModelImpl
import com.mnowak.cirriculumvitae.feature.moreInfo.fragment.experience.ExperienceRepository
import com.mnowak.cirriculumvitae.feature.moreInfo.fragment.experience.ExperienceViewModel
import com.mnowak.cirriculumvitae.feature.moreInfo.fragment.experience.ExperienceViewModelImpl
import com.mnowak.cirriculumvitae.feature.personal.PersonalInfoRepository
import com.mnowak.cirriculumvitae.feature.personal.PersonalInfoViewModel
import com.mnowak.cirriculumvitae.feature.personal.PersonalInfoViewModelImpl
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ViewModelsModule {

    @Provides
    @IntoMap
    @ViewModelKey(PersonalInfoViewModel::class)
    fun providePersonalInfoVM(repository: PersonalInfoRepository): ViewModel = PersonalInfoViewModelImpl(repository)

    @Provides
    @IntoMap
    @ViewModelKey(MoreInfoViewModel::class)
    fun provideMoreInfoVM(repository: MoreInfoRepository): ViewModel = MoreInfoViewModelImpl(repository)

    @Provides
    @IntoMap
    @ViewModelKey(ExperienceViewModel::class)
    fun provideExperienceVM(repository: ExperienceRepository): ViewModel = ExperienceViewModelImpl(repository)
}

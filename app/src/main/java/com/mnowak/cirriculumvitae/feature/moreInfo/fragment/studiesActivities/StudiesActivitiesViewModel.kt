package com.mnowak.cirriculumvitae.feature.moreInfo.fragment.studiesActivities

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mnowak.cirriculumvitae.feature.moreInfo.fragment.studiesActivities.list.StudiesActivitiesItemViewModel
import com.mnowak.cirriculumvitae.feature.moreInfo.fragment.studiesActivities.list.StudiesActivitiesItemViewModelImpl
import com.mnowak.cirriculumvitae.liveData.map

abstract class StudiesActivitiesViewModel : ViewModel() {

    abstract val studiesActivities: LiveData<List<StudiesActivitiesItemViewModel>>
}

class StudiesActivitiesViewModelImpl(

        repository: StudiesActivitiesRepository

) : StudiesActivitiesViewModel() {

    override val studiesActivities: LiveData<List<StudiesActivitiesItemViewModel>> by lazy {
        repository.studiesActivities.map { studiesActivities ->
            studiesActivities?.map {
                StudiesActivitiesItemViewModelImpl(it) as StudiesActivitiesItemViewModel
            }
        }
    }
}

package com.example.bootcampnav_02

import android.content.Context
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.mockito.Mockito.`when`
import org.mockito.Mockito.anyInt
import org.mockito.Mockito.anyString
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions

class MainPresenterTest {

    lateinit var presenter: MainPresenter
    lateinit var view: MVPView

    @Before
    fun setup() {
        presenter = MainPresenter()
        view = mock(MVPView::class.java)
        presenter.onBind(view)

        verify(view).setViewListener(presenter)
        verifyNoMoreInteractions(view)
    }

    @After
    fun tearDown() {
        presenter.onUnbind()
    }

    @Test
    fun onSetNameClicked() {
        presenter.onSetNameClicked()

        verify(view).navigateToEditView()

        verifyNoMoreInteractions(view)
    }

    @Test
    fun onNameSet_nullName() {
        val emptyName = "Hi! My name is ______"
        val mockedContext = mock(Context::class.java)
        `when`(view.getContext()).thenReturn(mockedContext)
        `when`(mockedContext.getString(anyInt()))
            .thenReturn(emptyName)

        presenter.onNameSet(null)

        verify(view).setName(emptyName)
        verify(view).getContext()
        verifyNoMoreInteractions(view)
    }

    @Test
    fun onNameSet_nameJohnDoe() {
        val name = "Hi! My name is John Doe"
        val mockedContext = mock(Context::class.java)
        `when`(view.getContext()).thenReturn(mockedContext)
        `when`(mockedContext.getString(anyInt(), anyString()))
            .thenReturn(name)

        presenter.onNameSet(name)

        verify(view).setName(name)
        verify(view).getContext()
        verifyNoMoreInteractions(view)
    }
}

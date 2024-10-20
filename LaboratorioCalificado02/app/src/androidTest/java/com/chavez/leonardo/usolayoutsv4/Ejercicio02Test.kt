package com.chavez.leonardo.usolayoutsv4

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import android.content.Intent
import android.net.Uri
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.rule.IntentsTestRule
import org.hamcrest.CoreMatchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class Ejercicio02Test {

    @get:Rule
    val intentsTestRule = IntentsTestRule(Registro::class.java)

    @Test
    fun testUIElementsPresent() {
        onView(withId(R.id.etNombreCliente))
            .check(matches(isDisplayed()))
            .check(matches(withHint("Nombre Cliente")))

        onView(withId(R.id.etNumeroCliente))
            .check(matches(isDisplayed()))
            .check(matches(withHint("Número Cliente")))

        onView(withId(R.id.etProductos))
            .check(matches(isDisplayed()))
            .check(matches(withHint("Productos")))

        onView(withId(R.id.etCiudad))
            .check(matches(isDisplayed()))
            .check(matches(withHint("Ciudad")))

        onView(withId(R.id.etDireccion))
            .check(matches(isDisplayed()))
            .check(matches(withHint("Dirección")))

        onView(withId(R.id.btnRegistrar))
            .check(matches(isDisplayed()))
            .check(matches(withText("Registrar")))
    }

    @Test
    fun testInputValidation() {
        onView(withId(R.id.btnRegistrar)).perform(click())

        onView(withId(R.id.tilNombreCliente))
            .check(matches(hasDescendant(withText("Campo requerido"))))
        onView(withId(R.id.tilNumeroCliente))
            .check(matches(hasDescendant(withText("Campo requerido"))))
        onView(withId(R.id.tilProductos))
            .check(matches(hasDescendant(withText("Campo requerido"))))
        onView(withId(R.id.tilCiudad))
            .check(matches(hasDescendant(withText("Campo requerido"))))
        onView(withId(R.id.tilDireccion))
            .check(matches(hasDescendant(withText("Campo requerido"))))
    }

    @Test
    fun testNavigationToDetail() {
        fillForm()

        onView(withId(R.id.btnRegistrar)).perform(click())

        intended(hasComponent(DetailActivity::class.java.name))
    }

    @Test
    fun testCallIntent() {
        fillFormAndNavigate()

        onView(withId(R.id.btnLlamar)).perform(click())

        intended(allOf(
            hasAction(Intent.ACTION_DIAL),
            hasData(Uri.parse("tel:987654321"))
        ))
    }

    @Test
    fun testWhatsAppIntent() {
        fillFormAndNavigate()

        onView(withId(R.id.btnWhatsapp)).perform(click())

        val mensaje = "Hola Juan Perez Tus productos: Laptop Gaming están en camino a la dirección: Av. Principal 123"
        intended(allOf(
            hasAction(Intent.ACTION_VIEW),
            hasData(Uri.parse("https://api.whatsapp.com/send?phone=987654321&text=${Uri.encode(mensaje)}"))
        ))
    }

    @Test
    fun testMapsIntent() {
        fillFormAndNavigate()

        onView(withId(R.id.btnMaps)).perform(click())

        intended(allOf(
            hasAction(Intent.ACTION_VIEW),
            hasData(Uri.parse("geo:0,0?q=Lima Av. Principal 123"))
        ))
    }

    private fun fillForm() {
        onView(withId(R.id.etNombreCliente))
            .perform(typeText("Juan Perez"), closeSoftKeyboard())
        onView(withId(R.id.etNumeroCliente))
            .perform(typeText("987654321"), closeSoftKeyboard())
        onView(withId(R.id.etProductos))
            .perform(typeText("Laptop Gaming"), closeSoftKeyboard())
        onView(withId(R.id.etCiudad))
            .perform(typeText("Lima"), closeSoftKeyboard())
        onView(withId(R.id.etDireccion))
            .perform(typeText("Av. Principal 123"), closeSoftKeyboard())
    }

    private fun fillFormAndNavigate() {
        fillForm()
        onView(withId(R.id.btnRegistrar)).perform(click())
    }
}
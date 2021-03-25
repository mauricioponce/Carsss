package cl.dal.cars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import timber.log.Timber

/**
 * [X] control de versiones
 * [ ] Consumo de datos API
 *      [X] permiso de internet
 *      [X] cleartext si es https   -> eliminar para probar después
 *      [X] dependencias de retrofit
 *      [X] POJOs (listado y detalle)
 *      [X] interfaz de operaciones
 *      [X] cliente de retrofit
 * [X] Repositorio
 * [X] ViewModel
 * [X] activar viewBinding
 * [X] modificar el activity_main.xml
 * [ ] Fragmento de listado
 *      [X] layout del fragmento
 *      [ ] layout del item
 *      [ ] adapter + viewholder + recyclerview
 *      [X] modificar para usar viewBinding
 *      [ ] onClick para elemento del listado
 * [ ] Fragmento de detalle
 * [ ] Manejo de persistencia con ROOM
 * [ ] test unitario
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLog()
    }

    private fun initLog() {
        Timber.plant(Timber.DebugTree())
    }
}
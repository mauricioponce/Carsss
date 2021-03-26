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
 * [X] Fragmento de listado
 *      [X] layout del fragmento
 *      [X] layout del item
 *      [X] adapter + viewholder + recyclerview
 *      [X] modificar para usar viewBinding
 *      [X] onClick para elemento del listado
 * [X] Fragmento de detalle
 *      [X] crear el layout del detalle
 *      [X] crear el fragmento que recibe 1 parámetro (id del auto)
 *      [X] crear el viewmodel para consumir los datos del detalle
 * [ ] Manejo de persistencia con ROOM
 *      [X] dependencias
 *      [X] DAO
 *      [X] cliente de base de datos
 *      [X] clase que extiende de application para inicializar la base de datos
 *      [X] agregar al manifest application
 *      [X] actualizar repo para leer de base de datos
 * [X] refactorización y limpieza (analyze -> inspect code)
 * [X] test unitario
 * [ ] loading
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
try {

            val myDataBase = this.openOrCreateDatabase("Muzisyen", MODE_PRIVATE,null) // Burda Data Base Oluşuyor Muzisyen Diye
            myDataBase.execSQL("CREATE TABLE IF NOT EXISTS muzisyenn (id INTEGER PRIMARY KEY,name VARCHAR,age INT)") // Burda muzisyenn Tablosu Açılıyor

            /*myDataBase.execSQL("INSERT INTO muzisyenn (name,age) VALUES('Barış Manco',56)") // Burda Sanatcılar Ekleniyor
            myDataBase.execSQL("INSERT INTO muzisyenn (name,age) VALUES('Neşet Ertaş',74)")
            myDataBase.execSQL("INSERT INTO muzisyenn (name,age) VALUES('Aşık Veysel',78)")
             */

            val cursor = myDataBase.rawQuery("SELECT * FROM muzisyenn WHERE name LIKE 'Aş%el'",null) // Burda Aş İle BAşlayıp el İle Biten SAnatcı İsmi Arıyor
            val name = cursor.getColumnIndex("name")
            val age = cursor.getColumnIndex("age")
            val id = cursor.getColumnIndex("id")

            while (cursor.moveToNext()) {
                println("${cursor.getString(name)} + ${cursor.getInt(age)} + ${cursor.getInt(id)}")
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

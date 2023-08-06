try {

            val myDataBase = this.openOrCreateDatabase("Muzisyen", MODE_PRIVATE,null)
            myDataBase.execSQL("CREATE TABLE IF NOT EXISTS muzisyenn (id INTEGER PRIMARY KEY,name VARCHAR,age INT)")


            /*myDataBase.execSQL("INSERT INTO muzisyenn (name,age) VALUES('Barış Manco',56)") //İd = 1
            myDataBase.execSQL("INSERT INTO muzisyenn (name,age) VALUES('Aşık Veysel',78)") //İd = 2
            myDataBase.execSQL("INSERT INTO muzisyenn (name,age) VALUES('Neşet Ertaş',74)") //İd = 3

             */

            myDataBase.execSQL("UPDATE muzisyenn SET age = 78 WHERE id = 2")
            // myDataBase.execSQL("DELETE FROM muzisyenn WHERE name = 'Neşet Ertaş'")

            val cursor = myDataBase.rawQuery("SELECT * FROM muzisyenn WHERE name LIKE 'Ne%aş'",null)
            val name = cursor.getColumnIndex("name")
            val age = cursor.getColumnIndex("age")
            val id = cursor.getColumnIndex("id")

            while (cursor.moveToNext()) {
                println("${cursor.getString(name)} + ${cursor.getInt(age)} + ${cursor.getInt(id)}")
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

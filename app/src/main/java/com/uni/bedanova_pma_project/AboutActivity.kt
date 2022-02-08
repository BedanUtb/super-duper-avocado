package com.uni.bedanova_pma_project

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)


        val text_about1 = findViewById<TextView>(R.id.text_about_part1)
        text_about1.text = "The International Space Station (ISS) is a modular space station (habitable artificial satellite) in low Earth orbit." +
                " It is a multinational collaborative project involving five participating space agencies: NASA (United States), Roscosmos (Russia)," +
                " JAXA (Japan), ESA (Europe), and CSA (Canada). The ownership and use of the space station is established by intergovernmental " +
                "treaties and agreements. The station serves as a microgravity and space environment research laboratory in which scientific research is " +
                "conducted in astrobiology, astronomy, meteorology, physics, and other fields. The ISS is suited for testing the spacecraft " +
                "systems and equipment required for possible future long-duration missions to the Moon and Mars."

        val text_about2 = findViewById<TextView>(R.id.text_about_part2)
        text_about2.text ="The ISS programme evolved from the Space Station Freedom, an American proposal which was conceived in 1984 to construct a permanently" +
                " manned Earth-orbiting station, and the contemporaneous Soviet/Russian Mir-2 proposal with similar aims. The ISS is the ninth space station " +
                "to be inhabited by crews, following the Soviet and later Russian Salyut, Almaz, and Mir stations and the U.S. Skylab. It is the largest artificial " +
                "object in space and the largest satellite in low Earth orbit, regularly visible to the naked eye from Earth's surface. It maintains an orbit " +
                "with an average altitude of 400 kilometres (250 mi) by means of reboost manoeuvres using the engines of the Zvezda Service Module or visiting " +
                "spacecraft. The ISS circles the Earth in roughly 93 minutes, completing 15.5 orbits per day."

        val text_about3 = findViewById<TextView>(R.id.text_about_part3)
        text_about2.text ="The station is divided into two sections: the Russian Orbital Segment (ROS), operated by Russia; and the United States Orbital Segment (USOS)," +
                " which is shared by many nations. Roscosmos has endorsed the continued operation of ROS through 2024,[19] having previously proposed using elements of " +
                "the segment to construct a new Russian space station called OPSEK. The first ISS component was launched in 1998, and the first long-term residents " +
                "arrived on 2 November 2000. The station has since been continuously occupied for 20 years and 61 days, the longest continuous human presence in " +
                "low Earth orbit, having surpassed the previous record of 9 years and 357 days held by the Mir space station. The latest major pressurised module, Leonardo, " +
                "was fitted in 2011 and an experimental inflatable space habitat was added in 2016. Development and assembly of the station continues, with several major " +
                "new Russian elements scheduled for launch starting in 2020. As of December 2018, the station is expected to operate until 2030."

        /*val button_get_location = findViewById<Button>(R.id.button_get_location)
        button_get_location.setOnClickListener{
            val intent = Intent(this, GetLocationActivity::class.java)
            startActivity(intent)
        }

        val button_saved = findViewById<Button>(R.id.button_saved_locations)
        button_get_location.setOnClickListener{
            val intent = Intent(this, GetLocationActivity::class.java)
            startActivity(intent)
        }*/
    }
}
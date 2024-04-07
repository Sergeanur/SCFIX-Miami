MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ********************************** AUDIO SCRIPT *****************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME audio

SET_DEATHARREST_STATE OFF

{

START_NEW_SCRIPT mission_start_aud

MISSION_END

}

mission_start_aud:
{

SCRIPT_NAME audio1 

// variables for the audio

// Biker bar

VAR_INT bike_bar_loop1 bike_bar_loop2 bike_bar_loop3

VAR_INT biker_bar_sound1_added biker_bar_sound2_added biker_bar_sound3_added

// Malibu

VAR_INT malibu_loop1 malibu_loop2 malibu_loop3

VAR_INT malibu_sound1_playing

VAR_INT malibu_sound2_playing

VAR_INT malibu_sound3_playing

// pole position

VAR_INT strip_loop1 strip_loop2 strip_loop3

VAR_INT strip_bar_sound1_playing strip_bar_sound2_playing strip_bar_sound3_playing

// Fountains

VAR_INT fountain_loop1 fountain_loop2

VAR_INT fountain_sound1_added fountain_sound2_added

// Church

VAR_INT church_loop1 church_sounds_added


// Biker bar

biker_bar_sound1_added = 0

biker_bar_sound2_added = 0

biker_bar_sound3_added = 0

// Malibu

malibu_sound1_playing = 0

malibu_sound2_playing = 0

malibu_sound3_playing = 0

// Pole Position

strip_bar_sound1_playing = 0

strip_bar_sound2_playing = 0

strip_bar_sound3_playing = 0

// Churches

church_sounds_added = 0

// fountains

fountain_sound1_added = 0

fountain_sound2_added = 0

// ********************************************* START OF SCRIPT ***************************

mission_start_aud_inner:

WAIT 500

GET_TIME_OF_DAY hours_s minutes_s

IF IS_PLAYER_PLAYING player1
	  		  
// BIKER BAR SOUNDLOOP1

	IF IS_PLAYER_IN_ZONE player1 DTOWN  // Downtown
					
		IF flag_bikers_mission1_passed = 0 
	 
			IF biker_bar_sound1_added = 0
				ADD_CONTINUOUS_SOUND -596.018 640.916 12.0 SOUND_NEW_BUILDING_BAR_1 bike_bar_loop1	//Biker bar
				biker_bar_sound1_added = 1
			ENDIF

		ENDIF

		IF flag_bikers_mission1_passed = 1
		 
			IF flag_bikers_mission2_passed = 0 
	 
				IF biker_bar_sound2_added = 0
					ADD_CONTINUOUS_SOUND -596.018 640.916 12.0 SOUND_NEW_BUILDING_BAR_2 bike_bar_loop2	//Biker bar
					biker_bar_sound2_added = 1
				ENDIF

			ENDIF

		ENDIF

		IF flag_bikers_mission1_passed = 1

			IF flag_bikers_mission2_passed = 1

				IF flag_bikers_mission3_passed = 0 
			 
					IF biker_bar_sound3_added = 0
						ADD_CONTINUOUS_SOUND -596.018 640.916 12.0 SOUND_NEW_BUILDING_BAR_3 bike_bar_loop3	//Biker bar
						biker_bar_sound3_added = 1
					ENDIF

				ENDIF

			ENDIF

		ENDIF
						
	ELSE
				
		IF biker_bar_sound1_added = 1
			REMOVE_SOUND bike_bar_loop1
			biker_bar_sound1_added = 0
		ENDIF

		IF biker_bar_sound2_added = 1
			REMOVE_SOUND bike_bar_loop2
			biker_bar_sound2_added = 0
		ENDIF

		IF biker_bar_sound3_added = 1
			REMOVE_SOUND bike_bar_loop3
			biker_bar_sound3_added = 0
		ENDIF
						
	ENDIF 

// MALIBU SOUNDLOOP2
				   
	IF IS_PLAYER_IN_ZONE player1 BEACH3	// Vice point
		 			 
		IF hours_s >= 23
		OR hours_s < 7
		   		   				 			   		   
			IF malibu_sound1_playing = 0
			AND malibu_sound2_playing = 0
			AND malibu_sound3_playing = 0
				ADD_CONTINUOUS_SOUND 494.652 -83.347 10.032 SOUND_NEW_BUILDING_MALIBU_1 malibu_loop1
				malibu_sound1_playing = 1
			ENDIF

		ELSE

			IF malibu_sound1_playing = 1
				REMOVE_SOUND malibu_loop1
				malibu_sound1_playing = 0
			ENDIF	
						
		ENDIF

		IF hours_s >= 7
		AND hours_s < 15
	   	   		   				 			   		   
			IF malibu_sound2_playing = 0
			AND malibu_sound1_playing = 0
			AND malibu_sound3_playing = 0 
				ADD_CONTINUOUS_SOUND 494.652 -83.347 10.032 SOUND_NEW_BUILDING_MALIBU_2 malibu_loop2
				malibu_sound2_playing = 1
			ENDIF

		ELSE

			IF malibu_sound2_playing = 1
				REMOVE_SOUND malibu_loop2
				malibu_sound2_playing = 0
			ENDIF
					
		ENDIF

		IF hours_s >= 15
		AND hours_s < 23
	  	 		 				 			   		   
			IF malibu_sound3_playing = 0
			AND malibu_sound1_playing = 0
			AND malibu_sound2_playing = 0
				ADD_CONTINUOUS_SOUND 494.652 -83.347 10.032 SOUND_NEW_BUILDING_MALIBU_3 malibu_loop3
				malibu_sound3_playing = 1
			ENDIF

		ELSE

			IF malibu_sound3_playing = 1
				REMOVE_SOUND malibu_loop3
				malibu_sound3_playing = 0
			ENDIF
			
		ENDIF
		
	ELSE

		IF malibu_sound1_playing = 1
			REMOVE_SOUND malibu_loop1
			malibu_sound1_playing = 0
		ENDIF
	   		   
		IF malibu_sound2_playing = 1
			REMOVE_SOUND malibu_loop2
			malibu_sound2_playing = 0
		ENDIF

		IF malibu_sound3_playing = 1
			REMOVE_SOUND malibu_loop3
			malibu_sound3_playing = 0
		ENDIF
						
	ENDIF

// POLE POSITION

	IF IS_PLAYER_IN_ZONE player1 BEACH1 // Ocean Beach

		IF hours_s >= 23
		OR hours_s < 7
		  		  
			IF strip_bar_sound1_playing = 0
			AND strip_bar_sound2_playing = 0 
			AND strip_bar_sound3_playing = 0
				ADD_CONTINUOUS_SOUND 87.738 -1456.117 11.0 SOUND_NEW_BUILDING_STRIP_1 strip_loop1 //Strip club
				strip_bar_sound1_playing = 1
			ENDIF

		ELSE

			IF strip_bar_sound1_playing = 1
				REMOVE_SOUND strip_loop1
				strip_bar_sound1_playing = 0
			ENDIF
								   
		ENDIF

		IF hours_s >= 7
		AND hours_s < 15
		   		   
			IF strip_bar_sound2_playing = 0
			AND strip_bar_sound1_playing = 0
			AND strip_bar_sound3_playing = 0
				ADD_CONTINUOUS_SOUND 87.738 -1456.117 11.0 SOUND_NEW_BUILDING_STRIP_2 strip_loop2 //Strip club
				strip_bar_sound2_playing = 1
			ENDIF

		ELSE
			
			IF strip_bar_sound2_playing = 1
				REMOVE_SOUND strip_loop2
				strip_bar_sound2_playing = 0
			ENDIF

		ENDIF
				
		IF hours_s >= 15
		AND hours_s < 23
							   									
			IF strip_bar_sound3_playing = 0
			AND strip_bar_sound1_playing = 0
			AND strip_bar_sound2_playing = 0
				ADD_CONTINUOUS_SOUND 87.738 -1456.117 11.0 SOUND_NEW_BUILDING_STRIP_3 strip_loop3 //Strip club
				strip_bar_sound3_playing = 1
			ENDIF

		ELSE

			IF strip_bar_sound3_playing = 1
				REMOVE_SOUND strip_loop3
				strip_bar_sound3_playing = 0
			ENDIF
					
		ENDIF

// Church

		IF hours_s = 10
		
			IF church_sounds_added = 0 
				ADD_CONTINUOUS_SOUND -76.074 -1528.485 13.397 SOUND_NEW_BUILDING_CHURCH church_loop1 // Church in Washington  
				church_sounds_added = 1
			ENDIF

		ELSE

			IF church_sounds_added = 1 
				REMOVE_SOUND church_loop1 // Church in Washington  
				church_sounds_added = 0
			ENDIF

		ENDIF

// fountain

		IF fountain_sound1_added = 0
			ADD_CONTINUOUS_SOUND -67.015 -1546.671 11.485 SOUND_NEW_WATERFALL fountain_loop1 // Fountain by church 
			fountain_sound1_added = 1
		ENDIF
								
	ELSE
					
		IF strip_bar_sound1_playing = 1
			REMOVE_SOUND strip_loop1
			strip_bar_sound1_playing = 0
		ENDIF

		IF strip_bar_sound2_playing = 1
			REMOVE_SOUND strip_loop2
			strip_bar_sound2_playing = 0
		ENDIF
			
		IF strip_bar_sound3_playing = 1
			REMOVE_SOUND strip_loop3
			strip_bar_sound3_playing = 0
		ENDIF

		IF church_sounds_added = 1 
			REMOVE_SOUND church_loop1 // Church in Washington  
			church_sounds_added = 0
		ENDIF
	
		IF fountain_sound1_added = 1
			REMOVE_SOUND fountain_loop1 // Fountain by church 
			fountain_sound1_added = 0
		ENDIF
						
	ENDIF
		
	IF IS_PLAYER_IN_ZONE player1 PORNI
				
		IF fountain_sound2_added = 0
			ADD_CONTINUOUS_SOUND 9.637 1092.344 17.211 SOUND_NEW_WATERFALL fountain_loop2 // Fountain in porn island
			fountain_sound2_added = 1
		ENDIF
								
	ELSE

		IF fountain_sound2_added = 1
			REMOVE_SOUND fountain_loop2
			fountain_sound2_added = 0
		ENDIF
				
	ENDIF
										      	
ENDIF

GOTO mission_start_aud_inner 

}

// SCFIX: Start - moved this stuff from porn3.sc to create a separate script thread
load_camera_audio_loop: // SCFIX
{
	SCRIPT_NAME PRN3CAM

load_camera_audio_loop_inner:

	WAIT 0
	IF cam_audio1 = 0
		// SCFIX - START
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			WAIT 0
		ENDWHILE 
		CLEAR_MISSION_AUDIO 1
		// SCFIX - END
		LOAD_MISSION_AUDIO 1 CAML
		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			WAIT 0
		ENDWHILE 
		cam_audio1 = 1
	ENDIF

	IF cam_audio2 = 0
		// SCFIX - START
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
			WAIT 0
		ENDWHILE 
		CLEAR_MISSION_AUDIO 2
		// SCFIX - END
		LOAD_MISSION_AUDIO 2 CAMR
		WHILE NOT HAS_MISSION_AUDIO_LOADED 2
			WAIT 0
		ENDWHILE 
		cam_audio2 = 1
	ENDIF

	GOTO load_camera_audio_loop_inner // SCFIX
}

RETURN
// SCFIX: End

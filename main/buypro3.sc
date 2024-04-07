MISSION_START
			  
// SCFIX: START - fix SSU shit
GOSUB mission_start_buypro3

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_deatharrest_buypro3
ENDIF

GOSUB mission_cleanup_buypro3

MISSION_END
// SCFIX: END

mission_start_buypro3:

SCRIPT_NAME	buypro3

flag_player_on_mission = 1
{ // SCFIX: scope moved up, was after WAIT 0

// SCFIX: START
LVAR_INT flag_buypro3_set1
LVAR_INT flag_buypro3_set2
flag_buypro3_set1 = 0
flag_buypro3_set2 = 0
// SCFIX: END

SET_PLAYER_CONTROL player1 OFF // SCFIX: paranoid set before wait

WAIT 0

	GOSUB buypro3_set1 // SCFIX: moved stuff into a subroutine
	
	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT
	SET_PLAYER_CONTROL player1 OFF
	SET_EVERYONE_IGNORE_PLAYER player1 TRUE
	SET_ALL_CARS_CAN_BE_DAMAGED FALSE
	WHILE GET_FADING_STATUS
		WAIT 0
		/* SCFIX: remove this shit
		IF NOT IS_PLAYER_PLAYING player1
			//ADD_SPRITE_BLIP_FOR_CONTACT_POINT bankjobX bankjobY bankjobZ the_bankjob_blip bankjob_contact_blip  // SCFIX: moved into mobile.sc
			//START_NEW_SCRIPT bankjob_mission1_loop // SCFIX: moved into mobile.sc
			flag_bought_malibu = 1
			TERMINATE_THIS_SCRIPT
		ENDIF
		*/
	ENDWHILE

	CLEAR_AREA 495.6510 -84.2263 8.9929 1.0 TRUE
	SET_PLAYER_COORDINATES player1 495.6510 -84.2263 8.9929
	SET_PLAYER_HEADING player1 47.6086
	SWITCH_WIDESCREEN ON

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_IN

	SET_FIXED_CAMERA_POSITION 505.4001 -107.8699 12.9888 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 504.9025 -107.0028 12.9664 JUMP_CUT
	
	WHILE GET_FADING_STATUS
		WAIT 0
		/* SCFIX: remove this shit
		IF NOT IS_PLAYER_PLAYING player1
			//ADD_SPRITE_BLIP_FOR_CONTACT_POINT bankjobX bankjobY bankjobZ the_bankjob_blip bankjob_contact_blip // SCFIX: moved into mobile.sc
			//START_NEW_SCRIPT bankjob_mission1_loop // SCFIX: moved into mobile.sc
			flag_bought_malibu = 1
			TERMINATE_THIS_SCRIPT
		ENDIF
		*/
	ENDWHILE
	
	PRINT_WITH_NUMBER_BIG BANKBUY bankbuy_price 5000 6 //"The Malibu purchased: $ 15000"
	GOSUB buypro3_set2 // SCFIX: moved stuff into a subroutine
	PLAY_MISSION_PASSED_TUNE 1
	SET_MUSIC_DOES_FADE FALSE
	
	WAIT 4000
	
	/* SCFIX: remove this shit
	IF NOT IS_PLAYER_PLAYING player1
		SET_MUSIC_DOES_FADE TRUE
		//ADD_SPRITE_BLIP_FOR_CONTACT_POINT bankjobX bankjobY bankjobZ the_bankjob_blip bankjob_contact_blip // SCFIX: moved into mobile.sc
		//START_NEW_SCRIPT bankjob_mission1_loop // SCFIX: moved into mobile.sc
		flag_bought_malibu = 1
		TERMINATE_THIS_SCRIPT
	ENDIF
	*/

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT

	WHILE GET_FADING_STATUS
		WAIT 0
		/* SCFIX: remove this shit
		IF NOT IS_PLAYER_PLAYING player1
			SET_MUSIC_DOES_FADE TRUE
			//ADD_SPRITE_BLIP_FOR_CONTACT_POINT bankjobX bankjobY bankjobZ the_bankjob_blip bankjob_contact_blip // SCFIX: moved into mobile.sc
			//START_NEW_SCRIPT bankjob_mission1_loop // SCFIX: moved into mobile.sc
			flag_bought_malibu = 1
			TERMINATE_THIS_SCRIPT
		ENDIF
		*/
	ENDWHILE
	
	
	SET_CAMERA_BEHIND_PLAYER
	RESTORE_CAMERA_JUMPCUT

	SET_PLAYER_CONTROL player1 ON
	SET_EVERYONE_IGNORE_PLAYER player1 FALSE
	SET_ALL_CARS_CAN_BE_DAMAGED TRUE
	SWITCH_WIDESCREEN OFF
	
	//ADD_SPRITE_BLIP_FOR_CONTACT_POINT bankjobX bankjobY bankjobZ the_bankjob_blip bankjob_contact_blip // SCFIX: moved into mobile.sc
	
	//START_NEW_SCRIPT bankjob_mission1_loop // SCFIX: moved into mobile.sc

	flag_bought_malibu = 1
	
	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_IN
	
	WHILE GET_FADING_STATUS
		WAIT 0
		/* SCFIX: remove this shit
		IF NOT IS_PLAYER_PLAYING player1
			SET_MUSIC_DOES_FADE TRUE
			TERMINATE_THIS_SCRIPT
		ENDIF
		*/
	ENDWHILE

	RETURN // SCFIX

// SCFIX: START
buypro3_set1:
IF flag_buypro3_set1 = 0
	REMOVE_BLIP bankjob_contact_blip
	REMOVE_BLIP bankbuy_blip
	PLAYER_MADE_PROGRESS 1
	flag_buypro3_set1 = 1
ENDIF
RETURN

buypro3_set2:
IF flag_buypro3_set2 = 0
	ADD_MONEY_SPENT_ON_PROPERTY bankbuy_price
	SET_PROPERTY_AS_OWNED PROP_MALIBU
	flag_buypro3_set2 = 1
ENDIF
RETURN

mission_deatharrest_buypro3:
GOSUB buypro3_set1
GOSUB buypro3_set2
RETURN
// SCFIX: END

mission_cleanup_buypro3: // SCFIX
	flag_bought_malibu = 1 // SCFIX
	
	SET_MUSIC_DOES_FADE TRUE
	
START_NEW_SCRIPT malibu_save_loop
						
flag_player_on_mission = 0

MISSION_HAS_FINISHED
//MISSION_END  // SCFIX: moved up

}
RETURN 


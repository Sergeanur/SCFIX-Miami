MISSION_START
			  
// FIXMIAMI: START - fix SSU shit
GOSUB mission_start_ochebuy

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_deatharrest_ochebuy
ENDIF

GOSUB mission_cleanup_ochebuy

MISSION_END
// FIXMIAMI: END

mission_start_ochebuy:

SCRIPT_NAME	ochebuy

flag_player_on_mission = 1
{ // FIXMIAMI: scope moved up, was after WAIT 0

// FIXMIAMI: START
LVAR_INT flag_ochebuy_set1
LVAR_INT flag_ochebuy_set2
LVAR_INT flag_ochebuy_set3
LVAR_INT flag_ochebuy_set4
flag_ochebuy_set1 = 0
flag_ochebuy_set2 = 0
flag_ochebuy_set3 = 0
flag_ochebuy_set4 = 0
// FIXMIAMI: END

SET_PLAYER_CONTROL player1 OFF // FIXMIAMI: paranoid set before wait

WAIT 0

	GOSUB ochebuy_set1 // FIXMIAMI: moved stuff into a subroutine

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT
	SET_PLAYER_CONTROL player1 OFF
	SET_EVERYONE_IGNORE_PLAYER player1 TRUE
	SET_ALL_CARS_CAN_BE_DAMAGED FALSE
	WHILE GET_FADING_STATUS
		WAIT 0
		/* FIXMIAMI: remove this shit
		IF NOT IS_PLAYER_PLAYING player1
			ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT ochebuyX ochebuyY ochebuyZ RADAR_SPRITE_SAVEHOUSE ochebuy_blip 
			CHANGE_BLIP_DISPLAY ochebuy_blip BLIP_ONLY
			START_NEW_SCRIPT ochesave1_save_loop
			TERMINATE_THIS_SCRIPT
		ENDIF
		*/
	ENDWHILE

	GOSUB ochebuy_set2 // FIXMIAMI: moved stuff into a subroutine

	CLEAR_AREA 14.4571 -1498.5939 12.1974 1.0 TRUE
	SET_PLAYER_COORDINATES player1 14.4571 -1498.5939 12.1974
	SET_PLAYER_HEADING player1 353.8286
	SWITCH_WIDESCREEN ON

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_IN

	SET_FIXED_CAMERA_POSITION -9.9202 -1467.0503 10.1140 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT -9.3760 -1467.8127 10.4639 JUMP_CUT

	WHILE GET_FADING_STATUS
		WAIT 0
		/* FIXMIAMI: remove this shit
		IF NOT IS_PLAYER_PLAYING player1
			TERMINATE_THIS_SCRIPT
		ENDIF
		*/
	ENDWHILE

	PRINT_WITH_NUMBER_BIG OCHEBUY ochebuy_price 5000 6 //Ocean Heights Apartment purchased: $ ~1~
	GOSUB ochebuy_set3 // FIXMIAMI: moved stuff into a subroutine
	PLAY_MISSION_PASSED_TUNE 1
	SET_MUSIC_DOES_FADE FALSE

	WAIT 2000

//	IF NOT IS_PLAYER_PLAYING player1
//		SET_MUSIC_DOES_FADE TRUE
//		TERMINATE_THIS_SCRIPT
//	ENDIF
//
//	SET_FIXED_CAMERA_POSITION 18.5316 -1497.9888 13.6879 0.0 0.0 0.0
//	POINT_CAMERA_AT_POINT 17.6983 -1498.5264 13.5598 JUMP_CUT

	PRINT_NOW BUYSAVE 3000 1//~g~You can now save your game here for free.

	WAIT 3000

	SET_FIXED_CAMERA_POSITION 17.7346 -1467.6738 18.6329 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 18.0802 -1468.5117 18.2106 JUMP_CUT

	PRINT_NOW BUYGARG 3000 1//~g~You can also store vehicles in this garage.
	GOSUB ochebuy_set4 // FIXMIAMI: moved stuff into a subroutine

	WAIT 3000

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT

	WHILE GET_FADING_STATUS
		WAIT 0
		/* FIXMIAMI: remove this shit
		IF NOT IS_PLAYER_PLAYING player1
			SET_MUSIC_DOES_FADE TRUE
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

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_IN

	GOSUB get_fading_status

	RETURN // FIXMIAMI

// FIXMIAMI: START

ochebuy_set1:
IF flag_ochebuy_set1 = 0
	REMOVE_BLIP ochebuy_blip
	PLAYER_MADE_PROGRESS 1
	flag_ochebuy_set1 = 1
ENDIF
RETURN

ochebuy_set2:
IF flag_ochebuy_set2 = 0
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT ochebuyX ochebuyY ochebuyZ RADAR_SPRITE_SAVEHOUSE ochebuy_blip 
	CHANGE_BLIP_DISPLAY ochebuy_blip BLIP_ONLY
	START_NEW_SCRIPT ochesave1_save_loop
	flag_ochebuy_set2 = 1
ENDIF
RETURN

ochebuy_set3:
IF flag_ochebuy_set3 = 0
	ocean_heights_bought = 1
	//CREATE_CLOTHES_PICKUP 19.4 -1501.1 13.2 1 safehouse_clothes7   
	safehouse_created7 = 1
	ADD_MONEY_SPENT_ON_PROPERTY ochebuy_price
	SET_PROPERTY_AS_OWNED PROP_OCEANHEIGHTS
	//ochebuy_price *= -1
	//ADD_SCORE player1 ochebuy_price
	flag_ochebuy_set3 = 1
ENDIF
RETURN

ochebuy_set4:
IF flag_ochebuy_set4 = 0
	CHANGE_GARAGE_TYPE ochebuy_save_garage GARAGE_HIDEOUT_FIVE 
	flag_ochebuy_set4 = 1
ENDIF
RETURN

mission_deatharrest_ochebuy:
	GOSUB ochebuy_set1
	GOSUB ochebuy_set2
	GOSUB ochebuy_set3
	GOSUB ochebuy_set4
	RETURN
// FIXMIAMI: END

mission_cleanup_ochebuy: // FIXMIAMI
	SET_MUSIC_DOES_FADE TRUE
					
												
flag_player_on_mission = 0

MISSION_HAS_FINISHED
//MISSION_END // FIXMIAMI: moved up

}
RETURN 


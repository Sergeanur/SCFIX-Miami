MISSION_START
			  
// FIXMIAMI: START - fix SSU shit
GOSUB mission_start_buypro5

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_deatharrest_buypro5
ENDIF

GOSUB mission_cleanup_buypro5

MISSION_END
// FIXMIAMI: END

mission_start_buypro5:

SCRIPT_NAME	buypro5

flag_player_on_mission = 1
{ // FIXMIAMI: scope moved up, was after WAIT 0

// FIXMIAMI: START
LVAR_INT flag_buypro5_set1
LVAR_INT flag_buypro5_set2
LVAR_INT flag_buypro5_set3
LVAR_INT flag_buypro5_set4
flag_buypro5_set1 = 0
flag_buypro5_set2 = 0
flag_buypro5_set3 = 0
flag_buypro5_set4 = 0
// FIXMIAMI: END

SET_PLAYER_CONTROL player1 OFF // FIXMIAMI: paranoid set before wait

WAIT 0

	GOSUB buypro5_set1 // FIXMIAMI: moved stuff into a subroutine

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT
	SET_PLAYER_CONTROL player1 OFF
	SET_EVERYONE_IGNORE_PLAYER player1 TRUE
	SET_ALL_CARS_CAN_BE_DAMAGED FALSE
	WHILE GET_FADING_STATUS
		WAIT 0
		/* FIXMIAMI: remove this shit
		IF NOT IS_PLAYER_PLAYING player1
			ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT nbmnbuyX nbmnbuyY nbmnbuyZ RADAR_SPRITE_SAVEHOUSE nbmnbuy_blip 
			CHANGE_BLIP_DISPLAY nbmnbuy_blip BLIP_ONLY
			START_NEW_SCRIPT nbmnsave1_save_loop
			TERMINATE_THIS_SCRIPT
		ENDIF
		*/
	ENDWHILE

	GOSUB buypro5_set2 // FIXMIAMI: moved stuff into a subroutine

	CLEAR_AREA 428.3730 608.9806 11.6898 1.0 TRUE
	SET_PLAYER_COORDINATES player1 428.3730 608.9806 11.6898
	SET_PLAYER_HEADING player1 0.0
	SWITCH_WIDESCREEN ON

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_IN

	SET_FIXED_CAMERA_POSITION 415.9304 640.0891 12.9833 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 416.2365 639.1425 13.0847 JUMP_CUT

	WHILE GET_FADING_STATUS
		WAIT 0
		/* FIXMIAMI: remove this shit
		IF NOT IS_PLAYER_PLAYING player1
			TERMINATE_THIS_SCRIPT
		ENDIF
		*/
	ENDWHILE

	PRINT_WITH_NUMBER_BIG NBMNBUY nbmnbuy_price 5000 6 //"Elswanko Casa purchased: $ 15000"
	GOSUB buypro5_set3 // FIXMIAMI: moved stuff into a subroutine
	PLAY_MISSION_PASSED_TUNE 1
	SET_MUSIC_DOES_FADE FALSE

	WAIT 2000

//	IF NOT IS_PLAYER_PLAYING player1
//		SET_MUSIC_DOES_FADE TRUE
//		TERMINATE_THIS_SCRIPT
//	ENDIF
//
//	SET_FIXED_CAMERA_POSITION 431.1143 614.5876 19.6257 0.0 0.0 0.0
//	POINT_CAMERA_AT_POINT 430.9002 613.8718 18.9610 JUMP_CUT

	PRINT_NOW BUYSAVE 3000 1//~g~You can now save your game here for free.

	WAIT 3000

	SET_FIXED_CAMERA_POSITION 427.8130 650.6702 15.3209 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 428.6758 650.2003 15.1346 JUMP_CUT

	PRINT_NOW BUYGARG 3000 1//~g~You can also store vehicles in this garage.
	GOSUB buypro5_set4 // FIXMIAMI: moved stuff into a subroutine

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
buypro5_set1:
IF flag_buypro5_set1 = 0
	REMOVE_BLIP nbmnbuy_blip
	PLAYER_MADE_PROGRESS 1
	flag_buypro5_set1 = 1
ENDIF
RETURN

buypro5_set2:
IF flag_buypro5_set2 = 0
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT nbmnbuyX nbmnbuyY nbmnbuyZ RADAR_SPRITE_SAVEHOUSE nbmnbuy_blip 
	CHANGE_BLIP_DISPLAY nbmnbuy_blip BLIP_ONLY
	START_NEW_SCRIPT nbmnsave1_save_loop
	flag_buypro5_set2 = 1
ENDIF
RETURN

buypro5_set3:
IF flag_buypro5_set3 = 0
	Elswanko_bought = 1
	//CREATE_CLOTHES_PICKUP 431.9 606.3 12.7 1 safehouse_clothes5   
	safehouse_created5 = 1
	ADD_MONEY_SPENT_ON_PROPERTY nbmnbuy_price
	SET_PROPERTY_AS_OWNED PROP_EL_SWANKO
//	nbmnbuy_price *= -1
//	ADD_SCORE player1 nbmnbuy_price
	flag_buypro5_set3 = 1
ENDIF
RETURN

buypro5_set4:
IF flag_buypro5_set4 = 0
	CHANGE_GARAGE_TYPE nbmnbuy_save_garage GARAGE_HIDEOUT_ONE 
	flag_buypro5_set4 = 1
ENDIF
RETURN

mission_deatharrest_buypro5:
GOSUB buypro5_set1
GOSUB buypro5_set2
GOSUB buypro5_set3
GOSUB buypro5_set4
RETURN
// FIXMIAMI: END

mission_cleanup_buypro5: // FIXMIAMI

	SET_MUSIC_DOES_FADE TRUE
					
												
flag_player_on_mission = 0

MISSION_HAS_FINISHED
//MISSION_END // FIXMIAMI: moved up

}
RETURN 


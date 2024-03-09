MISSION_START

// ********** DECLARE VARIABLES *************************************

//VAR_INT ped_fud
VAR_INT flag_create_mall_fuddies_1 flag_create_mall_fuddies_2 flag_create_haiti_fuddies	flag_create_dtown_fuddies flag_create_vpoint_fuddies
VAR_INT fastfud_1 fastfud_2 fastfud_3 fastfud_4
VAR_INT fastfud_5 fastfud_6 fastfud_7 fastfud_8
VAR_INT flag_fud_audio //flag_crust flag_shaft flag_bandit
VAR_INT player_gimme_int fastfud_reply_int
VAR_INT ped_control	fud_health player_score_fud

VAR_INT flag_fud1_area flag_fud2_area flag_fud3_area flag_fud4_area
VAR_INT flag_fud5_area flag_fud6_area flag_fud7_area flag_fud8_area

VAR_INT fud_count
VAR_INT fud_blob1 fud_blob2 fud_blob3 fud_blob4
VAR_INT fud_blob5 fud_blob6 fud_blob7 fud_blob8

VAR_INT flag_player_in_haiti flag_player_in_downtown flag_player_in_vpoint //flag_player_in_beach3
VAR_FLOAT fud_x fud_y fud_z

VAR_INT fastfud_vp fastfud_dt fastfud_ht1 fastfud_ht2

VAR_INT biker_doorman1 //biker_doorman2
VAR_INT flag_create_biker_dude

// ********** SET FLAGS AND VARIABLES *******************************
flag_create_mall_fuddies_1 = 0
flag_create_mall_fuddies_2 = 0
flag_create_haiti_fuddies = 0
flag_create_dtown_fuddies = 0
flag_create_vpoint_fuddies = 0
flag_fud_audio = 0

//flag_player_in_beach3 = 0
flag_player_in_haiti = 0
flag_player_in_downtown = 0
flag_player_in_vpoint = 0

flag_create_biker_dude = 0

flag_fud1_area = 0
flag_fud2_area = 0
flag_fud3_area = 0
flag_fud4_area = 0
flag_fud5_area = 0
flag_fud6_area = 0
flag_fud7_area = 0
flag_fud8_area = 0

fud_count = 0

//flag_shaft = 0
//flag_crust = 0
//flag_burger = 0


// ********** MAIN SCRIPT *******************************************

SCRIPT_NAME	JUNKFUD

SET_DEATHARREST_STATE OFF //stops script being terminated if Player dies/arrested


mission_start_junkfud:

{
	START_NEW_SCRIPT junkfud
	//START_NEW_SCRIPT airport_security
	//START_NEW_SCRIPT aport2_security

	MISSION_END
}
  


junkfud:


{
GOTO fokker
CREATE_CHAR PEDTYPE_CIVMALE SPECIAL20 445.8 1098.5 18.25 fastfud_1 //burger shot
CREATE_CHAR PEDTYPE_CIVMALE SPECIAL20 445.8 1098.5 18.25 fastfud_2 //burger shot
CREATE_CHAR PEDTYPE_CIVMALE SPECIAL20 445.8 1098.5 18.25 fastfud_3 //burger shot
CREATE_CHAR PEDTYPE_CIVMALE SPECIAL20 445.8 1098.5 18.25 fastfud_4 //burger shot
CREATE_CHAR PEDTYPE_CIVMALE SPECIAL20 445.8 1098.5 18.25 fastfud_5 //burger shot
CREATE_CHAR PEDTYPE_CIVMALE SPECIAL20 445.8 1098.5 18.25 fastfud_6 //burger shot
CREATE_CHAR PEDTYPE_CIVMALE SPECIAL20 445.8 1098.5 18.25 fastfud_7 //burger shot
CREATE_CHAR PEDTYPE_CIVMALE SPECIAL20 445.8 1098.5 18.25 fastfud_8 //burger shot
ADD_SPHERE -903.0 800.3 10.5 1.0 fud_blob1
ADD_SPHERE -903.0 800.3 10.5 1.0 fud_blob2
ADD_SPHERE -903.0 800.3 10.5 1.0 fud_blob3
ADD_SPHERE -903.0 800.3 10.5 1.0 fud_blob4
ADD_SPHERE -903.0 800.3 10.5 1.0 fud_blob5
ADD_SPHERE -903.0 800.3 10.5 1.0 fud_blob6
ADD_SPHERE -903.0 800.3 10.5 1.0 fud_blob7
ADD_SPHERE -903.0 800.3 10.5 1.0 fud_blob8
fokker:

junkfud_inner:

	SCRIPT_NAME FUD

	WAIT 0

		// FIXMIAMI: START
		VAR_INT max_health max_health_minus_one
		max_health = 100
		max_health_minus_one = 99
		IF flag_pizza_mission_passed = 1
			max_health += 50
			max_health_minus_one += 50
		ENDIF
		IF created_final_shirt = 1
			max_health += 50
			max_health_minus_one += 50
		ENDIF
		// FIXMIAMI: END

		IF IS_PLAYER_PLAYING player1
			++ fud_count
			GET_PLAYER_COORDINATES player1 fud_x fud_y fud_z
			// **************************** THE MALL ********************************************
			IF fud_count = 1
				IF IS_PLAYER_IN_ZONE player1 BEACH3
					IF flag_player_in_mall = 1
						IF fud_x > 415.0
							IF flag_create_mall_fuddies_1 = 1
							AND flag_cell_nation = 0
							 
								IF IS_PLAYER_PLAYING player1
									IF NOT IS_CHAR_DEAD fastfud_1
									AND IS_SCORE_GREATER player1 0
									AND NOT IS_PLAYER_HEALTH_GREATER player1 max_health_minus_one // FIXMIAMI: use max_health_minus_one
										IF LOCATE_PLAYER_ON_FOOT_3D player1	445.66 1100.54 18.3 1.0 1.0 2.0 FALSE
											IF flag_fud1_area = 0
												flag_fud1_area = 1
												REMOVE_SPHERE fud_blob1
												flag_fud_audio = 1
												ped_control = fastfud_1
												GOSUB fud_stuff
												GOTO junkfud_inner
											ENDIF
										ELSE
											IF flag_fud1_area = 1
												REMOVE_SPHERE fud_blob1
												ADD_SPHERE 445.66 1100.54 18.3 1.0 fud_blob1
												flag_fud1_area = 0
											ENDIF
										ENDIF
									ELSE
										flag_fud1_area = 1
										REMOVE_SPHERE fud_blob1
									ENDIF
								ENDIF
								
								IF IS_PLAYER_PLAYING player1
									IF NOT IS_CHAR_DEAD fastfud_2
									AND IS_SCORE_GREATER player1 0
									AND NOT IS_PLAYER_HEALTH_GREATER player1 max_health_minus_one // FIXMIAMI: use max_health_minus_one
										IF LOCATE_PLAYER_ON_FOOT_3D player1	436.75 1105.8 18.2 1.0 1.0 2.0 FALSE
											IF flag_fud2_area = 0
												flag_fud2_area = 1
												REMOVE_SPHERE fud_blob2
												flag_fud_audio = 2
												ped_control = fastfud_2
												GOSUB fud_stuff
												GOTO junkfud_inner
											ENDIF
										ELSE
											IF flag_fud2_area = 1
												REMOVE_SPHERE fud_blob2
												ADD_SPHERE 436.75 1105.8 18.2 1.0 fud_blob2
												flag_fud2_area = 0
											ENDIF
										ENDIF
									ELSE
										flag_fud2_area = 1
										REMOVE_SPHERE fud_blob2
									ENDIF
								ENDIF
								
								IF IS_PLAYER_PLAYING player1
									IF NOT IS_CHAR_DEAD fastfud_3
									AND IS_SCORE_GREATER player1 0
									AND NOT IS_PLAYER_HEALTH_GREATER player1 max_health_minus_one // FIXMIAMI: use max_health_minus_one
										IF LOCATE_PLAYER_ON_FOOT_3D player1	434.5 1139.3 18.2 1.0 1.0 2.0 FALSE
											IF flag_fud3_area = 0
												flag_fud3_area = 1
												REMOVE_SPHERE fud_blob3
												flag_fud_audio = 3
												ped_control = fastfud_3
												GOSUB fud_stuff
												GOTO junkfud_inner
											ENDIF
										ELSE
											IF flag_fud3_area = 1
												REMOVE_SPHERE fud_blob3
												ADD_SPHERE 434.5 1139.3 18.2 1.0 fud_blob3
												flag_fud3_area = 0
											ENDIF
										ENDIF
									ELSE
										flag_fud3_area = 1
										REMOVE_SPHERE fud_blob3
									ENDIF
								ENDIF
								
								IF IS_PLAYER_PLAYING player1
									IF NOT IS_CHAR_DEAD fastfud_4
									AND IS_SCORE_GREATER player1 0
									AND NOT IS_PLAYER_HEALTH_GREATER player1 max_health_minus_one // FIXMIAMI: use max_health_minus_one
										IF LOCATE_PLAYER_ON_FOOT_3D player1	451.24 1146.5 18.24 1.0 1.0 2.0 FALSE
											IF flag_fud4_area = 0
												flag_fud4_area = 1
												REMOVE_SPHERE fud_blob4
												flag_fud_audio = 4
												ped_control = fastfud_4
												GOSUB fud_stuff
												GOTO junkfud_inner
											ENDIF
										ELSE
											IF flag_fud4_area = 1
												REMOVE_SPHERE fud_blob4
												ADD_SPHERE 451.24 1146.5 18.24 1.0 fud_blob4
												flag_fud4_area = 0
											ENDIF
										ENDIF
									ELSE
										flag_fud4_area = 1
										REMOVE_SPHERE fud_blob4
									ENDIF
								ENDIF
							ENDIF
							
							
							IF flag_create_mall_fuddies_1 = 0
								LOAD_SPECIAL_CHARACTER 20 burger

								WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 20
									WAIT 0
									LOAD_SPECIAL_CHARACTER 20 burger
								ENDWHILE
								
								CREATE_CHAR PEDTYPE_CIVMALE SPECIAL20 445.8 1098.5 18.25 fastfud_1 //burger shot 
								SET_CHAR_HEADING fastfud_1 46.0
								ped_control = fastfud_1
								GOSUB fud_threat
								REMOVE_SPHERE fud_blob1
								ADD_SPHERE 445.66 1100.54 18.3 1.0 fud_blob1							

								CREATE_CHAR PEDTYPE_CIVMALE SPECIAL20 435.46 1104.0 18.27 fastfud_2 //cheesy crust 
								SET_CHAR_HEADING fastfud_2 350.0
								ped_control = fastfud_2
								GOSUB fud_threat
								REMOVE_SPHERE fud_blob2
								ADD_SPHERE 436.75 1105.8 18.2 1.0 fud_blob2							
								
								CREATE_CHAR PEDTYPE_CIVMALE SPECIAL20 433.0 1140.5 18.29 fastfud_3 // shaft
								SET_CHAR_HEADING fastfud_3 215.0
								ped_control = fastfud_3
								GOSUB fud_threat
								REMOVE_SPHERE fud_blob3
								ADD_SPHERE 434.5 1139.3 18.2 1.0 fud_blob3							
								
								CREATE_CHAR PEDTYPE_CIVMALE SPECIAL20 451.4 1148.42 18.23 fastfud_4 //bandit 
								SET_CHAR_HEADING fastfud_4 173.0
								ped_control = fastfud_4
								GOSUB fud_threat
								REMOVE_SPHERE fud_blob4
								ADD_SPHERE 451.24 1146.5 18.24 1.0 fud_blob4							
								
								flag_create_mall_fuddies_1 = 1	
							ENDIF
						ELSE
							GOSUB fud_cleanup
						ENDIF
						
						// OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
						// OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
						// OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
						
						
						IF fud_x < 410.0
							IF flag_create_mall_fuddies_2 = 1
							AND flag_cell_nation = 0
								
								IF IS_PLAYER_PLAYING player1
									IF NOT IS_CHAR_DEAD fastfud_5
									AND IS_SCORE_GREATER player1 0
									AND NOT IS_PLAYER_HEALTH_GREATER player1 max_health_minus_one // FIXMIAMI: use max_health_minus_one 
										IF LOCATE_PLAYER_ON_FOOT_3D player1	375.76 1147.7 18.6 1.0 1.0 2.0 FALSE
											IF flag_fud5_area = 0
												flag_fud5_area = 1
												REMOVE_SPHERE fud_blob5
												flag_fud_audio = 1
												ped_control = fastfud_5
												GOSUB fud_stuff
												GOTO junkfud_inner
											ENDIF
										ELSE
											IF flag_fud5_area = 1
												REMOVE_SPHERE fud_blob5
												ADD_SPHERE 375.76 1147.7 18.6 1.0 fud_blob5
												flag_fud5_area = 0
											ENDIF
										ENDIF
									ELSE
										flag_fud5_area = 1
										REMOVE_SPHERE fud_blob5
									ENDIF
								ENDIF
								
								
								IF IS_PLAYER_PLAYING player1
									IF NOT IS_CHAR_DEAD fastfud_6
									AND IS_SCORE_GREATER player1 0
									AND NOT IS_PLAYER_HEALTH_GREATER player1 max_health_minus_one // FIXMIAMI: use max_health_minus_one 
										IF LOCATE_PLAYER_ON_FOOT_3D player1	394.16 1139.12 18.6 1.0 1.0 2.0 FALSE
											IF flag_fud6_area = 0
												flag_fud6_area = 1
												REMOVE_SPHERE fud_blob6
												flag_fud_audio = 2
												ped_control = fastfud_6
												GOSUB fud_stuff
												GOTO junkfud_inner
											ENDIF
										ELSE
											IF flag_fud6_area = 1
												REMOVE_SPHERE fud_blob6
												ADD_SPHERE 394.16 1139.12 18.6 1.0 fud_blob6
												flag_fud6_area = 0
											ENDIF
										ENDIF
									ELSE
										flag_fud6_area = 1
										REMOVE_SPHERE fud_blob6
									ENDIF
								ENDIF
								
								
								IF IS_PLAYER_PLAYING player1
									IF NOT IS_CHAR_DEAD fastfud_7
									AND IS_SCORE_GREATER player1 0
									AND NOT IS_PLAYER_HEALTH_GREATER player1 max_health_minus_one // FIXMIAMI: use max_health_minus_one 
										IF LOCATE_PLAYER_ON_FOOT_3D player1	392.96 1108.7 18.55 1.0 1.0 2.0 FALSE
											IF flag_fud7_area = 0
												flag_fud7_area = 1
												REMOVE_SPHERE fud_blob7
												flag_fud_audio = 3
												ped_control = fastfud_7
												GOSUB fud_stuff
												GOTO junkfud_inner
											ENDIF
										ELSE
											IF flag_fud7_area = 1
												REMOVE_SPHERE fud_blob7
												ADD_SPHERE 392.96 1108.7 18.55 1.0 fud_blob7
												flag_fud7_area = 0
											ENDIF
										ENDIF
									ELSE
										flag_fud7_area = 1
										REMOVE_SPHERE fud_blob7
									ENDIF
								ENDIF
								
								IF IS_PLAYER_PLAYING player1
									IF NOT IS_CHAR_DEAD fastfud_8
									AND IS_SCORE_GREATER player1 0
									AND NOT IS_PLAYER_HEALTH_GREATER player1 max_health_minus_one // FIXMIAMI: use max_health_minus_one 
										IF LOCATE_PLAYER_ON_FOOT_3D player1	376.47 1101.7 18.58 1.0 1.0 2.0 FALSE
											IF flag_fud8_area = 0
												flag_fud8_area = 1
												REMOVE_SPHERE fud_blob8
												flag_fud_audio = 4
												ped_control = fastfud_8
												GOSUB fud_stuff
												GOTO junkfud_inner
											ENDIF
										ELSE
											IF flag_fud8_area = 1
												REMOVE_SPHERE fud_blob8
												ADD_SPHERE 376.47 1101.7 18.58 1.0 fud_blob8
												flag_fud8_area = 0
											ENDIF
										ENDIF
									ELSE
										flag_fud8_area = 1
										REMOVE_SPHERE fud_blob8
									ENDIF
								ENDIF
								
							ENDIF
							
							
							IF flag_create_mall_fuddies_2 = 0
								LOAD_SPECIAL_CHARACTER 20 burger

								WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 20
									WAIT 0
									LOAD_SPECIAL_CHARACTER 20 burger
								ENDWHILE
								
								CREATE_CHAR PEDTYPE_CIVMALE SPECIAL20 375.9 1149.7 18.6 fastfud_5 //burger shot
								SET_CHAR_HEADING fastfud_5 224.0
								ped_control = fastfud_5
								GOSUB fud_threat
								REMOVE_SPHERE fud_blob5
								ADD_SPHERE 375.76 1147.7 18.6 1.0 fud_blob5							
								
								CREATE_CHAR PEDTYPE_CIVMALE SPECIAL20 395.0 1141.2 18.55 fastfud_6 //cheesy crust
								SET_CHAR_HEADING fastfud_6 165.0
								ped_control = fastfud_6
								GOSUB fud_threat
								REMOVE_SPHERE fud_blob6
								ADD_SPHERE 394.16 1139.12 18.6 1.0 fud_blob6							
								
								CREATE_CHAR PEDTYPE_CIVMALE SPECIAL20 394.4 1107.6 18.6 fastfud_7 // shaft
								SET_CHAR_HEADING fastfud_7 49.0
								ped_control = fastfud_7
								GOSUB fud_threat
								REMOVE_SPHERE fud_blob7
								ADD_SPHERE 392.96 1108.7 18.55 1.0 fud_blob7							
								
								CREATE_CHAR PEDTYPE_CIVMALE SPECIAL20 375.87 1099.75 18.57 fastfud_8 // bandit
								SET_CHAR_HEADING fastfud_8 344.0
								ped_control = fastfud_8
								GOSUB fud_threat
								REMOVE_SPHERE fud_blob8
								ADD_SPHERE 376.47 1101.7 18.58 1.0 fud_blob8							
								
								flag_create_mall_fuddies_2 = 1	
							ENDIF
						ELSE
							GOSUB fud_cleanup
						ENDIF
					ELSE
						GOSUB fud_cleanup
					ENDIF
				ELSE
					GOSUB fud_cleanup		
				ENDIF
			ENDIF
			// ********************************* Little Haiti ***********************************************
			// ********************************* Little Haiti ***********************************************
			// ********************************* Little Haiti ***********************************************
			IF fud_count = 2
			AND IS_PLAYER_PLAYING player1
				IF IS_PLAYER_IN_ZONE player1 HAITI

					flag_player_in_haiti = 1
					ground_z = 0.0000
					GET_GROUND_Z_FOR_3D_COORD -1039.5 80.0 50.0 ground_z
					IF ground_z > 0.0000
						IF flag_create_haiti_fuddies = 0
							LOAD_SPECIAL_CHARACTER 20 burger

							WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 20
								WAIT 0
								LOAD_SPECIAL_CHARACTER 20 burger
							ENDWHILE
							
							CREATE_CHAR PEDTYPE_CIVMALE SPECIAL20 -1039.5 80.0 10.6 fastfud_ht1 // back room far right
							SET_CHAR_HEADING fastfud_ht1 80.0
							ped_control = fastfud_ht1
							GOSUB fud_threat
							
							REMOVE_SPHERE fud_blob1
							ADD_SPHERE -1041.3 80.45 10.6 1.0 fud_blob1							
							
							IF HAS_MODEL_LOADED HNB
								CREATE_CHAR PEDTYPE_CIVMALE HNB -1036.2 77.5 10.6 fastfud_ht2 // back room far right
								SET_CHAR_HEADING fastfud_ht2 190.0
								CLEAR_CHAR_THREAT_SEARCH fastfud_ht2
								SET_CHAR_WAIT_STATE fastfud_ht2 WAITSTATE_LOOK_ACCIDENT 999999
							ENDIF
							
							flag_create_haiti_fuddies = 1	
						ENDIF
						//GOSUB fudelicious
						IF flag_create_haiti_fuddies = 1
						AND flag_cell_nation = 0
							IF IS_PLAYER_PLAYING player1
								IF IS_SCORE_GREATER player1 0
								AND NOT IS_PLAYER_HEALTH_GREATER player1 max_health_minus_one // FIXMIAMI: use max_health_minus_one 
								AND NOT IS_CHAR_DEAD fastfud_ht1
									//IF IS_CHAR_HEALTH_GREATER fastfud_1 95
										IF LOCATE_PLAYER_ON_FOOT_3D player1	-1041.3 80.45 10.6 1.0 1.0 2.0 FALSE
											IF flag_fud1_area = 0
												flag_fud1_area = 1
												REMOVE_SPHERE fud_blob1
												flag_fud_audio = 2
												ped_control = fastfud_ht1
												GOSUB fud_stuff
												GOTO junkfud_inner
											ENDIF
										ELSE
											IF flag_fud1_area = 1
												REMOVE_SPHERE fud_blob1
												ADD_SPHERE -1041.3 80.45 10.6 1.0 fud_blob1
												flag_fud1_area = 0
											ENDIF
										ENDIF
									//ENDIF
								ELSE
									flag_fud1_area = 1
									REMOVE_SPHERE fud_blob1
								ENDIF
							ENDIF
						ENDIF
					ELSE
						GOSUB fud_cleanup
					ENDIF
				ELSE
					flag_player_in_haiti = 0
					GOSUB fud_cleanup		
				ENDIF
			ENDIF
			// ******************************************************************************************
			// ********************************* Down Town ***********************************************
			IF fud_count = 1
			AND IS_PLAYER_PLAYING player1
				IF IS_PLAYER_IN_ZONE player1 DTOWN
					flag_player_in_downtown = 1
					ground_z = 0.0000
					GET_GROUND_Z_FOR_3D_COORD -591.4 651.23 10.5 ground_z
					IF ground_z > 0.0000
						IF HAS_MODEL_LOADED BKa
							IF flag_create_biker_dude = 0
								CREATE_CHAR PEDTYPE_CIVMALE BKa -591.4 651.23 10.5 biker_doorman1 // back room far right
								SET_CHAR_HEADING biker_doorman1 25.0
								SET_CHAR_HEALTH biker_doorman1 150
								CLEAR_CHAR_THREAT_SEARCH biker_doorman1
								SET_CHAR_HEED_THREATS biker_doorman1 TRUE
								SET_CHAR_PERSONALITY biker_doorman1 PEDSTAT_STREET_GUY
								flag_create_biker_dude = 1
							ENDIF
						ENDIF
					ELSE
						IF flag_create_biker_dude = 1
							DELETE_CHAR biker_doorman1 // back room far right
							flag_create_biker_dude = 0
						ENDIF
					ENDIF
					
					ground_z = 0.0000
					GET_GROUND_Z_FOR_3D_COORD -904.7 800.4 10.5 ground_z
					IF ground_z > 0.0000
						IF flag_create_dtown_fuddies = 0
							LOAD_SPECIAL_CHARACTER 20 burger

							WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 20
								WAIT 0
								LOAD_SPECIAL_CHARACTER 20 burger
							ENDWHILE

	//						REQUEST_MODEL HNB
	//						WHILE NOT HAS_MODEL_LOADED HNB
	//							WAIT 0
	//						ENDWHILE
							
							CREATE_CHAR PEDTYPE_CIVMALE SPECIAL20 -904.7 800.4 10.5 fastfud_dt // back room far right
							SET_CHAR_HEADING fastfud_dt 270.0
							ped_control = fastfud_dt
							GOSUB fud_threat
							
							REMOVE_SPHERE fud_blob1
							ADD_SPHERE -903.0 800.3 10.5 1.0 fud_blob1							
							
							/*
							CREATE_CHAR PEDTYPE_CIVMALE HNB -1036.2 77.5 10.6 fastfud_2 // back room far right
							SET_CHAR_HEADING fastfud_2 190.0
							CLEAR_CHAR_THREAT_SEARCH fastfud_2
							SET_CHAR_WAIT_STATE fastfud_2 WAITSTATE_LOOK_ACCIDENT 999999
							 */
							flag_create_dtown_fuddies = 1	
						ENDIF
						//GOSUB fudelicious
						IF flag_create_dtown_fuddies = 1
						AND flag_cell_nation = 0
							IF IS_PLAYER_PLAYING player1
								IF IS_SCORE_GREATER player1 0
								AND NOT IS_PLAYER_HEALTH_GREATER player1 max_health_minus_one // FIXMIAMI: use max_health_minus_one 
								AND NOT IS_CHAR_DEAD fastfud_dt
									//IF IS_CHAR_HEALTH_GREATER fastfud_1 95
										IF LOCATE_PLAYER_ON_FOOT_3D player1	-903.0 800.3 10.5 1.0 1.0 2.0 FALSE
											IF flag_fud1_area = 0
												flag_fud1_area = 1
												REMOVE_SPHERE fud_blob1
												flag_fud_audio = 2
												ped_control = fastfud_dt
												GOSUB fud_stuff
												GOTO junkfud_inner
											ENDIF
										ELSE
											IF flag_fud1_area = 1
												REMOVE_SPHERE fud_blob1
												ADD_SPHERE -903.0 800.3 10.5 1.0 fud_blob1
												flag_fud1_area = 0
											ENDIF
										ENDIF
									//ENDIF
								ELSE
									flag_fud1_area = 1
									REMOVE_SPHERE fud_blob1
								ENDIF
							ENDIF
						ENDIF
					ELSE
						GOSUB fud_cleanup
					ENDIF
				ELSE
					IF flag_create_biker_dude = 1
						DELETE_CHAR biker_doorman1 // back room far right
						flag_create_biker_dude = 0
					ENDIF
					flag_player_in_downtown = 0
					GOSUB fud_cleanup		
				ENDIF
			ENDIF
			// ******************************************************************************************
			// ********************************* Vice Point ***********************************************
			IF fud_count = 2
			AND IS_PLAYER_PLAYING player1
				IF IS_PLAYER_IN_ZONE player1 BEACH3
					flag_player_in_vpoint = 1
					ground_z = 0.0000
					GET_GROUND_Z_FOR_3D_COORD 419.4 89.7 50.0 ground_z
					IF ground_z > 0.0000
						IF flag_create_vpoint_fuddies = 0
							LOAD_SPECIAL_CHARACTER 20 burger

							WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 20
								WAIT 0
								LOAD_SPECIAL_CHARACTER 20 burger
							ENDWHILE

	//						REQUEST_MODEL HNB
	//						WHILE NOT HAS_MODEL_LOADED HNB
	//							WAIT 0
	//						ENDWHILE
							
							CREATE_CHAR PEDTYPE_CIVMALE SPECIAL20 419.4 89.7 10.3 fastfud_vp // back room far right
							SET_CHAR_HEADING fastfud_vp 250.0
							ped_control = fastfud_vp
							GOSUB fud_threat
							
							REMOVE_SPHERE fud_blob1
							ADD_SPHERE 421.1 88.8 10.5 1.0 fud_blob1							
							
							/*
							CREATE_CHAR PEDTYPE_CIVMALE HNB -1036.2 77.5 10.6 fastfud_2 // back room far right
							SET_CHAR_HEADING fastfud_2 190.0
							CLEAR_CHAR_THREAT_SEARCH fastfud_2
							SET_CHAR_WAIT_STATE fastfud_2 WAITSTATE_LOOK_ACCIDENT 999999
							 */
							flag_create_vpoint_fuddies = 1	
						ENDIF
						//GOSUB fudelicious
						IF flag_create_vpoint_fuddies = 1
						AND flag_cell_nation = 0
							IF IS_PLAYER_PLAYING player1
								IF IS_SCORE_GREATER player1 0
								AND NOT IS_PLAYER_HEALTH_GREATER player1 max_health_minus_one // FIXMIAMI: use max_health_minus_one 
								AND NOT IS_CHAR_DEAD fastfud_vp
									//IF IS_CHAR_HEALTH_GREATER fastfud_1 95
										IF LOCATE_PLAYER_ON_FOOT_3D player1	421.1 88.8 10.5 1.0 1.0 2.0 FALSE
											IF flag_fud1_area = 0
												flag_fud1_area = 1
												REMOVE_SPHERE fud_blob1
												flag_fud_audio = 2
												ped_control = fastfud_vp
												GOSUB fud_stuff
												GOTO junkfud_inner
											ENDIF
										ELSE
											IF flag_fud1_area = 1
												REMOVE_SPHERE fud_blob1
												ADD_SPHERE 421.1 88.8 10.5 1.0 fud_blob1
												flag_fud1_area = 0
											ENDIF
										ENDIF
									//ENDIF
								ELSE
									flag_fud1_area = 1
									REMOVE_SPHERE fud_blob1
								ENDIF
							ENDIF
						ENDIF
					ELSE
						GOSUB fud_cleanup
					ENDIF
				ELSE
					flag_player_in_vpoint = 0
					GOSUB fud_cleanup		
				ENDIF
			ENDIF
			// ******************************************************************************************
		ELSE
			GOSUB fud_cleanup
		ENDIF
	IF fud_count > 1
		fud_count = 0
	ENDIF
	GOTO junkfud_inner
		
} 

fud_threat:
	CLEAR_CHAR_THREAT_SEARCH ped_control
	SET_CHAR_THREAT_SEARCH ped_control THREAT_GUN
	SET_CHAR_THREAT_SEARCH ped_control THREAT_EXPLOSION
	SET_CHAR_CROUCH_WHEN_THREATENED ped_control 1
	SET_CHAR_STAY_IN_SAME_PLACE ped_control TRUE
RETURN

fud_stuff:
	flag_cell_nation = 1
	IF NOT IS_CHAR_DEAD ped_control
		GOSUB control_player_off
		IF flag_player_on_mission = 0
			GOSUB fud_audio_gimme
			GOSUB fud_audio_reply
		ENDIF
		GOSUB transaction
		GOSUB control_player_on
	ENDIF
	flag_cell_nation = 0
RETURN

control_player_off:
	IF IS_PLAYER_PLAYING player1
	AND NOT IS_CHAR_DEAD ped_control
		SET_PLAYER_CONTROL player1 OFF
		SET_EVERYONE_IGNORE_PLAYER player1 ON
		TURN_CHAR_TO_FACE_CHAR scplayer ped_control
	ELSE
		RETURN
	ENDIF
RETURN

control_player_on:
	IF IS_PLAYER_PLAYING player1
		SET_PLAYER_CONTROL player1 ON
		SET_EVERYONE_IGNORE_PLAYER player1 OFF
	ENDIF
RETURN

fud_audio_gimme:
	
	IF IS_PLAYER_PLAYING player1
	AND NOT IS_CHAR_DEAD ped_control	
		GENERATE_RANDOM_INT_IN_RANGE 1 16 player_gimme_int // FIXMIAMI: fix upper bound
		IF player_gimme_int = 1
			LOAD_MISSION_AUDIO 2 GIMME01
			GOSUB fud_audio_loading
			//PRINT_NOW GIMME01 10000 1
			GOSUB fud_audio_finishing
		ENDIF
		IF player_gimme_int = 2
			LOAD_MISSION_AUDIO 2 GIMME02
			GOSUB fud_audio_loading
			//PRINT_NOW GIMME02 10000 1
			GOSUB fud_audio_finishing
		ENDIF
		IF player_gimme_int = 3
			LOAD_MISSION_AUDIO 2 GIMME03
			GOSUB fud_audio_loading
			//PRINT_NOW GIMME03 10000 1
			GOSUB fud_audio_finishing
		ENDIF
		IF player_gimme_int = 4
			LOAD_MISSION_AUDIO 2 GIMME04
			GOSUB fud_audio_loading
			//PRINT_NOW GIMME04 10000 1
			GOSUB fud_audio_finishing
		ENDIF
		IF player_gimme_int = 5
			LOAD_MISSION_AUDIO 2 GIMME05
			GOSUB fud_audio_loading
			//PRINT_NOW GIMME05 10000 1
			GOSUB fud_audio_finishing
		ENDIF
		IF player_gimme_int = 6
			LOAD_MISSION_AUDIO 2 GIMME06
			GOSUB fud_audio_loading
			//PRINT_NOW GIMME06 10000 1
			GOSUB fud_audio_finishing
		ENDIF
		IF player_gimme_int = 7
			LOAD_MISSION_AUDIO 2 GIMME07
			GOSUB fud_audio_loading
			//PRINT_NOW GIMME07 10000 1
			GOSUB fud_audio_finishing
		ENDIF
		IF player_gimme_int = 8
			LOAD_MISSION_AUDIO 2 GIMME08
			GOSUB fud_audio_loading
			//PRINT_NOW GIMME08 10000 1
			GOSUB fud_audio_finishing
		ENDIF
		IF player_gimme_int = 9
			LOAD_MISSION_AUDIO 2 GIMME09
			GOSUB fud_audio_loading
			//PRINT_NOW GIMME09 10000 1
			GOSUB fud_audio_finishing
		ENDIF
		IF player_gimme_int = 10
			LOAD_MISSION_AUDIO 2 GIMME10
			GOSUB fud_audio_loading
			//PRINT_NOW GIMME10 10000 1
			GOSUB fud_audio_finishing
		ENDIF
		IF player_gimme_int = 11
			LOAD_MISSION_AUDIO 2 GIMME11
			GOSUB fud_audio_loading
			//PRINT_NOW GIMME11 10000 1
			GOSUB fud_audio_finishing
		ENDIF
		IF player_gimme_int = 12
			LOAD_MISSION_AUDIO 2 GIMME12
			GOSUB fud_audio_loading
			//PRINT_NOW GIMME12 10000 1
			GOSUB fud_audio_finishing
		ENDIF
		IF player_gimme_int = 13
			LOAD_MISSION_AUDIO 2 GIMME13
			GOSUB fud_audio_loading
			//PRINT_NOW GIMME13 10000 1
			GOSUB fud_audio_finishing
		ENDIF
		IF player_gimme_int = 14
			LOAD_MISSION_AUDIO 2 GIMME14
			GOSUB fud_audio_loading
			//PRINT_NOW GIMME14 10000 1
			GOSUB fud_audio_finishing
		ENDIF
		IF player_gimme_int = 15
			LOAD_MISSION_AUDIO 2 GIMME15
			GOSUB fud_audio_loading
			//PRINT_NOW GIMME15 10000 1
			GOSUB fud_audio_finishing
		ENDIF
	ENDIF
RETURN

fud_audio_reply:
IF IS_PLAYER_PLAYING player1
AND NOT IS_CHAR_DEAD ped_control
AND flag_player_on_mission = 0	

	GENERATE_RANDOM_INT_IN_RANGE 1 31 fastfud_reply_int // FIXMIAMI: fix upper bound
	IF fastfud_reply_int < 11
		IF flag_fud_audio = 1 //burger shot
			GENERATE_RANDOM_INT_IN_RANGE 1 13 fastfud_reply_int // FIXMIAMI: fix upper bound
			IF fastfud_reply_int = 1
				LOAD_MISSION_AUDIO 2 BURG_01
				GOSUB fud_audio_loading
				//PRINT_NOW BURG_01 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 2
				LOAD_MISSION_AUDIO 2 BURG_02
				GOSUB fud_audio_loading
				//PRINT_NOW BURG_02 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 3
				LOAD_MISSION_AUDIO 2 BURG_03
				GOSUB fud_audio_loading
				//PRINT_NOW BURG_03 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 4
				LOAD_MISSION_AUDIO 2 BURG_04
				GOSUB fud_audio_loading
				//PRINT_NOW BURG_04 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 5
				LOAD_MISSION_AUDIO 2 BURG_05
				GOSUB fud_audio_loading
				//PRINT_NOW BURG_05 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 6
				LOAD_MISSION_AUDIO 2 BURG_06
				GOSUB fud_audio_loading
				//PRINT_NOW BURG_06 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 7
				LOAD_MISSION_AUDIO 2 BURG_07
				GOSUB fud_audio_loading
				//PRINT_NOW BURG_07 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 8
				LOAD_MISSION_AUDIO 2 BURG_08
				GOSUB fud_audio_loading
				//PRINT_NOW BURG_08 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 9
				LOAD_MISSION_AUDIO 2 BURG_09
				GOSUB fud_audio_loading
				//PRINT_NOW BURG_09 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 10
				LOAD_MISSION_AUDIO 2 BURG_10
				GOSUB fud_audio_loading
				//PRINT_NOW BURG_10 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 11
				LOAD_MISSION_AUDIO 2 BURG_11
				GOSUB fud_audio_loading
				//PRINT_NOW BURG_11 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 12
				LOAD_MISSION_AUDIO 2 BURG_12
				GOSUB fud_audio_loading
				//PRINT_NOW BURG_12 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
		ENDIF
		IF flag_fud_audio = 2 //cheezy crust
			GENERATE_RANDOM_INT_IN_RANGE 1 10 fastfud_reply_int // FIXMIAMI: fix upper bound
			IF fastfud_reply_int = 1
				LOAD_MISSION_AUDIO 2 CRUST01
				GOSUB fud_audio_loading
				//PRINT_NOW CRUST01 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 2
				LOAD_MISSION_AUDIO 2 CRUST02
				GOSUB fud_audio_loading
				//PRINT_NOW CRUST02 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 3
				LOAD_MISSION_AUDIO 2 CRUST03
				GOSUB fud_audio_loading
				//PRINT_NOW CRUST03 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 4
				LOAD_MISSION_AUDIO 2 CRUST04
				GOSUB fud_audio_loading
				//PRINT_NOW CRUST04 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 5
				LOAD_MISSION_AUDIO 2 CRUST05
				GOSUB fud_audio_loading
				//PRINT_NOW CRUST05 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 6
				LOAD_MISSION_AUDIO 2 CRUST06
				GOSUB fud_audio_loading
				//PRINT_NOW CRUST06 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 7
				LOAD_MISSION_AUDIO 2 CRUST07
				GOSUB fud_audio_loading
				//PRINT_NOW CRUST07 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 8
				LOAD_MISSION_AUDIO 2 CRUST08
				GOSUB fud_audio_loading
				//PRINT_NOW CRUST08 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 9
				LOAD_MISSION_AUDIO 2 CRUST09
				GOSUB fud_audio_loading
				//PRINT_NOW CRUST09 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
		ENDIF
		IF flag_fud_audio = 3 //shaft
			GENERATE_RANDOM_INT_IN_RANGE 1 9 fastfud_reply_int // FIXMIAMI: fix upper bound
			IF fastfud_reply_int = 1
				LOAD_MISSION_AUDIO 2 SHAFT01
				GOSUB fud_audio_loading
				//PRINT_NOW SHAFT01 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 2
				LOAD_MISSION_AUDIO 2 SHAFT02
				GOSUB fud_audio_loading
				//PRINT_NOW SHAFT02 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 3
				LOAD_MISSION_AUDIO 2 SHAFT03
				GOSUB fud_audio_loading
				//PRINT_NOW SHAFT03 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 4
				LOAD_MISSION_AUDIO 2 SHAFT04
				GOSUB fud_audio_loading
				//PRINT_NOW SHAFT04 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 5
				LOAD_MISSION_AUDIO 2 SHAFT05
				GOSUB fud_audio_loading
				//PRINT_NOW SHAFT05 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 6
				LOAD_MISSION_AUDIO 2 SHAFT06
				GOSUB fud_audio_loading
				//PRINT_NOW SHAFT06 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 7
				LOAD_MISSION_AUDIO 2 SHAFT07
				GOSUB fud_audio_loading
				//PRINT_NOW SHAFT07 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 8
				LOAD_MISSION_AUDIO 2 SHAFT08
				GOSUB fud_audio_loading
				//PRINT_NOW SHAFT08 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
		ENDIF
		IF flag_fud_audio = 4 //bandit
			GENERATE_RANDOM_INT_IN_RANGE 1 9 fastfud_reply_int // FIXMIAMI: fix upper bound
			IF fastfud_reply_int = 1
				LOAD_MISSION_AUDIO 2 BAND_01
				GOSUB fud_audio_loading
				//PRINT_NOW BAND_01 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 2
				LOAD_MISSION_AUDIO 2 BAND_02
				GOSUB fud_audio_loading
				//PRINT_NOW BAND_02 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 3
				LOAD_MISSION_AUDIO 2 BAND_03
				GOSUB fud_audio_loading
				//PRINT_NOW BAND_03 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 4
				LOAD_MISSION_AUDIO 2 BAND_04
				GOSUB fud_audio_loading
				//PRINT_NOW BAND_04 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 5
				LOAD_MISSION_AUDIO 2 BAND_05
				GOSUB fud_audio_loading
				//PRINT_NOW BAND_05 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 6
				LOAD_MISSION_AUDIO 2 BAND_06
				GOSUB fud_audio_loading
				//PRINT_NOW BAND_06 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 7
				LOAD_MISSION_AUDIO 2 BAND_07
				GOSUB fud_audio_loading
				//PRINT_NOW BAND_07 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
			IF fastfud_reply_int = 8
				LOAD_MISSION_AUDIO 2 BAND_08
				GOSUB fud_audio_loading
				//PRINT_NOW BAND_08 10000 1
				GOSUB fud_audio_finishing
			ENDIF	
		ENDIF
	ELSE
		GENERATE_RANDOM_INT_IN_RANGE 1 21 fastfud_reply_int // FIXMIAMI: fix upper bound
		IF fastfud_reply_int = 1
			LOAD_MISSION_AUDIO 2 FUD_01
			GOSUB fud_audio_loading
			//PRINT_NOW FUD_01 10000 1
			GOSUB fud_audio_finishing
		ENDIF	
		IF fastfud_reply_int = 2
			LOAD_MISSION_AUDIO 2 FUD_02
			GOSUB fud_audio_loading
			//PRINT_NOW FUD_02 10000 1
			GOSUB fud_audio_finishing
		ENDIF	
		IF fastfud_reply_int = 3
			LOAD_MISSION_AUDIO 2 FUD_03
			GOSUB fud_audio_loading
			//PRINT_NOW FUD_03 10000 1
			GOSUB fud_audio_finishing
		ENDIF	
		IF fastfud_reply_int = 4
			LOAD_MISSION_AUDIO 2 FUD_04
			GOSUB fud_audio_loading
			//PRINT_NOW FUD_04 10000 1
			GOSUB fud_audio_finishing
		ENDIF	
		IF fastfud_reply_int = 5
			LOAD_MISSION_AUDIO 2 FUD_05
			GOSUB fud_audio_loading
			//PRINT_NOW FUD_05 10000 1
			GOSUB fud_audio_finishing
		ENDIF	
		IF fastfud_reply_int = 6
			LOAD_MISSION_AUDIO 2 FUD_06
			GOSUB fud_audio_loading
			//PRINT_NOW FUD_06 10000 1
			GOSUB fud_audio_finishing
		ENDIF	
		IF fastfud_reply_int = 7
			LOAD_MISSION_AUDIO 2 FUD_07
			GOSUB fud_audio_loading
			//PRINT_NOW FUD_07 10000 1
			GOSUB fud_audio_finishing
		ENDIF	
		IF fastfud_reply_int = 8
			LOAD_MISSION_AUDIO 2 FUD_08
			GOSUB fud_audio_loading
			//PRINT_NOW FUD_08 10000 1
			GOSUB fud_audio_finishing
		ENDIF	
		IF fastfud_reply_int = 9
			LOAD_MISSION_AUDIO 2 FUD_09
			GOSUB fud_audio_loading
			//PRINT_NOW FUD_09 10000 1
			GOSUB fud_audio_finishing
		ENDIF	
		IF fastfud_reply_int = 10
			LOAD_MISSION_AUDIO 2 FUD_10
			GOSUB fud_audio_loading
			//PRINT_NOW FUD_10 10000 1
			GOSUB fud_audio_finishing
		ENDIF	
		IF fastfud_reply_int = 11
			LOAD_MISSION_AUDIO 2 FUD_11
			GOSUB fud_audio_loading
			//PRINT_NOW FUD_11 10000 1
			GOSUB fud_audio_finishing
		ENDIF	
		IF fastfud_reply_int = 12
			LOAD_MISSION_AUDIO 2 FUD_12
			GOSUB fud_audio_loading
			//PRINT_NOW FUD_12 10000 1
			GOSUB fud_audio_finishing
		ENDIF	
		IF fastfud_reply_int = 13
			LOAD_MISSION_AUDIO 2 FUD_13
			GOSUB fud_audio_loading
			//PRINT_NOW FUD_13 10000 1
			GOSUB fud_audio_finishing
		ENDIF	
		IF fastfud_reply_int = 14
			LOAD_MISSION_AUDIO 2 FUD_14
			GOSUB fud_audio_loading
			//PRINT_NOW FUD_14 10000 1
			GOSUB fud_audio_finishing
		ENDIF	
		IF fastfud_reply_int = 15
			LOAD_MISSION_AUDIO 2 FUD_15
			GOSUB fud_audio_loading
			//PRINT_NOW FUD_15 10000 1
			GOSUB fud_audio_finishing
		ENDIF	
		IF fastfud_reply_int = 16
			LOAD_MISSION_AUDIO 2 FUD_16
			GOSUB fud_audio_loading
			//PRINT_NOW FUD_16 10000 1
			GOSUB fud_audio_finishing
		ENDIF	
		IF fastfud_reply_int = 17
			LOAD_MISSION_AUDIO 2 FUD_17
			GOSUB fud_audio_loading
			//PRINT_NOW FUD_17 10000 1
			GOSUB fud_audio_finishing
		ENDIF	
		IF fastfud_reply_int = 18
			LOAD_MISSION_AUDIO 2 FUD_18
			GOSUB fud_audio_loading
			//PRINT_NOW FUD_18 10000 1
			GOSUB fud_audio_finishing
		ENDIF	
		IF fastfud_reply_int = 19
			LOAD_MISSION_AUDIO 2 FUD_19
			GOSUB fud_audio_loading
			//PRINT_NOW FUD_19 10000 1
			GOSUB fud_audio_finishing
		ENDIF	
		IF fastfud_reply_int = 20
			LOAD_MISSION_AUDIO 2 FUD_20
			GOSUB fud_audio_loading
			//PRINT_NOW FUD_20 10000 1
			GOSUB fud_audio_finishing
		ENDIF
	ENDIF
ENDIF	
RETURN


fud_audio_loading:
	WHILE NOT HAS_MISSION_AUDIO_LOADED 2
		WAIT 0
		IF NOT IS_PLAYER_PLAYING player1
			RETURN
		ENDIF
	ENDWHILE
	PLAY_MISSION_AUDIO 2
RETURN

fud_audio_finishing:
	WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
		WAIT 0
		IF NOT IS_PLAYER_PLAYING player1
			RETURN
		ENDIF
	ENDWHILE
	CLEAR_PRINTS
RETURN

transaction:
	IF IS_PLAYER_PLAYING player1
	AND NOT IS_CHAR_DEAD ped_control
		GET_PLAYER_HEALTH player1 fud_health
		fud_health = fud_health * -1
		fud_health = fud_health + max_health // FIXMIAMI: use max_health
		STORE_SCORE player1 player_score_fud
		IF fud_health > player_score_fud
			fud_health = player_score_fud
		ENDIF
		fud_health = fud_health * -1
		ADD_SCORE player1 fud_health
		SET_PLAYER_HEALTH player1 max_health // FIXMIAMI: use max_health
		ADD_ONE_OFF_SOUND fud_x fud_y fud_z SOUND_PART_MISSION_COMPLETE
	ENDIF
RETURN
/*
fudelicious:
	IF flag_create_mall_fuddies_1 = 1
		IF NOT IS_CHAR_DEAD fastfud_1
			ped_fud = fastfud_1
			GOSUB fud_fight_2
		ENDIF
		IF NOT IS_CHAR_DEAD fastfud_2
			ped_fud = fastfud_2
			GOSUB fud_fight_2
		ENDIF
		IF NOT IS_CHAR_DEAD fastfud_3
			ped_fud = fastfud_3
			GOSUB fud_fight_2
		ENDIF
		IF NOT IS_CHAR_DEAD fastfud_4
			ped_fud = fastfud_4
			GOSUB fud_fight_2
		ENDIF
	ENDIF
	IF flag_create_mall_fuddies_2 = 1
		IF NOT IS_CHAR_DEAD fastfud_5
			ped_fud = fastfud_5
			GOSUB fud_fight_2
		ENDIF
		IF NOT IS_CHAR_DEAD fastfud_6
			ped_fud = fastfud_6
			GOSUB fud_fight_2
		ENDIF
		IF NOT IS_CHAR_DEAD fastfud_7
			ped_fud = fastfud_7
			GOSUB fud_fight_2
		ENDIF
		IF NOT IS_CHAR_DEAD fastfud_8
			ped_fud = fastfud_8
			GOSUB fud_fight_2													
		ENDIF
	ENDIF
	IF flag_create_haiti_fuddies = 1
		IF NOT IS_CHAR_DEAD fastfud_1
		AND NOT IS_CHAR_DEAD fastfud_2
			IF NOT IS_CHAR_HEALTH_GREATER fastfud_1 95
			OR NOT IS_CHAR_HEALTH_GREATER fastfud_2 95
				GOSUB fud_fight_1
			ELSE
				SET_CHAR_WAIT_STATE fastfud_2 WAITSTATE_LOOK_ACCIDENT 999999
			ENDIF
		ELSE
			GOSUB fud_fight_1
		ENDIF
	ENDIF
	IF flag_create_dtown_fuddies = 1
		IF NOT IS_CHAR_DEAD fastfud_1
			IF NOT IS_CHAR_HEALTH_GREATER fastfud_1 95
				ped_fud = fastfud_1
				GOSUB fud_fight_1
			ENDIF
		ENDIF
	ENDIF
RETURN

fud_fight_1:
	ped_fud = fastfud_1
	GOSUB fud_fight_2
	ped_fud = fastfud_2
	GOSUB fud_fight_2
RETURN


fud_fight_2:
	IF IS_PLAYER_PLAYING player1
	AND NOT IS_CHAR_DEAD ped_fud
		SET_CHAR_WAIT_STATE ped_fud 0 0
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS ped_fud player1
		IF flag_create_haiti_fuddies = 1
		AND HAS_MODEL_LOADED tec9
			IF NOT IS_CHAR_DEAD ped_fud
				GIVE_WEAPON_TO_CHAR ped_fud	WEAPONTYPE_TEC9 999
			ENDIF
		ENDIF
	ENDIF
RETURN
*/

fud_cleanup:
	IF IS_PLAYER_PLAYING player1
		GET_PLAYER_COORDINATES player1 fud_x fud_y fud_z
	ELSE
		GOSUB fudelete
		flag_create_mall_fuddies_1 = 0	
		flag_create_mall_fuddies_2 = 0
		flag_create_haiti_fuddies = 0
		flag_create_dtown_fuddies = 0
		flag_create_vpoint_fuddies = 0
	ENDIF
	IF flag_create_mall_fuddies_1 = 1
		IF fud_x < 410.0
		OR flag_player_in_mall = 0
			DELETE_CHAR fastfud_1
			DELETE_CHAR fastfud_2
			DELETE_CHAR fastfud_3
			DELETE_CHAR fastfud_4
			REMOVE_SPHERE fud_blob1
			REMOVE_SPHERE fud_blob2
			REMOVE_SPHERE fud_blob3
			REMOVE_SPHERE fud_blob4
			UNLOAD_SPECIAL_CHARACTER 20
			flag_create_mall_fuddies_1 = 0
		ENDIF	
	ENDIF
	IF flag_create_mall_fuddies_2 = 1
		IF fud_x > 415.0
		OR flag_player_in_mall = 0
			DELETE_CHAR fastfud_5
			DELETE_CHAR fastfud_6
			DELETE_CHAR fastfud_7
			DELETE_CHAR fastfud_8
			REMOVE_SPHERE fud_blob5
			REMOVE_SPHERE fud_blob6
			REMOVE_SPHERE fud_blob7
			REMOVE_SPHERE fud_blob8
			UNLOAD_SPECIAL_CHARACTER 20
			flag_create_mall_fuddies_2 = 0
		ENDIF	
	ENDIF
	IF flag_create_haiti_fuddies = 1
	AND flag_player_in_haiti = 0
		DELETE_CHAR fastfud_ht1
		DELETE_CHAR fastfud_ht2
		UNLOAD_SPECIAL_CHARACTER 20
		REMOVE_SPHERE fud_blob1
		//MARK_MODEL_AS_NO_LONGER_NEEDED tec9
		//MARK_MODEL_AS_NO_LONGER_NEEDED
		flag_create_haiti_fuddies = 0
	ENDIF
	IF flag_create_dtown_fuddies = 1
	AND flag_player_in_downtown = 0
		DELETE_CHAR fastfud_dt
		UNLOAD_SPECIAL_CHARACTER 20
		REMOVE_SPHERE fud_blob1
		//MARK_MODEL_AS_NO_LONGER_NEEDED
		flag_create_dtown_fuddies = 0
	ENDIF
	IF flag_create_vpoint_fuddies = 1
	AND flag_player_in_vpoint = 0
		DELETE_CHAR fastfud_vp
		UNLOAD_SPECIAL_CHARACTER 20
		REMOVE_SPHERE fud_blob1
		//MARK_MODEL_AS_NO_LONGER_NEEDED
		flag_create_vpoint_fuddies = 0
	ENDIF
	//CLEAR_MISSION_AUDIO 1
	//SET_PLAYER_CONTROL player1 ON
	//SET_EVERYONE_IGNORE_PLAYER player1 OFF

RETURN



fudelete:
	DELETE_CHAR fastfud_1
	DELETE_CHAR fastfud_2
	DELETE_CHAR fastfud_3
	DELETE_CHAR fastfud_4
	DELETE_CHAR fastfud_5
	DELETE_CHAR fastfud_6
	DELETE_CHAR fastfud_7
	DELETE_CHAR fastfud_8
	DELETE_CHAR fastfud_vp
	DELETE_CHAR fastfud_dt
	DELETE_CHAR fastfud_ht1
	DELETE_CHAR fastfud_ht2
	REMOVE_SPHERE fud_blob1
	REMOVE_SPHERE fud_blob2
	REMOVE_SPHERE fud_blob3
	REMOVE_SPHERE fud_blob4
	REMOVE_SPHERE fud_blob5
	REMOVE_SPHERE fud_blob6
	REMOVE_SPHERE fud_blob7
	REMOVE_SPHERE fud_blob8
	//MARK_MODEL_AS_NO_LONGER_NEEDED tec9
	UNLOAD_SPECIAL_CHARACTER 20
RETURN

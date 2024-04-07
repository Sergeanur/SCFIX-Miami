MISSION_START

VAR_INT	flag_mob_01
VAR_INT	flag_mob_02
//VAR_INT	flag_mob_03
VAR_INT	flag_mob_04
VAR_INT	flag_mob_05
VAR_INT	flag_mob_06
//VAR_INT	flag_mob_07
VAR_INT	flag_mob_08
VAR_INT	flag_mob_09
//VAR_INT	flag_mob_10
VAR_INT	flag_mob_11
//VAR_INT	flag_mob_12
//VAR_INT	flag_mob_13
VAR_INT	flag_mob_14
//VAR_INT	flag_mob_15
VAR_INT	flag_mob_16
VAR_INT	flag_mob_17
VAR_INT	flag_mob_18
//VAR_INT	flag_mob_19
VAR_INT	flag_mob_20
VAR_INT	flag_mob_24
VAR_INT	flag_mob_25
VAR_INT	flag_mob_26
//VAR_INT	flag_mob_29
VAR_INT	flag_mob_30
VAR_INT	flag_mob_33
VAR_INT	flag_mob_34
//VAR_INT	flag_mob_35
VAR_INT	flag_mob_36
VAR_INT	flag_mob_40
VAR_INT	flag_mob_41
VAR_INT	flag_mob_42
VAR_INT	flag_mob_43
VAR_INT	flag_mob_45
VAR_INT	flag_mob_46
VAR_INT	flag_mob_47
VAR_INT	flag_mob_52
//VAR_INT	flag_mob_54
//VAR_INT	flag_mob_55
VAR_INT	flag_mob_56 // SCFIX
//VAR_INT	flag_mob_57
//VAR_INT	flag_mob_58
VAR_INT flag_mob_62
VAR_INT flag_mob_63
VAR_INT flag_mob_66
VAR_INT flag_mob_68
VAR_INT flag_mob_70
VAR_INT flag_mob_71
VAR_INT flag_mob_72
VAR_INT flag_mob_73
//VAR_INT	flag_mob_90
//VAR_INT	flag_mob_91
//VAR_INT	flag_mob_92
//VAR_INT	flag_mob_93
//VAR_INT	flag_mob_94
VAR_INT	flag_mob_95
VAR_INT	flag_mob_96
VAR_INT	flag_mob_97
VAR_INT	flag_mob_98
VAR_INT	flag_mob_99

VAR_INT flag_sonny_lance_dead
VAR_INT flag_diaz_dead
VAR_INT flag_colonel_left_town

VAR_INT ring_a_ding_ding mobile_pause //	flag_mobile_dialogue

VAR_INT counter_60_percent flag_caryard_purchased
//VAR_INT flag_first_asset_complete
VAR_INT audio_slot_mobile
				
//VAR_INT timer_mobile_start timer_mobile_now timer_mobile_diff
VAR_INT flag_mobile_timer flag_player_answered_phone
VAR_INT flag_cell_nation
VAR_INT flag_new_cont
VAR_INT call_delay
VAR_INT players_skipping_the_call // SCFIX
   
//VAR_FLOAT player_heading

// SET FLAGS AND VARIABLES
flag_mob_01	= 0
flag_mob_02	= 0
//flag_mob_03	= 0
flag_mob_04	= 0
flag_mob_05	= 0
flag_mob_06	= 0
//flag_mob_07	= 0
flag_mob_08	= 0
flag_mob_09	= 0
//flag_mob_10	= 0
flag_mob_11	= 0
//flag_mob_12	= 0
//flag_mob_13	= 0
flag_mob_14	= 0
//flag_mob_15	= 0
flag_mob_16	= 0
flag_mob_17	= 0
flag_mob_18	= 0
//flag_mob_19	= 0
flag_mob_20	= 0
flag_mob_24 = 0
flag_mob_25 = 0
flag_mob_26 = 0
//flag_mob_29 = 0
flag_mob_30 = 0
flag_mob_33 = 0
flag_mob_34 = 0
//flag_mob_35 = 0
flag_mob_36 = 0
flag_mob_40	= 0
flag_mob_41	= 0
flag_mob_42	= 0
flag_mob_43	= 0
flag_mob_45 = 0
flag_mob_46	= 0
flag_mob_47	= 0
flag_mob_52	= 0
//flag_mob_54	= 0
//flag_mob_55	= 0
flag_mob_56	= 0 // SCFIX
//flag_mob_57	= 0
//flag_mob_58	= 0
flag_mob_62 = 0
flag_mob_63 = 0
flag_mob_66 = 0
flag_mob_68 = 0
flag_mob_70 = 0
flag_mob_71 = 0
flag_mob_72 = 0
flag_mob_73 = 0
//flag_mob_90	= 0
//flag_mob_91	= 0
//flag_mob_92	= 0
//flag_mob_93	= 0
//flag_mob_94	= 0
flag_mob_95	= 0
flag_mob_96	= 0
flag_mob_97	= 0
flag_mob_98	= 0
flag_mob_99	= 0

flag_new_cont = 0

counter_60_percent = 0
flag_caryard_purchased = 0

flag_first_asset_complete = 0
//flag_mobile_dialogue = 0
flag_mobile_timer = 0
flag_player_answered_phone = 0

flag_sonny_lance_dead = 0
flag_diaz_dead = 0
flag_colonel_left_town = 0

flag_cell_nation = 0

call_delay = 20000
players_skipping_the_call = 0 // SCFIX

SCRIPT_NAME	CELLFON

SET_DEATHARREST_STATE OFF //stops script being terminated if Player dies/arrested


mission_start_cell_phone:

{
	START_NEW_SCRIPT cell_phone

	MISSION_END
}
  


cell_phone:

{
SET_DEATHARREST_STATE OFF //stops script being terminated if Player dies/arrested

SCRIPT_NAME CELL

GOTO filschie_cunningness
CREATE_OBJECT_NO_OFFSET comgate1open -712.524 -489.428 12.549 star_gate_1
CREATE_OBJECT_NO_OFFSET comgate2open -712.524 -489.428 12.549 star_gate_2
CREATE_PICKUP_WITH_AMMO weapon_model_slot_6 PICKUP_ONCE ammo_slot_6 pickup_x pickup_y pickup_z printworks_cash_pickup
filschie_cunningness:

	// TEST! TEST! TEST! TEST! TEST! TEST! TEST! TEST! TEST! TEST! TEST!
	//CREATE_CLOTHES_PICKUP 96.8 -1473.5 10.4 7 clothes_pickup13
	//clothes13_created = 1
	//START_NEW_SCRIPT cloth9
	// OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO

cell_phone_inner:
	
	WAIT 0
	// ***************** SET TEST FLAGS ***********************
	//flag_lawyer_mission2_passed = 1 
	
	//flag_sonny_lance_dead = 1 // end-game calls
	
   	//flag_mob_18 = 1 // CORTEZ asks after Mercedes
   	//flag_mob_63 = 1 // bypass mob-63
	//flag_finale_mission2_passed = 1	// NO CALLS FROM SONNY
	//flag_lawyer_mission3_passed = 1	//CALLS FROM SONNY
	
	//flag_counter_mission1_passed = 1 //3rd Sonny Call
	//flag_porn_mission1_passed = 1 //3rd Sonny Call
	//flag_mob_41 = 1 //3rd Sonny Call

	//flag_general_mission3_passed = 1 //MOB-62
	//flag_baron_mission3_passed = 1 // MOB_46
	//flag_lawyer_mission4_passed = 1 // MOB-24
	//flag_protect_mission1_passed = 1

    //flag_baron_mission4_passed = 1 // MOB_01
	//flag_sergio_mission1_passed = 1	// MOB_01
	//flag_general_mission5_passed = 1 // MOB_01
	//flag_general_mission4_passed = 1 // MOB_25
	//flag_kent_mission1_passed = 1 // MOB_25
	//flag_cuban_mission4_passed = 1 // MOB_30
	//flag_counter_mission2_passed = 1 //MOB_02
	//counter_60_percent = 6 //MOB_02

	//flag_bikers_mission3_passed = 1 //MO_05

	//flag_caryard_purchased = 1 //MOB_03
	//flag_rock_mission1_passed = 1  //MOB_04

	//flag_first_asset_complete = 1 //MOB_14

	//flag_rock_mission3_passed = 1  //MOB_26

	//flag_haitian_mission1_passed = 1 //MOB_29

	//flag_bankjob_mission4_passed = 1 //MOB_34

	//flag_phil_mission2_passed = 1	// MOB_36



	// *******************************************************8

	IF flag_player_on_mission = 0
	AND flag_mobile_timer = 0
		GET_GAME_TIMER timer_mobile_start
		flag_mobile_timer = 1
	ENDIF

	// OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
	//PRINT_WITH_NUMBER_NOW REWARD timer_mobile_diff 500 1 //TEST !!!!!!
	// OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO

	IF flag_lawyer_mission2_passed = 1

		IF IS_PLAYER_PLAYING player1
			IF IS_CHAR_ON_FOOT scplayer
			AND flag_player_on_mission = 0
			AND	flag_cell_nation = 0

				GOSUB mobile_timer
				//STORE_WANTED_LEVEL player1 player_wanted

				IF NOT IS_WANTED_LEVEL_GREATER player1 0
				AND timer_mobile_diff > call_delay
					
					IF LOCATE_PLAYER_ON_FOOT_3D player1 printbuyX printbuyY printbuyZ 4.0 4.0 4.0 FALSE
						GOTO cell_phone_inner
					ENDIF
					
					IF LOCATE_PLAYER_ON_FOOT_3D player1 carbuyX carbuyY carbuyZ 4.0 4.0 4.0 FALSE
						GOTO cell_phone_inner
					ENDIF
					
					IF LOCATE_PLAYER_ON_FOOT_3D player1 pornbuyX pornbuyY pornbuyZ 4.0 4.0 4.0 FALSE
						GOTO cell_phone_inner
					ENDIF
					
					IF LOCATE_PLAYER_ON_FOOT_3D player1 icebuyX icebuyY icebuyZ 4.0 4.0 4.0 FALSE
						GOTO cell_phone_inner
					ENDIF
					
					IF LOCATE_PLAYER_ON_FOOT_3D player1 taxibuyX taxibuyY taxibuyZ 4.0 4.0 4.0 FALSE
						GOTO cell_phone_inner
					ENDIF
					
					IF LOCATE_PLAYER_ON_FOOT_3D player1 bankbuyX bankbuyY bankbuyZ 4.0 4.0 4.0 FALSE
						GOTO cell_phone_inner
					ENDIF
					
					IF LOCATE_PLAYER_ON_FOOT_3D player1 boatbuyX boatbuyY boatbuyZ 4.0 4.0 4.0 FALSE
						GOTO cell_phone_inner
					ENDIF
					
					
					
					// LEO'S PARTNER CALLS LEO'S PHONE -----------------------------------------------------
					IF flag_mob_52 = 0
						//RING_PLAYER_PHONE TRUE
						PRINT_HELP ( ANSWER )
						GOSUB mobile_rings
						IF flag_player_answered_phone = 1	
							audio_slot_mobile = 1
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_52a
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB52_a ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_52b
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB52_b ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_52c
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB52_c ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_52d
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB52_d ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_52e
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB52_e ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_52f
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB52_f ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_52g
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB52_g ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_52h
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB52_h ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							CLEAR_PRINTS
						ENDIF
						IF flag_player_answered_phone = 1	
							flag_mob_52 = 1
							//ADD_SPRITE_BLIP_FOR_CONTACT_POINT cubanX cubanY cubanZ the_cuban_blip cuban_contact_blip
							//START_NEW_SCRIPT cuban_mission1_loop
						ENDIF
						mob_52_plonk:
						GOSUB mobile_message_cleanup
						GOTO cell_phone_inner
					ENDIF
					
					
					IF flag_general_mission5_passed = 1
						flag_colonel_left_town = 1
					ENDIF
					IF flag_colonel_left_town = 0
						// CORTEZ INVITES PLAYER OVER FOR BUSINESS) -----------------------------------------------------
						IF flag_mob_24 = 0
						AND flag_lawyer_mission4_passed = 1
							//RING_PLAYER_PHONE TRUE
							
							GOSUB mobile_rings
							IF flag_player_answered_phone = 1	
								audio_slot_mobile = 1
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_24a
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_24a ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_24b
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_24b ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_24c
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_24c ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_24d
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_24d ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_24e
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_24e ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_24f
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_24f ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_24g
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_24g ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_24h
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_24h ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								CLEAR_PRINTS
							ENDIF
							IF flag_player_answered_phone = 1	
								flag_mob_24 = 1
								START_NEW_SCRIPT general_mission1_loop
								REMOVE_BLIP	general_contact_blip
								ADD_SPRITE_BLIP_FOR_CONTACT_POINT generalX generalY generalZ RADAR_SPRITE_CORTEZ general_contact_blip
								//FLASH_RADAR_BLIP general_contact_blip
								PRINT_HELP NEWCONT
								flag_new_cont = 1
							ENDIF
							mob_24_plonk:
							GOSUB mobile_message_cleanup
							GOTO cell_phone_inner
						ENDIF

						// CORTEZ ASKS FOR HELP -----------------------------------------------------
						IF flag_mob_70 = 0
						AND flag_baron_mission2_passed = 1
							//RING_PLAYER_PHONE TRUE
							
							GOSUB mobile_rings
							IF flag_player_answered_phone = 1	
								audio_slot_mobile = 1
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_70a
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_70a ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_70b
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_70b ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								CLEAR_PRINTS
							ENDIF
							IF flag_player_answered_phone = 1	
								flag_mob_70 = 1
								START_NEW_SCRIPT general_mission4_loop
								REMOVE_BLIP	general_contact_blip
								ADD_SPRITE_BLIP_FOR_CONTACT_POINT generalX generalY generalZ RADAR_SPRITE_CORTEZ general_contact_blip
							ENDIF
							mob_70_plonk:
							GOSUB mobile_message_cleanup
							GOTO cell_phone_inner
						ENDIF
					
					
						// COLONEL ASKS PLAYER FOR HELP ----------------------------------------------
						IF flag_mob_25 = 0
						AND flag_general_mission4_passed = 1
						AND flag_general_mission5_passed = 0
						AND flag_kent_mission1_passed = 1
							//RING_PLAYER_PHONE TRUE
							GOSUB mobile_rings
							IF flag_player_answered_phone = 1	
								audio_slot_mobile = 1
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_25a
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_25a ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_25b
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_25b ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_25c
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_25c ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_25d
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_25d ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								CLEAR_PRINTS
							ENDIF
							IF flag_player_answered_phone = 1	
								flag_mob_25 = 1
								START_NEW_SCRIPT general_mission5_loop
								REMOVE_BLIP	general_contact_blip
								ADD_SPRITE_BLIP_FOR_CONTACT_POINT generalX generalY generalZ RADAR_SPRITE_CORTEZ general_contact_blip
							ENDIF
							mob_25_plonk:
							GOSUB mobile_message_cleanup
							GOTO cell_phone_inner
						ENDIF
					
					ELSE
					
						
					// KENT PAUL PHONES ABOUT SHAGGING MERCEDES ****************************************************
						
						IF flag_mob_18 = 0
						AND flag_finale_mission2_passed = 1
							
							GOSUB mobile_rings
							IF flag_player_answered_phone = 1	
								audio_slot_mobile = 1
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_18a
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_18a ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_18b
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_18b ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_18c
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_18c ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_18d
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_18d ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_18e
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_18e ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_18f
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_18f ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_18g
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_18g ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								CLEAR_PRINTS
							ENDIF
							IF flag_player_answered_phone = 1	
								flag_mob_18 = 1
							ENDIF
							mob_18_plonk:
							GOSUB mobile_message_cleanup
							GOTO cell_phone_inner
						ENDIF
						

						// CORTEZ ASKS ABOUT MERCEDES -----------------------------------------------------
						IF flag_mob_71 = 0
						AND flag_mob_18 = 1
						AND flag_finale_mission2_passed = 1
							//RING_PLAYER_PHONE TRUE
							
							GOSUB mobile_rings
							IF flag_player_answered_phone = 1	
								audio_slot_mobile = 1
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_71a
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB21_a ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_71b
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB21_b ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_71c
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB21_G ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_71d
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB21_H ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_71e
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB21_I ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_71f
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB21_K ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_71g
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB21_M ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_71h
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB21_N ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_71i
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB21_O ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_71j
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB21_P ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_71k
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB21_Q ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_71l
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB21_R ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_71m
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB21_T ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_71n
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB21_U ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								CLEAR_PRINTS
							ENDIF
							IF flag_player_answered_phone = 1	
								flag_mob_71 = 1
							ENDIF
							mob_71_plonk:
							GOSUB mobile_message_cleanup
							GOTO cell_phone_inner
						ENDIF

					
					ENDIF
					
					
					
					// ******************** DIAZ OFFERS PLAYER WORK - OPEN CONTACT POINT ***********************************
					IF flag_baron_mission5_passed = 1
						flag_diaz_dead = 1
					ENDIF
					IF flag_diaz_dead = 0
						IF flag_mob_62 = 0
						AND flag_general_mission3_passed = 1
							//RING_PLAYER_PHONE TRUE
							GOSUB mobile_rings
							IF flag_player_answered_phone = 1	
								audio_slot_mobile = 1
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_62a
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_62a ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_62b
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_62b ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_62c
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_62c ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_62d
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_62d ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								CLEAR_PRINTS
							ENDIF
							IF flag_player_answered_phone = 1	
								flag_mob_62 = 1
								//SWITCH_PED_ROADS_ON -787.8 -519.4 10.0 -657.5 -475.2 20.0 // Star Island gates mainland
					            SWITCH_PED_ROADS_ON -230.0 -464.5 10.0 56.85 -459.8 20.0 // Star Island gates ocean beach
					            //SWITCH_ROADS_ON -787.8 -519.4 10.0 -657.5 -475.2 20.0 // Star Island gates     mainland
					            SWITCH_ROADS_ON -230.0 -464.5 10.0 165.85 -459.8 20.0 // Star Island gates ocean beach
					            //DELETE_OBJECT star_gate_1
					            DELETE_OBJECT star_gate_2
					            //CREATE_OBJECT_NO_OFFSET comgate1open -712.524 -489.428 12.549 star_gate_1
								//SET_OBJECT_HEADING star_gate_1 3.0
					            //DONT_REMOVE_OBJECT star_gate_1
					            CREATE_OBJECT_NO_OFFSET comgate2open -183.824 -473.223 12.615 star_gate_2
								//SET_OBJECT_HEADING star_gate_2 12.5
					            DONT_REMOVE_OBJECT star_gate_2
								REMOVE_BLIP baron_contact_blip
								ADD_SPRITE_BLIP_FOR_CONTACT_POINT baronX baronY baronZ the_baron_blip baron_contact_blip
								START_NEW_SCRIPT baron_mission1_loop
							ENDIF
							mob_62_plonk:
							GOSUB mobile_message_cleanup
							GOTO cell_phone_inner
						ENDIF
					// SCFIX: START
					ELSE
						IF flag_mob_56 = 0
							//RING_PLAYER_PHONE TRUE
							GOSUB mobile_rings
							IF flag_player_answered_phone = 1	
								audio_slot_mobile = 1
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_56a
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB56_a ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_56b
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB56_b ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_56c
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB56_c ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_56d
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB5_6d ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_56e
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB56_e ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_56f
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB56_f ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								CLEAR_PRINTS
							ENDIF
							IF flag_player_answered_phone = 1	
								flag_mob_56 = 1
							ENDIF
							mob_56_plonk:
							GOSUB mobile_message_cleanup
							GOTO cell_phone_inner
						ENDIF
					// SCFIX: END
					ENDIF
						
					
					


					// PAUL WARNS PLAYER ABOUT MOB HIT --------------------------------------------------------
					IF flag_mob_20 = 0
					AND flag_general_mission5_passed = 1
						//RING_PLAYER_PHONE TRUE
						GOSUB mobile_rings
						IF flag_player_answered_phone = 1	
							audio_slot_mobile = 1
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_20a
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_20a ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_20b
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_20b ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_20c
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_20c ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_20d
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_20d ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_20e
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_20e ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							CLEAR_PRINTS
						ENDIF
						IF flag_player_answered_phone = 1	
							flag_mob_20 = 1
							//ADD_SPRITE_BLIP_FOR_CONTACT_POINT stuntX stuntY stuntZ the_stunt_blip stunt_contact_blip
							//START_NEW_SCRIPT stunt_mission_loop
						ENDIF
						mob_20_plonk:
						GOSUB mobile_message_cleanup
						GOTO cell_phone_inner
					ENDIF



					//KENT WARNS PLAYER. 'RESCUE BUDDY'------------------------------------------------------------------
					IF flag_mob_01 = 0
					AND flag_mob_46 = 1
					AND flag_baron_mission4_passed = 1
					AND flag_general_mission4_passed = 1
					//AND flag_sergio_mission1_passed = 1
						//RING_PLAYER_PHONE TRUE
						GOSUB mobile_rings
						IF flag_player_answered_phone = 1	
							audio_slot_mobile = 1
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_01a
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_01a ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_01b
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_01b ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_01c
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_01c ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							CLEAR_PRINTS
						ENDIF
						IF flag_player_answered_phone = 1	
							flag_mob_01 = 1
							REMOVE_BLIP	kent_contact_blip
							ADD_SPRITE_BLIP_FOR_CONTACT_POINT 491.0 -77.7 10.4 the_kent_blip kent_contact_blip
							START_NEW_SCRIPT kent_mission1_loop
							flag_kent_mission_active = 1
						ENDIF
						mob_01_plonk:
						GOSUB mobile_message_cleanup
						GOTO cell_phone_inner
					ENDIF
					
					

					// LAWYER PHONES PLAYER. 'CAP THE COLLECTOR' --------------------------------------------------------
					IF flag_mob_02 = 0
					AND flag_counter_mission2_passed = 1
					AND flag_protect_mission3_passed = 1
					AND counter_60_percent > 6
						//RING_PLAYER_PHONE TRUE
						GOSUB mobile_rings
						IF flag_player_answered_phone = 1	
							audio_slot_mobile = 1
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_02a
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_02a ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_02b
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_02b ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_02c
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_02c ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							CLEAR_PRINTS
						ENDIF
						IF flag_player_answered_phone = 1	
							flag_mob_02 = 1
							REMOVE_PICKUP printworks_cash_pickup
							REMOVE_BLIP	counter_contact_blip
							ADD_SPRITE_BLIP_FOR_CONTACT_POINT counterX counterY counterZ the_counter_blip counter_contact_blip
							START_NEW_SCRIPT finale_mission1_loop
						ENDIF
						mob_02_plonk:
						GOSUB mobile_message_cleanup
						GOTO cell_phone_inner
					ENDIF
					
					// KENT ASKS PLAYER OVER TO STUDIO -OPEN LOVE FIST MISSIONS ---------------------------------------
					IF flag_mob_68 = 0
					AND flag_baron_mission5_passed = 1
						//RING_PLAYER_PHONE TRUE
						GOSUB mobile_rings
						IF flag_player_answered_phone = 1	
							audio_slot_mobile = 1
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_68a
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_68a ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_68b
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_68b ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_68c
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_68c ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_68d
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_68d ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							CLEAR_PRINTS
						ENDIF
						IF flag_player_answered_phone = 1	
							flag_mob_68 = 1
							ADD_SPRITE_BLIP_FOR_CONTACT_POINT rockX rockY rockZ the_rock_blip rock_contact_blip
							START_NEW_SCRIPT rock_mission1_loop
						ENDIF
						mob_68_plonk:
						GOSUB mobile_message_cleanup
						GOTO cell_phone_inner
					ENDIF

					

					// KENT ASKS PLAYER FOR GIG SECURITY -OPEN BIKER GANG MISSIONS ---------------------------------------
					IF flag_mob_04 = 0
					AND flag_rock_mission1_passed = 1
						//RING_PLAYER_PHONE TRUE
						GOSUB mobile_rings
						IF flag_player_answered_phone = 1	
							audio_slot_mobile = 1
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_04a
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_04a ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_04b
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_04b ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_04c
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_04c ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_04d
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_04d ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							CLEAR_PRINTS
						ENDIF
						IF flag_player_answered_phone = 1	
							flag_mob_04 = 1
							ADD_SPRITE_BLIP_FOR_CONTACT_POINT bikersX bikersY bikersZ the_biker_blip bikers_contact_blip
							START_NEW_SCRIPT bikers_mission1_loop
						ENDIF
						mob_04_plonk:
						GOSUB mobile_message_cleanup
						GOTO cell_phone_inner
					ENDIF
					
					

					// BIKER MISSIONS COMPLETED, MITCH WILL DO GIG SECURITY ----------------------------------------------
					IF flag_mob_05 = 0
					AND flag_bikers_mission3_passed = 1
						//RING_PLAYER_PHONE TRUE
						GOSUB mobile_rings
						IF flag_player_answered_phone = 1	
							audio_slot_mobile = 1
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_05a
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_05a ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_05b
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_05b ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_05c
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_05c ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_05d
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_05d ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							CLEAR_PRINTS
						ENDIF
						IF flag_player_answered_phone = 1	
							flag_mob_05 = 1
							//ADD_SPRITE_BLIP_FOR_CONTACT_POINT bikersX bikersY bikersZ the_biker_blip bikers_contact_blip
							//START_NEW_SCRIPT bikers_mission1_loop
						ENDIF
						mob_05_plonk:
						GOSUB mobile_message_cleanup
						GOTO cell_phone_inner
					ENDIF
					

					// MITCH THANKS PLAYER FOR THE GIG --------------------------------------------------------
					IF flag_mob_26 = 0
					AND flag_rock_mission3_passed = 1
						//RING_PLAYER_PHONE TRUE
						GOSUB mobile_rings
						IF flag_player_answered_phone = 1	
							audio_slot_mobile = 1
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_26a
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_26a ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_26b
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_26b ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_26c
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_26c ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_26d
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_26d ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_26e
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_26e ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							CLEAR_PRINTS
						ENDIF
						IF flag_player_answered_phone = 1	
							flag_mob_26 = 1
							//ADD_SPRITE_BLIP_FOR_CONTACT_POINT stuntX stuntY stuntZ the_stunt_blip stunt_contact_blip
							//START_NEW_SCRIPT stunt_mission_loop
						ENDIF
						mob_26_plonk:
						GOSUB mobile_message_cleanup
						GOTO cell_phone_inner
					ENDIF
					
					
					

					// UMBERTO OFFERS PLAYER WORK -OPEN CUBAN CONTACT POINT ------------------------------------------
					IF flag_mob_09 = 0
					AND flag_sergio_mission3_passed = 1
						//RING_PLAYER_PHONE TRUE
						GOSUB mobile_rings
						IF flag_player_answered_phone = 1	
							audio_slot_mobile = 1
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_09a
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_09a ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_09b
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_09b ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_09c
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_09c ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_09d
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_09d ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_09e
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_09e ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_09f
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_09f ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							CLEAR_PRINTS
						ENDIF
						IF flag_player_answered_phone = 1	
							flag_mob_09 = 1
							REMOVE_BLIP	cuban_contact_blip
							ADD_SPRITE_BLIP_FOR_CONTACT_POINT cubanX cubanY cubanZ the_cuban_blip cuban_contact_blip
							START_NEW_SCRIPT cuban_mission1_loop
						ENDIF
						mob_09_plonk:
						GOSUB mobile_message_cleanup
						GOTO cell_phone_inner
					ENDIF
					
					/*
					// UMBERTO OFFERS PLAYER WORK -----------------------------------------------------
					IF flag_mob_29 = 0
					AND flag_haitian_mission1_passed = 1
						//RING_PLAYER_PHONE TRUE
						GOSUB mobile_rings
						IF flag_player_answered_phone = 1	
							audio_slot_mobile = 1
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_29a
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_29a ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_29b
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_29b ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_29c
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_29c ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_29d
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_29d ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_29e
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_29e ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_29f
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_29f ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_29g
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_29g ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							CLEAR_PRINTS
						ENDIF
						IF flag_player_answered_phone = 1	
							flag_mob_29 = 1
							//ADD_SPRITE_BLIP_FOR_CONTACT_POINT cubanX cubanY cubanZ the_cuban_blip cuban_contact_blip
							//START_NEW_SCRIPT cuban_mission1_loop
						ENDIF
						mob_29_plonk:
						GOSUB mobile_message_cleanup
						GOTO cell_phone_inner
					ENDIF
					*/
					
					
					// AUNTIE POULET CONTACTS PLAYER -HAITIAN CONTACT POINT OPENED --------------------------------------
					IF flag_mob_06 = 0
					AND flag_cuban_mission1_passed = 1
						//RING_PLAYER_PHONE TRUE
						GOSUB mobile_rings
						IF flag_player_answered_phone = 1	
							audio_slot_mobile = 1
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_06a
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_06a ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_06b
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_06b ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_06c
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_06c ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							CLEAR_PRINTS
						ENDIF
						IF flag_player_answered_phone = 1	
							flag_mob_06 = 1
							ADD_SPRITE_BLIP_FOR_CONTACT_POINT haitianX haitianY haitianZ the_haitian_blip haitian_contact_blip
							START_NEW_SCRIPT haitian_mission1_loop
						ENDIF
						mob_06_plonk:
						GOSUB mobile_message_cleanup
						GOTO cell_phone_inner
					ENDIF
					
					// AUNTIE POULET CONTACTS PLAYER -HAITIAN CONTACT POINT CLOSED --------------------------------------
					
					IF flag_mob_66 = 0
					AND flag_haitian_mission3_passed = 1
						IF IS_PLAYER_PLAYING player1
							IF IS_PLAYER_IN_ZONE player1 HAITI
								//RING_PLAYER_PHONE TRUE
								GOSUB mobile_rings
								IF flag_player_answered_phone = 1	
									audio_slot_mobile = 1
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_66a
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_66a ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_66b
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_66b ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									CLEAR_PRINTS
								ENDIF
								IF flag_player_answered_phone = 1	
									flag_mob_66 = 1
								ENDIF
								mob_66_plonk:
								GOSUB mobile_message_cleanup
								GOTO cell_phone_inner
							ENDIF
						ENDIF
					ENDIF
					

					
					// LAWYER GIVES PLAYER ASSET COMPLETE ADVICE -----------------------------------------------------
					IF flag_mob_08 = 0
					AND flag_first_asset_complete = 1
						//RING_PLAYER_PHONE TRUE
						GOSUB mobile_rings
						IF flag_player_answered_phone = 1	
							audio_slot_mobile = 1
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_08a
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_08a ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_08b
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_08b ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_08c
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_08c ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_08d
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_08d ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_08e
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_08e ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_08f
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_08f ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_08g
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_08g ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							CLEAR_PRINTS
						ENDIF
						IF flag_player_answered_phone = 1	
							flag_mob_08 = 1
							//ADD_SPRITE_BLIP_FOR_CONTACT_POINT haitianX haitianY haitianZ the_haitian_blip haitian_contact_blip
							//START_NEW_SCRIPT haitian_mission1_loop
						ENDIF
						mob_08_plonk:
						GOSUB mobile_message_cleanup
						GOTO cell_phone_inner
					ENDIF
					
					
					/*
					// STEVE TELLS PLAYER ABOUT STUNT MISSION --------------------------------------------------------
					IF flag_mob_10 = 0
					AND flag_porn_mission2_passed = 1
						//RING_PLAYER_PHONE TRUE
						GOSUB mobile_rings
						IF flag_player_answered_phone = 1	
							audio_slot_mobile = 1
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_10a
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_10a ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_10b
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_10b ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_10c
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_10c ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_10d
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_10d ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_10e
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_10e ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							CLEAR_PRINTS
						ENDIF
						IF flag_player_answered_phone = 1	
							flag_mob_10 = 1
							//ADD_SPRITE_BLIP_FOR_CONTACT_POINT stuntX stuntY stuntZ the_stunt_blip stunt_contact_blip
							//START_NEW_SCRIPT stunt_mission_loop
						ENDIF
						mob_10_plonk:
						GOSUB mobile_message_cleanup
						GOTO cell_phone_inner
					ENDIF
					*/
					

					// AVERY GIVES PLAYER PROPERTY ADVICE -----------------------------------------------------
					IF flag_mob_11 = 0
					AND flag_protect_mission1_passed = 1
					AND flag_lawyer_mission4_passed = 1
						//RING_PLAYER_PHONE TRUE
						GOSUB mobile_rings
						IF flag_player_answered_phone = 1	
							audio_slot_mobile = 1
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_11a
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_11a ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_11b
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_11b ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_11c
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_11c ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_11d
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_11d ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_11e
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_11e ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_11f
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_11f ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							CLEAR_PRINTS
						ENDIF
						IF flag_player_answered_phone = 1	
							flag_mob_11 = 1
							//LAUNCH_MISSION property.sc
						ENDIF
						mob_11_plonk:
						GOSUB mobile_message_cleanup
						GOTO cell_phone_inner
					ENDIF

					

					// PAUL TELLS PLAYER ABOUT SWAT RETIREMENT FUND AT THE BANK -----------------------------------------------------
					IF flag_mob_14 = 0
					AND flag_bought_malibu = 1 // SCFIX

						//RING_PLAYER_PHONE TRUE
						GOSUB mobile_rings
						IF flag_player_answered_phone = 1	
							audio_slot_mobile = 1
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_14a
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_14a ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_14b
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_14b ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_14c
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_14c ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_14d
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_14d ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_14e
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_14e ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_14f
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_14f ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_14g
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_14g ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_14h
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_14h ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							CLEAR_PRINTS
						ENDIF
						IF flag_player_answered_phone = 1	
							flag_mob_14 = 1
							// SCFIX: Start
							ADD_SPRITE_BLIP_FOR_CONTACT_POINT bankjobX bankjobY bankjobZ the_bankjob_blip bankjob_contact_blip
							START_NEW_SCRIPT bankjob_mission1_loop
							// SCFIX: END
						ENDIF
						mob_14_plonk:
						GOSUB mobile_message_cleanup
						GOTO cell_phone_inner
					ENDIF

					
					

					// UMBERTO THANKS PLAYER FOR HELP -----------------------------------------------------
					IF flag_mob_30 = 0                   
					AND flag_cuban_mission4_passed = 1
						//RING_PLAYER_PHONE TRUE
						GOSUB mobile_rings
						IF flag_player_answered_phone = 1	
							audio_slot_mobile = 1
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_30a
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_30a ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_30b
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_30b ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_30c
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_30c ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_30d
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_30d ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_30e
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_30e ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_30f
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_30f ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							CLEAR_PRINTS
						ENDIF
						IF flag_player_answered_phone = 1	
							flag_mob_30 = 1
							//LAUNCH_MISSION property.sc
						ENDIF
						mob_30_plonk:
						GOSUB mobile_message_cleanup
						GOTO cell_phone_inner
					ENDIF


					// PHIL INVITES PLAYER OVER (TRIGGER 1st MISSION) ----------------------------------------------
					IF flag_mob_34 = 0
					AND flag_bankjob_mission4_passed = 1
						//RING_PLAYER_PHONE TRUE
						GOSUB mobile_rings
						IF flag_player_answered_phone = 1	
							audio_slot_mobile = 1
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_34a
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_34a ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_34b
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_34b ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_34c
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_34c ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_34d
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_34d ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							CLEAR_PRINTS
						ENDIF
						IF flag_player_answered_phone = 1	
							flag_mob_34 = 1
							ADD_SPRITE_BLIP_FOR_CONTACT_POINT philX philY philZ the_phil_blip phil_contact_blip
							START_NEW_SCRIPT phil_mission1_loop
						ENDIF
						mob_34_plonk:
						GOSUB mobile_message_cleanup
						GOTO cell_phone_inner
					ENDIF
					
					

					// PHIL ASKS PLAYER OVER FOR DRINK (TRIGGER 2nd MISSION) ----------------------------------------------
					IF flag_mob_33 = 0
					AND flag_phil_mission1_passed = 1
						//RING_PLAYER_PHONE TRUE
						GOSUB mobile_rings
						IF flag_player_answered_phone = 1	
							audio_slot_mobile = 1
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_33a
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_33a ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_33b
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_33b ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_33c
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_33c ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_33d
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_33d ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							CLEAR_PRINTS
						ENDIF
						IF flag_player_answered_phone = 1	
							flag_mob_33 = 1
							ADD_SPRITE_BLIP_FOR_CONTACT_POINT philX philY philZ the_phil_blip phil_contact_blip
							START_NEW_SCRIPT phil_mission2_loop
						ENDIF
						mob_33_plonk:
						GOSUB mobile_message_cleanup
						GOTO cell_phone_inner
					ENDIF


					
					/*
					// PHIL THANKS PLAYER ----------------------------------------------
					IF flag_mob_35 = 0
					AND flag_phil_mission2_passed = 1
						//RING_PLAYER_PHONE TRUE
						GOSUB mobile_rings
						IF flag_player_answered_phone = 1	
							audio_slot_mobile = 1
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_35a
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_35a ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_35b
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_35b ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_35c
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_35c ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_35d
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_35d ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							CLEAR_PRINTS
						ENDIF
						IF flag_player_answered_phone = 1	
							flag_mob_35 = 1
							//ADD_SPRITE_BLIP_FOR_CONTACT_POINT philX philY philZ the_phil_blip phils_contact_blip
							//START_NEW_SCRIPT phil_mission2_loop
						ENDIF
						mob_35_plonk:
						GOSUB mobile_message_cleanup
					ENDIF
					*/

					

					// PHIL THANKS PLAYER (VERSION)----------------------------------------------
					IF flag_mob_36 = 0
					AND flag_phil_mission2_passed = 1
						//RING_PLAYER_PHONE TRUE
						GOSUB mobile_rings
						IF flag_player_answered_phone = 1	
							audio_slot_mobile = 1
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_36a
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_36a ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_36b
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_36b ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_36c
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_36c ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							CLEAR_PRINTS
						ENDIF
						IF flag_player_answered_phone = 1	
							flag_mob_36 = 1
							//ADD_SPRITE_BLIP_FOR_CONTACT_POINT philX philY philZ the_phil_blip phils_contact_blip
							//START_NEW_SCRIPT phil_mission1_loop
						ENDIF
						mob_36_plonk:
						GOSUB mobile_message_cleanup
						GOTO cell_phone_inner
					ENDIF
					
					IF flag_mob_16 = 0
					AND flag_porn_mission4_passed = 1
						//RING_PLAYER_PHONE TRUE
						GOSUB mobile_rings
						IF flag_player_answered_phone = 1	
							audio_slot_mobile = 1
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_16a
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_16a ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_16b
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_16b ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_16c
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_16c ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_16d
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_16d ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_16e
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_16e ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished

							LOAD_MISSION_AUDIO audio_slot_mobile MOB_16f
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_16f ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							LOAD_MISSION_AUDIO audio_slot_mobile MOB_16g
							GOSUB loading_and_playing_audio
							PRINT_NOW ( MOB_16g ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished
							
							CLEAR_PRINTS
						ENDIF
						IF flag_player_answered_phone = 1	
							flag_mob_16 = 1
							//ADD_SPRITE_BLIP_FOR_CONTACT_POINT cubanX cubanY cubanZ the_cuban_blip cuban_contact_blip
							//START_NEW_SCRIPT cuban_mission1_loop
						ENDIF
						mob_16_plonk:
						GOSUB mobile_message_cleanup
						GOTO cell_phone_inner
					ENDIF
					
					// oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    
					//     oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    
					// ----------------------------------------- SONNY/LANCE HASSLES PLAYER ---------------------------------------
					// oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    
					//     oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    

					IF flag_finale_mission2_passed = 1
						flag_sonny_lance_dead = 1
					ENDIF
					IF flag_sonny_lance_dead = 0
					// LANCE HASSLES PLAYER (2) -----------------------------------------------------
						IF flag_mob_46 = 0
						AND flag_baron_mission4_passed = 1
							IF NOT IS_PLAYER_IN_ZONE player1 STARI
								//RING_PLAYER_PHONE TRUE
								
								GOSUB mobile_rings
								IF flag_player_answered_phone = 1	
									audio_slot_mobile = 1
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_46a
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB46_a ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_46b
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB46_b ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_46c
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB46_c ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished

									LOAD_MISSION_AUDIO audio_slot_mobile MOB_46d
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB46_d ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_46e
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB46_e ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished

									LOAD_MISSION_AUDIO audio_slot_mobile MOB_46f
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB46_f ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_46g
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB46_g ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished

									LOAD_MISSION_AUDIO audio_slot_mobile MOB_46h
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB46_h ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									CLEAR_PRINTS
								ENDIF
								IF flag_player_answered_phone = 1	
									flag_mob_46 = 1
									//ADD_SPRITE_BLIP_FOR_CONTACT_POINT cubanX cubanY cubanZ the_cuban_blip cuban_contact_blip
									//START_NEW_SCRIPT cuban_mission1_loop
								ENDIF
								mob_46_plonk:
								GOSUB mobile_message_cleanup
								GOTO cell_phone_inner
							ENDIF
						ENDIF
					
					// ********* SONNY WANTING MONEY (1) *************************************************************
						IF flag_mob_40 = 0
						AND flag_lawyer_mission3_passed = 1
							//RING_PLAYER_PHONE TRUE
							GOSUB mobile_rings
							IF flag_player_answered_phone = 1	
								audio_slot_mobile = 1
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_40a
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_40a ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_40b
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_40b ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_40c
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_40c ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_40d
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_40d ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_40e
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_40e ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_40f
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_40f ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_40g
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_40g ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_40h
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_40h ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_40i
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_40i ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								CLEAR_PRINTS
							ENDIF
							IF flag_player_answered_phone = 1	
								flag_mob_40 = 1
								//ADD_SPRITE_BLIP_FOR_CONTACT_POINT cubanX cubanY cubanZ the_cuban_blip cuban_contact_blip
								//START_NEW_SCRIPT cuban_mission1_loop
							ENDIF
							mob_40_plonk:
							GOSUB mobile_message_cleanup
							GOTO cell_phone_inner
						ENDIF
						
						

						// SONNY HASSLES PLAYER FOR HIS MONEY (2) -----------------------------------------------------
						IF flag_mob_41 = 0
						AND flag_mob_40 = 1
							IF flag_baron_mission5_passed = 1
							//OR flag_porn_mission1_passed = 1
								//RING_PLAYER_PHONE TRUE
								GOSUB mobile_rings
								IF flag_player_answered_phone = 1	
									audio_slot_mobile = 1
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_41a
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_41a ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_41b
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_41b ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_41c
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_41c ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished

									LOAD_MISSION_AUDIO audio_slot_mobile MOB_41d
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_41d ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_41e
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_41e ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished

									LOAD_MISSION_AUDIO audio_slot_mobile MOB_41f
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_41f ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished

									LOAD_MISSION_AUDIO audio_slot_mobile MOB_41g
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_41g ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished

									LOAD_MISSION_AUDIO audio_slot_mobile MOB_41h
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_41h ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									CLEAR_PRINTS
								ENDIF
								IF flag_player_answered_phone = 1	
									flag_mob_41 = 1
									//ADD_SPRITE_BLIP_FOR_CONTACT_POINT cubanX cubanY cubanZ the_cuban_blip cuban_contact_blip
									//START_NEW_SCRIPT cuban_mission1_loop
								ENDIF
								mob_41_plonk:
								GOSUB mobile_message_cleanup
								GOTO cell_phone_inner
							ENDIF
						ENDIF
						
						

						// SONNY HASSLES PLAYER FOR HIS MONEY (3) -----------------------------------------------------
						IF flag_mob_42 = 0
						AND flag_mob_41 = 1
							IF flag_counter_mission1_passed = 1
							OR flag_porn_mission1_passed = 1
								//RING_PLAYER_PHONE TRUE
								GOSUB mobile_rings
								IF flag_player_answered_phone = 1	
									audio_slot_mobile = 1
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_42a
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_42a ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_42b
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_42b ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_42c
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_42c ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished

									LOAD_MISSION_AUDIO audio_slot_mobile MOB_42d
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_42d ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_42e
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_42e ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									CLEAR_PRINTS
								ENDIF
								IF flag_player_answered_phone = 1	
									flag_mob_42 = 1
									//ADD_SPRITE_BLIP_FOR_CONTACT_POINT cubanX cubanY cubanZ the_cuban_blip cuban_contact_blip
									//START_NEW_SCRIPT cuban_mission1_loop
								ENDIF
								mob_42_plonk:
								GOSUB mobile_message_cleanup
								GOTO cell_phone_inner
							ENDIF
						ENDIF

						

						// LAWYER: SONNY HAS BEEN THREATWENING HIM (4) -----------------------------------------------------
						IF flag_mob_43 = 0
						AND flag_mob_42 = 1
							IF flag_bankjob_mission4_passed = 1
							AND flag_counter_mission2_passed = 1
								//RING_PLAYER_PHONE TRUE
								GOSUB mobile_rings
								IF flag_player_answered_phone = 1	
									audio_slot_mobile = 1
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_43a
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_43a ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_43b
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_43b ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_43c
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_43c ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished

									LOAD_MISSION_AUDIO audio_slot_mobile MOB_43d
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_43d ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_43e
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_43e ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_43f
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_43f ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_43g
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_43g ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_43h
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_43h ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									CLEAR_PRINTS
								ENDIF
								IF flag_player_answered_phone = 1	
									flag_mob_43 = 1
									//ADD_SPRITE_BLIP_FOR_CONTACT_POINT cubanX cubanY cubanZ the_cuban_blip cuban_contact_blip
									//START_NEW_SCRIPT cuban_mission1_loop
								ENDIF
								mob_43_plonk:
								GOSUB mobile_message_cleanup
								GOTO cell_phone_inner
							ENDIF
						ENDIF

					// oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    
					//     oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    
					// --------------------------------- LANCE HASSLES PLAYER 1 & 2 -----------------------------------------------
					//     oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    
					// oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    
						
				
						IF flag_mob_45 = 0
						AND flag_protect_mission2_passed = 1
							//RING_PLAYER_PHONE TRUE
							GOSUB mobile_rings
							IF flag_player_answered_phone = 1	
								audio_slot_mobile = 1
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_45a
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB45_a ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_45b
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB45_b ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_45c
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB45_c ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_45d
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB45_d ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_45e
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB45_e ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_45f
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB45_f ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_45g
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB45_g ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_45h
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB45_h ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_45i
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB45_i ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_45j
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB45_j ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_45k
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB45_k ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_45l
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB45_l ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_45m
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB45_m ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_45n
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB45_n ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								CLEAR_PRINTS
							ENDIF
							IF flag_player_answered_phone = 1	
								flag_mob_45 = 1
								//ADD_SPRITE_BLIP_FOR_CONTACT_POINT cubanX cubanY cubanZ the_cuban_blip cuban_contact_blip
								//START_NEW_SCRIPT cuban_mission1_loop
							ENDIF
							mob_45_plonk:
							GOSUB mobile_message_cleanup
							GOTO cell_phone_inner
						ENDIF

				
						IF flag_mob_72 = 0
						AND flag_protect_mission3_passed = 1
							//RING_PLAYER_PHONE TRUE
							GOSUB mobile_rings
							IF flag_player_answered_phone = 1	
								audio_slot_mobile = 1
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_72a
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_72a ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_72b
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_72b ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_72c
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_72c ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_72d
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_72d ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_72e
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_72e ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished

								LOAD_MISSION_AUDIO audio_slot_mobile MOB_72f
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_72f ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_72g
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_72g ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								CLEAR_PRINTS
							ENDIF
							IF flag_player_answered_phone = 1	
								flag_mob_72 = 1
								//ADD_SPRITE_BLIP_FOR_CONTACT_POINT cubanX cubanY cubanZ the_cuban_blip cuban_contact_blip
								//START_NEW_SCRIPT cuban_mission1_loop
							ENDIF
							mob_72_plonk:
							GOSUB mobile_message_cleanup
							GOTO cell_phone_inner
						ENDIF

					
						// LANCE HASSLES PLAYER (3) -----------------------------------------------------
						IF flag_mob_47 = 0
						AND flag_finale_mission1_passed = 1
							//RING_PLAYER_PHONE TRUE
							GOSUB mobile_rings
							IF flag_player_answered_phone = 1	
								audio_slot_mobile = 1
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_47a
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_47a ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								CLEAR_PRINTS
							ENDIF
							IF flag_player_answered_phone = 1	
								flag_mob_47 = 1
								REMOVE_BLIP protect_contact_blip
								ADD_SPRITE_BLIP_FOR_CONTACT_POINT -378.3 -579.8 24.5 the_protection_blip protect_contact_blip
								START_NEW_SCRIPT finale_mission2_loop
							ENDIF
							mob_47_plonk:
							GOSUB mobile_message_cleanup
							GOTO cell_phone_inner
						ENDIF

					ELSE
					
						IF flag_mob_63 = 0
						AND IS_PLAYER_PLAYING player1
							IF IS_PLAYER_IN_ZONE player1 HAVANA
								//RING_PLAYER_PHONE TRUE
								GOSUB mobile_rings
								IF flag_player_answered_phone = 1	
									audio_slot_mobile = 1
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_63a
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_63a ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_63b
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_63b ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_63c
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_63c ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished

									LOAD_MISSION_AUDIO audio_slot_mobile MOB_63d
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_63d ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_63e
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_63e ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished

									LOAD_MISSION_AUDIO audio_slot_mobile MOB_63f
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_63f ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_63g
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_63g ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished

									LOAD_MISSION_AUDIO audio_slot_mobile MOB_63h
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_63h ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_63i
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_63i ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished

									LOAD_MISSION_AUDIO audio_slot_mobile MOB_63j
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_63j ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									CLEAR_PRINTS
								ENDIF
								IF flag_player_answered_phone = 1	
									flag_mob_63 = 1
									//call_delay = 60000 // SCFIX: remove this
									//ADD_SPRITE_BLIP_FOR_CONTACT_POINT cubanX cubanY cubanZ the_cuban_blip cuban_contact_blip
									//START_NEW_SCRIPT cuban_mission1_loop
								ENDIF
								mob_63_plonk:
								GOSUB mobile_message_cleanup
								GOTO cell_phone_inner
							ENDIF
						ENDIF

						IF flag_mob_17 = 0
						AND IS_PLAYER_PLAYING player1
							IF IS_PLAYER_IN_ZONE player1 STARI
								//RING_PLAYER_PHONE TRUE
								GOSUB mobile_rings
								IF flag_player_answered_phone = 1	
									audio_slot_mobile = 1
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_17a
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_17a ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_17b
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_17b ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_17c
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_17c ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished

									LOAD_MISSION_AUDIO audio_slot_mobile MOB_17d
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_17d ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_17e
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_17f ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									/*
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_17f
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_17f ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									*/
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_17g
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_17g ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished

									LOAD_MISSION_AUDIO audio_slot_mobile MOB_17h
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_17h ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_17i
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_17i ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished

									LOAD_MISSION_AUDIO audio_slot_mobile MOB_17j
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_17j ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_17k
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_17k ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished

									LOAD_MISSION_AUDIO audio_slot_mobile MOB_17l
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_17l ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									CLEAR_PRINTS
								ENDIF
								IF flag_player_answered_phone = 1	
									flag_mob_17 = 1
									//ADD_SPRITE_BLIP_FOR_CONTACT_POINT cubanX cubanY cubanZ the_cuban_blip cuban_contact_blip
									//START_NEW_SCRIPT cuban_mission1_loop
								ENDIF
								mob_17_plonk:
								GOSUB mobile_message_cleanup
								GOTO cell_phone_inner
							ENDIF
						ENDIF
					
						IF flag_mob_73 = 0
						AND IS_PLAYER_PLAYING player1
						AND flag_porn_mission4_passed = 1 // SCFIX: fix Steve calling even if you don't own the film studio
							IF IS_PLAYER_IN_ZONE player1 PORNI
								//RING_PLAYER_PHONE TRUE
								GOSUB mobile_rings
								IF flag_player_answered_phone = 1	
									audio_slot_mobile = 1
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_73a
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_73a ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_73c
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_73c ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished

									LOAD_MISSION_AUDIO audio_slot_mobile MOB_73d
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_73d ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_73f
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_73f ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									LOAD_MISSION_AUDIO audio_slot_mobile MOB_73g
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_73g ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished

									LOAD_MISSION_AUDIO audio_slot_mobile MOB_73i
									GOSUB loading_and_playing_audio
									PRINT_NOW ( MOB_73i ) 10000 1//rhubarb rhubarb
									GOSUB has_audio_finished
									
									CLEAR_PRINTS
								ENDIF
								IF flag_player_answered_phone = 1	
									flag_mob_73 = 1
									//ADD_SPRITE_BLIP_FOR_CONTACT_POINT cubanX cubanY cubanZ the_cuban_blip cuban_contact_blip
									//START_NEW_SCRIPT cuban_mission1_loop
								ENDIF
								mob_73_plonk:
								GOSUB mobile_message_cleanup
								GOTO cell_phone_inner
							ENDIF
						ENDIF
					ENDIF
					
					// oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    
					//     oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    
					// oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    
					//     oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    
					// oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    
					

					// ASSASSIN MISSIONS ------- ASSASSIN MISSIONS ------- ASSASSIN MISSIONS ------- ASSASSIN MISSIONS -------
					// ------- ASSASSIN MISSIONS ------- ASSASSIN MISSIONS ------- ASSASSIN MISSIONS ------- ASSASSIN MISSIONS -------
					// ASSASSIN MISSIONS ------- ASSASSIN MISSIONS ------- ASSASSIN MISSIONS ------- ASSASSIN MISSIONS -------
					// ------- ASSASSIN MISSIONS ------- ASSASSIN MISSIONS ------- ASSASSIN MISSIONS ------- ASSASSIN MISSIONS -------
					// ASSASSIN MISSIONS ------- ASSASSIN MISSIONS ------- ASSASSIN MISSIONS ------- ASSASSIN MISSIONS -------
					// ------- ASSASSIN MISSIONS ------- ASSASSIN MISSIONS ------- ASSASSIN MISSIONS ------- ASSASSIN MISSIONS -------
					
					IF flag_lawyer_mission3_passed = 1
					AND flag_mob_99 = 0
							//RING_PLAYER_PHONE TRUE
							GOSUB mobile_rings
							IF flag_player_answered_phone = 1	
								audio_slot_mobile = 1
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_99a
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_99a ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								CLEAR_PRINTS
							ENDIF
							IF flag_player_answered_phone = 1	
								flag_mob_99 = 1
								REMOVE_BLIP assasin_contact_blip 
								ADD_SPRITE_BLIP_FOR_CONTACT_POINT ass_1_x ass_1_Y ass_1_Z the_assasin_blip assasin_contact_blip
								START_NEW_SCRIPT assin_mission1_loop
							ENDIF
							mob_99_plonk:
							GOSUB mobile_message_cleanup
							GOTO cell_phone_inner
					ENDIF
					
					
					
					IF flag_general_mission2_passed = 1
					AND flag_assin_mission1_passed = 1
					AND flag_mob_99 = 1
					AND flag_mob_98 = 0
							//RING_PLAYER_PHONE TRUE
							GOSUB mobile_rings
							IF flag_player_answered_phone = 1	
								audio_slot_mobile = 1
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_98a
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_98a ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								CLEAR_PRINTS
							ENDIF
							IF flag_player_answered_phone = 1	
								flag_mob_98 = 1
								REMOVE_BLIP assasin_contact_blip 
								ADD_SPRITE_BLIP_FOR_CONTACT_POINT ass_2_x ass_2_Y ass_2_Z the_assasin_blip assasin_contact_blip
								START_NEW_SCRIPT assin_mission2_loop
							ENDIF
							mob_98_plonk:
							GOSUB mobile_message_cleanup
							GOTO cell_phone_inner
					ENDIF


					IF flag_baron_mission3_passed = 1
					AND flag_assin_mission2_passed = 1
					AND flag_mob_98 = 1
					AND flag_mob_97 = 0
							//RING_PLAYER_PHONE TRUE
							GOSUB mobile_rings
							IF flag_player_answered_phone = 1	
								audio_slot_mobile = 1
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_99a
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_99a ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								CLEAR_PRINTS
							ENDIF
							IF flag_player_answered_phone = 1	
								flag_mob_97 = 1
								REMOVE_BLIP assasin_contact_blip 
								ADD_SPRITE_BLIP_FOR_CONTACT_POINT ass_3_x ass_3_Y ass_3_Z the_assasin_blip assasin_contact_blip
								START_NEW_SCRIPT assin_mission3_loop
							ENDIF
							mob_97_plonk:
							GOSUB mobile_message_cleanup
							GOTO cell_phone_inner
					ENDIF


					IF flag_protect_mission1_passed = 1
					AND flag_assin_mission3_passed = 1
					AND flag_mob_97 = 1
					AND flag_mob_96 = 0
							//RING_PLAYER_PHONE TRUE
							GOSUB mobile_rings
							IF flag_player_answered_phone = 1	
								audio_slot_mobile = 1
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_96a
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_96a ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								CLEAR_PRINTS
							ENDIF
							IF flag_player_answered_phone = 1	
								flag_mob_96 = 1
								REMOVE_BLIP assasin_contact_blip 
								ADD_SPRITE_BLIP_FOR_CONTACT_POINT ass_4_x ass_4_Y ass_4_Z the_assasin_blip assasin_contact_blip
								START_NEW_SCRIPT assin_mission4_loop
							ENDIF
							mob_96_plonk:
							GOSUB mobile_message_cleanup
							GOTO cell_phone_inner
					ENDIF


					IF flag_bankjob_mission2_passed = 1
					AND flag_assin_mission4_passed = 1
					AND flag_mob_96 = 1
					AND flag_mob_95 = 0
							//RING_PLAYER_PHONE TRUE
							GOSUB mobile_rings
							IF flag_player_answered_phone = 1	
								audio_slot_mobile = 1
								LOAD_MISSION_AUDIO audio_slot_mobile MOB_95a
								GOSUB loading_and_playing_audio
								PRINT_NOW ( MOB_95a ) 10000 1//rhubarb rhubarb
								GOSUB has_audio_finished
								
								CLEAR_PRINTS
							ENDIF
							IF flag_player_answered_phone = 1	
								flag_mob_95 = 1
								REMOVE_BLIP assasin_contact_blip 
								ADD_SPRITE_BLIP_FOR_CONTACT_POINT ass_5_x ass_5_Y ass_5_Z the_assasin_blip assasin_contact_blip
								START_NEW_SCRIPT assin_mission5_loop
							ENDIF
							mob_95_plonk:
							GOSUB mobile_message_cleanup
							GOTO cell_phone_inner
					ENDIF

					/*	
					
						
					// RANDOM CALLS TO LEO'S PHONE ------------------------------------------------------------------
				
					GENERATE_RANDOM_INT_IN_RANGE MinInt MaxInt random_cell
					IF random_cell = 1
					AND flag_mob_50 = 0
						GOSUB mobile_timer
						IF timer_mobile_diff > 60000
							//RING_PLAYER_PHONE TRUE
							GET_GAME_TIMER timer_mobile_start
							GOSUB mobile_ringing
							IF flag_player_answered_phone = 2
								GOTO mob_01_plonk
							ENDIF
							GOSUB answer_mobile
							//flag_timer_started = 0
							GOSUB start_mobile_message
							LOAD_MISSION_AUDIO YD2_A
							//LOAD_MISSION_AUDIO MOB_01
							GOSUB loading_and_playing_audio
							PRINT_NOW ( RHUBARB ) 10000 1//rhubarb rhubarb
							GOSUB playing_conversation
							flag_mob_01 = 1
							mob_01_plonk:
							GOSUB mobile_message_cleanup
						ENDIF
					ENDIF
					*/
				ENDIF
			ENDIF
		ELSE
			flag_cell_nation = 0
		ENDIF
	ENDIF

GOTO cell_phone_inner






mobile_timer: // calculates time increment
	GET_GAME_TIMER timer_mobile_now
	timer_mobile_diff = timer_mobile_now - timer_mobile_start
RETURN



mobile_rings:
	audio_slot_mobile = 1
	ring_a_ding_ding = 0

	PRINT_HELP_FOREVER ( ANSWER )
	flag_player_on_mission = 1
	flag_cell_nation = 1
	WHILE ring_a_ding_ding < 7
	AND flag_player_answered_phone < 2

		WAIT 0
		LOAD_MISSION_AUDIO audio_slot_mobile MOBRING
		players_skipping_the_call = 0 // SCFIX
		GOSUB loading_and_playing_audio
		++ ring_a_ding_ding

		IF flag_player_answered_phone = 1
		AND ring_a_ding_ding > 0
			GOTO imploding_head
		ENDIF
		
		GOSUB has_audio_finished

		IF flag_player_answered_phone = 1
		AND ring_a_ding_ding > 0
			GOTO imploding_head
		ENDIF
		
		mobile_pause = 0
		WHILE mobile_pause < 40
			WAIT 0

			GOSUB death_checker
			IF flag_player_answered_phone = 1
				GOTO imploding_head
			ENDIF
			++ mobile_pause
		ENDWHILE
	ENDWHILE
	GET_GAME_TIMER timer_mobile_start
	RETURN
	imploding_head:

//	IF IS_PLAYER_PLAYING player1
//		SET_PLAYER_CONTROL player1 OFF
//	ENDIF
	players_skipping_the_call = 1 // SCFIX
	GET_GAME_TIMER timer_mobile_start
	WHILE IS_BUTTON_PRESSED PAD1 LEFTSHOULDER1
		WAIT 0
		IF NOT IS_PLAYER_PLAYING player1
			flag_player_answered_phone = 2
			RETURN
		ENDIF
	ENDWHILE
	CLEAR_HELP
	CLEAR_MISSION_AUDIO audio_slot_mobile
	IF IS_PLAYER_PLAYING player1
		//SET_PLAYER_CONTROL player1 OFF
		SET_EVERYONE_IGNORE_PLAYER player1 ON
		SHUT_PLAYER_UP player1 TRUE
		REQUEST_MODEL cellphone
		WHILE NOT HAS_MODEL_LOADED cellphone
			WAIT 0
        ENDWHILE

		GOSUB death_checker

		IF flag_player_answered_phone = 2
            MARK_MODEL_AS_NO_LONGER_NEEDED cellphone
            RETURN
		ENDIF

		SET_CHAR_ANSWERING_MOBILE scplayer TRUE
		SET_CURRENT_CHAR_WEAPON scplayer WEAPONTYPE_UNARMED // SCFIX
		STOP_PLAYER_LOOKING player1 // SCFIX
//		IF IS_PLAYER_PLAYING player1
//			SET_PLAYER_CONTROL player1 ON
//		ENDIF
		timera = 0
		WHILE timera < 1000
			WAIT 0
			IF NOT IS_PLAYER_PLAYING player1
				flag_player_answered_phone = 2
				RETURN
			ENDIF
		ENDWHILE
		//GET_PLAYER_CHAR player1 scplayer
		//SET_CHAR_WAIT_STATE scplayer WAITSTATE_TRAFFIC_LIGHTS 10000
	ENDIF
RETURN




loading_and_playing_audio:
	// SCFIX: START - call skip
	IF players_skipping_the_call = 2
		RETURN
	ENDIF
	// SCFIX: END
	WHILE NOT HAS_MISSION_AUDIO_LOADED audio_slot_mobile
		WAIT 0

		IF NOT IS_PLAYER_PLAYING player1
			flag_player_answered_phone = 2
			RETURN
		ELSE
			//GOSUB pickup_checker
			IF IS_CHAR_DROWNING_IN_WATER scplayer
			OR NOT IS_CHAR_ON_FOOT scplayer
			//OR flag_player_on_mission = 1
				flag_player_answered_phone = 2
				RETURN
			ENDIF
			IF flag_player_answered_phone = 0
			AND ring_a_ding_ding > 0
				IF IS_BUTTON_PRESSED PAD1 LEFTSHOULDER1
				AND CAN_PLAYER_START_MISSION player1
					flag_player_answered_phone = 1
					RETURN
				ENDIF
			ENDIF
		
			// SCFIX: START - call skip
			IF players_skipping_the_call = 1
				IF IS_BUTTON_PRESSED PAD1 TRIANGLE
					players_skipping_the_call = 2
					RETURN	
				ENDIF
			ENDIF
			// SCFIX: END
		ENDIF
	ENDWHILE
	PLAY_MISSION_AUDIO audio_slot_mobile
RETURN



has_audio_finished:
	// SCFIX: START - call skip
	IF players_skipping_the_call = 2
		CLEAR_PRINTS
		RETURN
	ENDIF
	// SCFIX: END
	WHILE NOT HAS_MISSION_AUDIO_FINISHED audio_slot_mobile
		WAIT 0

		IF NOT IS_PLAYER_PLAYING player1
			flag_player_answered_phone = 2
			CLEAR_PRINTS // SCFIX
			RETURN
		ELSE
			//GOSUB pickup_checker
			IF IS_CHAR_DROWNING_IN_WATER scplayer
			OR NOT IS_CHAR_ON_FOOT scplayer
			//OR flag_player_on_mission = 1
				flag_player_answered_phone = 2
				CLEAR_PRINTS // SCFIX
				RETURN
			ENDIF
			IF flag_player_answered_phone = 0
			AND ring_a_ding_ding > 0
				IF IS_BUTTON_PRESSED PAD1 LEFTSHOULDER1
				AND CAN_PLAYER_START_MISSION player1
					flag_player_answered_phone = 1
					RETURN
				ENDIF
			ENDIF
		ENDIF
		
		// SCFIX: START - call skip
		IF players_skipping_the_call = 1
			IF IS_BUTTON_PRESSED PAD1 TRIANGLE
				players_skipping_the_call = 2
				CLEAR_PRINTS
				RETURN	
			ENDIF
		ENDIF
		// SCFIX: END
	ENDWHILE
RETURN



death_checker:
	IF NOT IS_PLAYER_PLAYING player1
		flag_player_answered_phone = 2
		RETURN
	ELSE
		//GOSUB pickup_checker
		IF IS_CHAR_DROWNING_IN_WATER scplayer
		OR NOT IS_CHAR_ON_FOOT scplayer
		//OR flag_player_on_mission = 1
			flag_player_answered_phone = 2
			RETURN
		ENDIF
		IF flag_player_answered_phone = 0
		AND ring_a_ding_ding > 0
			IF IS_BUTTON_PRESSED PAD1 LEFTSHOULDER1
			AND CAN_PLAYER_START_MISSION player1
				flag_player_answered_phone = 1
				RETURN
			ENDIF
		ENDIF
		
		// SCFIX: START - call skip
		IF players_skipping_the_call = 1
			IF IS_BUTTON_PRESSED PAD1 TRIANGLE
				players_skipping_the_call = 2
				RETURN	
			ENDIF
		ENDIF
		// SCFIX: END
	ENDIF
RETURN





mobile_message_cleanup:
	flag_cell_nation = 0
	//RING_PLAYER_PHONE FALSE
	CLEAR_MISSION_AUDIO 1
	CLEAR_MISSION_AUDIO 2
	flag_player_answered_phone = 0
	//flag_mobile_dialogue = 0
	flag_mobile_timer = 0
	IF IS_PLAYER_PLAYING player1
		SET_CHAR_ANSWERING_MOBILE scplayer FALSE
		SET_PLAYER_CONTROL player1 ON
		SET_EVERYONE_IGNORE_PLAYER player1 OFF
		//SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 0
		SHUT_PLAYER_UP player1 FALSE
	ENDIF
	GET_GAME_TIMER timer_mobile_start
	timer_mobile_diff = 0
	GOSUB mobile_timer
	CLEAR_PRINTS
	IF flag_new_cont = 0
		CLEAR_HELP
	ELSE
		flag_new_cont = 0
	ENDIF
	MARK_MODEL_AS_NO_LONGER_NEEDED cellphone
	flag_player_on_mission = 0

RETURN
}

/*
{
pickup_checker:

	IF LOCATE_PLAYER_ON_FOOT_3D player1 printbuyX printbuyY printbuyZ 4.0 4.0 4.0 FALSE
		flag_player_answered_phone = 2
	ENDIF
	
	IF LOCATE_PLAYER_ON_FOOT_3D player1 carbuyX carbuyY carbuyZ 4.0 4.0 4.0 FALSE
		flag_player_answered_phone = 2
	ENDIF
	
	IF LOCATE_PLAYER_ON_FOOT_3D player1 pornbuyX pornbuyY pornbuyZ 4.0 4.0 4.0 FALSE
		flag_player_answered_phone = 2
	ENDIF
	
	IF LOCATE_PLAYER_ON_FOOT_3D player1 icebuyX icebuyY icebuyZ 4.0 4.0 4.0 FALSE
		flag_player_answered_phone = 2
	ENDIF
	
	IF LOCATE_PLAYER_ON_FOOT_3D player1 taxibuyX taxibuyY taxibuyZ 4.0 4.0 4.0 FALSE
		flag_player_answered_phone = 2
	ENDIF
	
	IF LOCATE_PLAYER_ON_FOOT_3D player1 bankbuyX bankbuyY bankbuyZ 4.0 4.0 4.0 FALSE
		flag_player_answered_phone = 2
	ENDIF
	
	IF LOCATE_PLAYER_ON_FOOT_3D player1 boatbuyX boatbuyY boatbuyZ 4.0 4.0 4.0 FALSE
		flag_player_answered_phone = 2
	ENDIF

RETURN
}
*/
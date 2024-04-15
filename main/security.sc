MISSION_START

//VAR_INT	camera_golf camera_aport1 camera_aport2 
VAR_INT security_bloke1 security_bloke2 //security_bloke3 security_bloke4 
//VAR_INT golf_colt45 golf_uzi 
//VAR_INT	golf_grenade  golf_sniper golf_ak47 golf_flame golf_molotov

VAR_INT flag_goons_created //flag_aiport_goons_created flag_airport2_goons_created
VAR_INT flag_player_been_frisked flag_1_tooled flag_2_tooled
VAR_INT flag_zone flag_gate
VAR_INT outer_switch_quickstep counter_quickstep

VAR_INT weapon_model_slot_1 weapon_model_slot_2 weapon_model_slot_3 weapon_model_slot_4
VAR_INT weapon_model_slot_5 weapon_model_slot_6 weapon_model_slot_7 weapon_model_slot_8
VAR_INT weapon_model_slot_9

VAR_INT bollox_1 bollox_2 bollox_3 
//VAR_INT bollox_5 bollox_6 bollox_7 bollox_8
//VAR_INT bollox_9 bollox_4

VAR_INT flag_golf_course_nodes

//VAR_INT check_1 check_2 check_3 check_4
//VAR_INT check_5 check_6 check_7 check_8

VAR_INT ammo_slot_1 ammo_slot_2 ammo_slot_3 ammo_slot_4   
VAR_INT ammo_slot_5 ammo_slot_6 ammo_slot_7 ammo_slot_8   
VAR_INT ammo_slot_9   

VAR_INT	slot1_pickup_security slot2_pickup_security slot3_pickup_security slot4_pickup_security
VAR_INT	slot5_pickup_security slot6_pickup_security slot7_pickup_security slot8_pickup_security
VAR_INT	slot9_pickup_security 
/*
VAR_INT	flag_slot1_pickup flag_slot2_pickup flag_slot3_pickup flag_slot4_pickup
VAR_INT	flag_slot5_pickup flag_slot6_pickup flag_slot7_pickup flag_slot8_pickup
*/
//VAR_INT blippage_de_test blippage_de_test2

VAR_FLOAT metal_detector_x metal_detector_y metal_detector_z
//VAR_FLOAT metal_detector2_x metal_detector2_y metal_detector2_z

VAR_FLOAT gate_security_1_x gate_security_1_y gate_security_1_z
VAR_FLOAT gate_security_2_x gate_security_2_y gate_security_2_z
//VAR_FLOAT gate_security_3_x gate_security_3_y gate_security_3_z
//VAR_FLOAT gate_security_4_x gate_security_4_y gate_security_4_z

VAR_INT flag_cam_switch	flag_security_model_loaded flag_player_on_bike
VAR_INT var_rampage_check

VAR_FLOAT security_cam_1_x security_cam_1_y security_cam_1_z
VAR_FLOAT security_cam_2_x security_cam_2_y security_cam_2_z
VAR_FLOAT security_cam_x_subject security_cam_y_subject security_cam_z_subject
VAR_FLOAT pickup_x pickup_y pickup_z
VAR_FLOAT player_heading

VAR_FLOAT zob_x zob_y zob_z

VAR_FLOAT cent_x cent_y theta_security theta_mod

VAR_INT sec_counter

VAR_INT security_disturbed // SCFIX
VAR_INT hack_play_on_a_mission // SCFIX
security_disturbed = 0 // SCFIX
hack_play_on_a_mission = 0 // SCFIX

flag_player_been_frisked = 0
flag_zone = 0
flag_gate = 0
flag_goons_created = 0
flag_cam_switch = 0
flag_1_tooled = 0
flag_2_tooled = 0
flag_security_model_loaded = 0
flag_player_on_bike = 0

flag_golf_course_nodes = 0

outer_switch_quickstep = 0

theta_security = 0.0
cent_x = -1436.0
cent_y = -805.0

sec_counter = 0

SCRIPT_NAME	SECURE

SET_DEATHARREST_STATE OFF //stops script being terminated if Player arrested


mission_start_security:

{
	START_NEW_SCRIPT security
	//START_NEW_SCRIPT airport_security
	//START_NEW_SCRIPT aport2_security
	START_NEW_SCRIPT play_golf_security_audio // SCFIX

	MISSION_END
}


/*  
SWITCH_ROADS_OFF 84.0 286.0 0.0 88.0 290.0 30.0 
SWITCH_ROADS_OFF 92.0 301.0 0.0 96.0 305.0 30.0 
SWITCH_ROADS_OFF 76.0 312.0 0.0 80.0 316.0 30.0 
SWITCH_ROADS_OFF 144.0 458.0 0.0 148.0 502.0 30.0 
SWITCH_ROADS_OFF 109.0 483.0 0.0 113.0 487.0 30.0 
SWITCH_ROADS_OFF 96.0 492.0 0.0 100.0 496.0 30.0 
SWITCH_ROADS_OFF -96.0 557.0 0.0 -100.0 561.0 30.0 
SWITCH_ROADS_OFF -121.0 571.0 0.0 -117.0 575.0 30.0 
SWITCH_ROADS_OFF -176.0 481.0 0.0 -172.0 485.0 30.0 
SWITCH_ROADS_OFF 15.6 102.0 0.0 19.6 106.0 30.0 
SWITCH_ROADS_OFF 144.0 66.5 0.0 148.0 70.5 30.0 
*/
security:

{

SCRIPT_NAME SECURI

SWITCH_ROADS_OFF -291.0 -287.0 0.0 208.0 648.0 35.0
SWITCH_ROADS_OFF -291.0 -287.0 0.0 208.0 648.0 35.0
SWITCH_ROADS_OFF -283.0 372.0 0.0 -137.0 608.0 35.0

GOTO filopastry
CREATE_PICKUP_WITH_AMMO weapon_model_slot_3 PICKUP_ONCE ammo_slot_3 pickup_x pickup_y pickup_z slot1_pickup_security
CREATE_PICKUP_WITH_AMMO weapon_model_slot_3 PICKUP_ONCE ammo_slot_3 pickup_x pickup_y pickup_z slot2_pickup_security
CREATE_PICKUP_WITH_AMMO weapon_model_slot_3 PICKUP_ONCE ammo_slot_3 pickup_x pickup_y pickup_z slot3_pickup_security
CREATE_PICKUP_WITH_AMMO weapon_model_slot_3 PICKUP_ONCE ammo_slot_3 pickup_x pickup_y pickup_z slot4_pickup_security
CREATE_PICKUP_WITH_AMMO weapon_model_slot_3 PICKUP_ONCE ammo_slot_3 pickup_x pickup_y pickup_z slot5_pickup_security
CREATE_PICKUP_WITH_AMMO weapon_model_slot_3 PICKUP_ONCE ammo_slot_3 pickup_x pickup_y pickup_z slot6_pickup_security
CREATE_PICKUP_WITH_AMMO weapon_model_slot_3 PICKUP_ONCE ammo_slot_3 pickup_x pickup_y pickup_z slot7_pickup_security
CREATE_PICKUP_WITH_AMMO weapon_model_slot_3 PICKUP_ONCE ammo_slot_3 pickup_x pickup_y pickup_z slot8_pickup_security
CREATE_PICKUP_WITH_AMMO weapon_model_slot_3 PICKUP_ONCE ammo_slot_3 pickup_x pickup_y pickup_z slot9_pickup_security
CREATE_CHAR PEDTYPE_CIVMALE GDa gate_security_1_x gate_security_1_y gate_security_1_z security_bloke1
CREATE_CHAR PEDTYPE_CIVMALE GDa gate_security_1_x gate_security_1_y gate_security_1_z security_bloke2

filopastry:

security_inner:
	
	WAIT 0
	++ sec_counter
	IF IS_PLAYER_PLAYING player1
		/*
		IF IS_PLAYER_IN_AREA_3D player1	-306.0 292.0 0.0 203.0 614.0 30.0 FALSE
		ENDIF
		*/
		READ_KILL_FRENZY_STATUS var_rampage_check
		IF NOT var_rampage_check = 1 
			IF sec_counter = 1
				IF IS_PLAYER_IN_ZONE player1 GOLFC

						
					flag_zone = 1

					metal_detector_x = 95.0
					metal_detector_y = 267.7 
					metal_detector_z = 21.0
				
					security_cam_x_subject = metal_detector_x
					security_cam_y_subject = metal_detector_y
					security_cam_z_subject = metal_detector_z
								 
					pickup_x = metal_detector_x 
					pickup_y = metal_detector_y 
					pickup_z = metal_detector_z + 1.0
				
					security_cam_1_x = 99.0 
					security_cam_1_y = 257.0 
					security_cam_1_z = 24.4
					
					security_cam_2_x = 90.3 
					security_cam_2_y = 277.6 
					security_cam_2_z = 24.5
				
					gate_security_1_x = 91.1
					gate_security_1_y = 270.0
					gate_security_1_z = 21.8

					gate_security_2_x = 95.8
					gate_security_2_y = 271.5
					gate_security_2_z = 21.8

					//IF LOCATE_PLAYER_ANY_MEANS_3D player1 metal_detector_x metal_detector_y metal_detector_z 35.0 35.0 35.0 FALSE
					IF LOCATE_PLAYER_ANY_MEANS_3D player1 metal_detector_x metal_detector_y metal_detector_z 8.0 8.0 3.0 FALSE

						GET_PLAYER_COORDINATES player1 zob_x zob_y zob_z
						
						IF zob_y < metal_detector_y 
							IF flag_cam_switch = 0
								SET_FIXED_CAMERA_POSITION security_cam_1_x security_cam_1_y security_cam_1_z 0.0 0.0 0.0
								POINT_CAMERA_AT_POINT security_cam_x_subject security_cam_y_subject security_cam_z_subject JUMP_CUT
								SWITCH_SECURITY_CAMERA ON
								flag_cam_switch = 1
							ENDIF
						ENDIF
						IF zob_y > metal_detector_y 
							IF flag_cam_switch = 0
								SET_FIXED_CAMERA_POSITION security_cam_2_x security_cam_2_y security_cam_2_z 0.0 0.0 0.0
								POINT_CAMERA_AT_POINT security_cam_x_subject security_cam_y_subject security_cam_z_subject JUMP_CUT
								SWITCH_SECURITY_CAMERA ON
								flag_cam_switch = 2
							ENDIF
						ENDIF


						IF LOCATE_PLAYER_ANY_MEANS_3D player1 metal_detector_x metal_detector_y metal_detector_z 1.0 1.0 1.5 FALSE
							GOSUB get_ammo
							GOSUB security_pickups
							GOSUB is_player_on_bike
							// SCFIX: START
							LVAR_INT flag_has_any_firearm
							VAR_INT flag_playing_security_audio
							flag_has_any_firearm = 0
							flag_playing_security_audio = 0
							IF weapon_model_slot_3 > 0
							OR weapon_model_slot_4 > 0
							OR weapon_model_slot_5 > 0
							OR weapon_model_slot_6 > 0
							OR weapon_model_slot_7 > 0
								flag_has_any_firearm = 1
							ENDIF
							IF weapon_model_slot_8 > 0
							OR weapon_model_slot_9 > 0
								flag_has_any_firearm = 1
							ENDIF
							IF flag_has_any_firearm = 1
							AND flag_goons_created = 1
							AND security_disturbed = 0
							AND flag_cam_switch = 1
								IF NOT IS_CHAR_DEAD security_bloke1
								AND LOCATE_CHAR_ON_FOOT_3D security_bloke1 metal_detector_x metal_detector_y metal_detector_z 5.0 5.0 5.0 FALSE
									IF flag_player_on_mission = 0
									OR hack_play_on_a_mission = 1
										flag_playing_security_audio = 1
									ENDIF
								ELSE
									IF NOT IS_CHAR_DEAD security_bloke2
									AND LOCATE_CHAR_ON_FOOT_3D security_bloke2 metal_detector_x metal_detector_y metal_detector_z 5.0 5.0 5.0 FALSE
										IF flag_player_on_mission = 0
										OR hack_play_on_a_mission = 1
											flag_playing_security_audio = 1
										ENDIF
									ENDIF
								ENDIF
							ENDIF
							// SCFIX: END
						ENDIF
					ELSE
					
						IF NOT flag_cam_switch = 0
							GET_PLAYER_HEADING player1 player_heading
							IF flag_cam_switch = 1
								IF player_heading > 155.0
								AND player_heading < 245.0
									RESTORE_CAMERA_JUMPCUT
									SWITCH_SECURITY_CAMERA OFF
									SET_CAMERA_IN_FRONT_OF_PLAYER
								ELSE
									RESTORE_CAMERA_JUMPCUT
									SWITCH_SECURITY_CAMERA OFF
								ENDIF
							ENDIF
							IF flag_cam_switch = 2
								IF player_heading > 290.0
								OR player_heading < 110.0
									RESTORE_CAMERA_JUMPCUT
									SWITCH_SECURITY_CAMERA OFF
									SET_CAMERA_IN_FRONT_OF_PLAYER
								ELSE
									RESTORE_CAMERA_JUMPCUT
									SWITCH_SECURITY_CAMERA OFF
								ENDIF
							ENDIF
							flag_cam_switch = 0
						ENDIF
					ENDIF
					
					IF flag_goons_created = 1
						IF NOT IS_CHAR_DEAD	security_bloke1
							IF NOT IS_CHAR_HEALTH_GREATER security_bloke1 90
								GOSUB kill_them_all_1
								GOSUB kill_them_all_2
							ENDIF
						ELSE
							MARK_CHAR_AS_NO_LONGER_NEEDED security_bloke1
							GOSUB kill_them_all_2
						ENDIF
						IF NOT IS_CHAR_DEAD	security_bloke2
							IF NOT IS_CHAR_HEALTH_GREATER security_bloke2 90
								GOSUB kill_them_all_1
								GOSUB kill_them_all_2
							ENDIF
						ELSE
							MARK_CHAR_AS_NO_LONGER_NEEDED security_bloke2
							GOSUB kill_them_all_1
						ENDIF
						IF flag_player_on_bike = 1
							GOSUB kill_them_all_1
							GOSUB kill_them_all_2
						ENDIF	
					ENDIF
					
					IF flag_goons_created = 0
						ground_z = 0.0000
						flag_security_model_loaded = 0
						GET_GROUND_Z_FOR_3D_COORD gate_security_1_x gate_security_1_y 50.0 ground_z
						IF NOT ground_z	= 0.0000
							IF HAS_MODEL_LOADED GDa
								flag_security_model_loaded = 1
							ENDIF
							IF flag_security_model_loaded = 0
								REQUEST_MODEL GDa
								WHILE NOT HAS_MODEL_LOADED GDa
									WAIT 0
								ENDWHILE
							ENDIF
							security_disturbed = 0 // SCFIX
							CREATE_CHAR PEDTYPE_GANG_SECURITY GDa gate_security_1_x gate_security_1_y gate_security_1_z security_bloke1 // SCFIX: use PEDTYPE_GANG_SECURITY
							SET_CHAR_PERSONALITY security_bloke1 PEDSTAT_TOUGH_GUY
							SET_CHAR_HEADING security_bloke1 300.0
							CHAR_SET_IDLE security_bloke1 
							
							CREATE_CHAR PEDTYPE_GANG_SECURITY GDa gate_security_2_x gate_security_2_y gate_security_2_z security_bloke2 // SCFIX: use PEDTYPE_GANG_SECURITY
							SET_CHAR_PERSONALITY security_bloke2 PEDSTAT_TOUGH_GUY
							SET_CHAR_HEADING security_bloke2 130.0
							CHAR_SET_IDLE security_bloke2
							IF flag_security_model_loaded = 0
								MARK_MODEL_AS_NO_LONGER_NEEDED GDa
							ENDIF
							flag_security_model_loaded = 0
							flag_goons_created = 1
						ENDIF
					ENDIF 


			
					//GOSUB pickup_check

				ELSE
					IF flag_zone = 1
						IF flag_goons_created = 1
							IF NOT IS_CHAR_DEAD security_bloke1
								MARK_CHAR_AS_NO_LONGER_NEEDED security_bloke1
							ENDIF
							IF NOT IS_CHAR_DEAD security_bloke2
								MARK_CHAR_AS_NO_LONGER_NEEDED security_bloke2
							ENDIF
							flag_goons_created = 0
							flag_1_tooled = 0
							flag_2_tooled = 0
						ENDIF
					
						GOSUB security_zone_cleanup
						flag_zone = 0
					ENDIF

					//flag_player_been_frisked = 0
					outer_switch_quickstep = 0
				ENDIF
			ENDIF
		ENDIF
	ELSE
		GOSUB security_zone_cleanup
	ENDIF

	// ******************** AIRPORT ************************************************************************************
	
	IF IS_PLAYER_PLAYING player1
		READ_KILL_FRENZY_STATUS var_rampage_check
		IF NOT var_rampage_check = 1 
			IF sec_counter = 2
				IF IS_PLAYER_IN_ZONE player1 A_PORT
				

					flag_zone = 2
					
					// *********** GATE 1 ************************************************************************************
					metal_detector_x = -1464.1
					metal_detector_y = -830.6 
					metal_detector_z = 13.9

					pickup_z = metal_detector_z + 1.0
				
					IF LOCATE_PLAYER_ANY_MEANS_3D player1 metal_detector_x metal_detector_y metal_detector_z 1.0 1.0 1.5 FALSE
						IF flag_gate = 2
							outer_switch_quickstep = 0
						ENDIF
						flag_gate = 1
						GOSUB get_ammo
						GOSUB security_pickups
						GOSUB is_player_on_bike
					ENDIF
					//GOSUB pickup_check
					
					// *********** GATE 2 ************************************************************************************
					metal_detector_x = -1408.3
					metal_detector_y = -831.5 
					metal_detector_z = 13.9
				
					pickup_z = metal_detector_z + 1.0
					
					IF LOCATE_PLAYER_ANY_MEANS_3D player1 metal_detector_x metal_detector_y metal_detector_z 1.0 1.0 1.5 FALSE
						IF flag_gate = 1
							outer_switch_quickstep = 0
						ENDIF
						flag_gate = 2
						GOSUB get_ammo
						GOSUB security_pickups
						GOSUB is_player_on_bike
					ENDIF
					//GOSUB pickup_check
					IF flag_player_on_bike = 1
						SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_SECURITY THREAT_PLAYER1
					ENDIF
				ELSE

					IF flag_zone = 2
						GOSUB security_zone_cleanup
						CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_SECURITY THREAT_PLAYER1
						flag_player_on_bike = 0
						theta_security = 0.0
						flag_gate = 0
						flag_zone = 0
					ENDIF

					//flag_player_been_frisked = 0
					outer_switch_quickstep = 0
				ENDIF
			ENDIF
		ENDIF
	ELSE
		GOSUB security_zone_cleanup
	ENDIF
	
	// ************************* POLICE HQ WANTED LEVEL **********************************************
	
	IF IS_PLAYER_PLAYING player1
	AND flag_player_on_mission = 0
		IF IS_PLAYER_IN_ZONE player1 BEACH2
			IF flag_player_in_cop_shop = 1
				IF NOT IS_PLAYER_WEARING player1 player6
					IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 392.0 -478.5 12.4 6.0 6.0 5.0 FALSE
						ALTER_WANTED_LEVEL_NO_DROP player1 2
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF


	// ***************************** GOLF CARS *******************************************************

	IF IS_PLAYER_PLAYING player1
		IF IS_PLAYER_IN_INFO_ZONE player1 GOLF1
		OR IS_PLAYER_IN_INFO_ZONE player1 GOLF2
	
			IF flag_golf_course_nodes = 0
				// SCFIX: START - new more accurate roads
				SWITCH_ROADS_ON -291.0 454.88 0.0 289.51 632.06 35.0
				SWITCH_ROADS_ON 49.76 296.24 0.0 212.59 472.75 35.0
				SWITCH_ROADS_ON -35.27 239.98 0.0 173.06 296.31 35.0
				SWITCH_ROADS_ON -35.27 221.91 0.0 107.16 260.17 35.0
				SWITCH_ROADS_ON -40.81 152.92 0.0 -1.02 221.9 35.0
				SWITCH_ROADS_ON -41.29 138.68 0.0 -5.22 153.63 35.0
				SWITCH_ROADS_ON 2.4 45.65 0.0 193.04 118.35 35.0
				SWITCH_ROADS_ON 154.86 110.33 0.0 170.11 216.07 35.0
				SWITCH_ROADS_ON 93.85 112.87 0.0 158.93 187.09 35.0
				SWITCH_ROADS_ON 60.3 117.41 0.0 94.84 165.74 35.0
				SWITCH_ROADS_ON 31.83 117.18 0.0 61.28 138.8 35.0
				SWITCH_ROADS_ON -33.24 -172.84 0.0 187.9 75.76 35.0
				SWITCH_ROADS_ON -59.67 -148.44 0.0 -17.48 -48.79 35.0
				SWITCH_ROADS_ON -0.97 188.27 0.0 42.15 221.92 35.0

				// SCFIX: END

				/*SWITCH_ROADS_ON -291.0 -287.0 0.0 208.0 648.0 35.0
				SWITCH_ROADS_ON -291.0 -287.0 0.0 208.0 648.0 35.0
				SWITCH_ROADS_ON -283.0 372.0 0.0 -137.0 608.0 35.0
				
				IF flag_baron_mission2_passed = 0
					SWITCH_ROADS_OFF 189.8 230.3 0.0 248.0 258.5 30.0 //  Golf course road block
					SWITCH_ROADS_OFF -38.0 84.3 0.0 -102.3 95.1 30.0 //  Golf course road block
				ENDIF*/
				/*
				SWITCH_ROADS_ON 84.0 286.0 0.0 88.0 290.0 30.0 
				SWITCH_ROADS_ON 92.0 301.0 0.0 96.0 305.0 30.0 
				SWITCH_ROADS_ON 76.0 312.0 0.0 80.0 316.0 30.0 
				SWITCH_ROADS_ON 144.0 458.0 0.0 148.0 502.0 30.0 
				SWITCH_ROADS_ON 109.0 483.0 0.0 113.0 487.0 30.0 
				SWITCH_ROADS_ON 96.0 492.0 0.0 100.0 496.0 30.0 
				SWITCH_ROADS_ON -96.0 557.0 0.0 -100.0 561.0 30.0 
				SWITCH_ROADS_ON -121.0 571.0 0.0 -117.0 575.0 30.0 
				SWITCH_ROADS_ON -176.0 481.0 0.0 -172.0 485.0 30.0 
				SWITCH_ROADS_ON 15.6 102.0 0.0 19.6 106.0 30.0 
				SWITCH_ROADS_ON 144.0 66.5 0.0 148.0 70.5 30.0
				*/ 
				flag_golf_course_nodes = 1
			ENDIF
		ELSE
			IF flag_golf_course_nodes = 1
				// SCFIX: START - new more accurate roads
				SWITCH_ROADS_OFF -291.0 454.88 0.0 289.51 632.06 35.0
				SWITCH_ROADS_OFF 49.76 296.24 0.0 212.59 472.75 35.0
				SWITCH_ROADS_OFF -35.27 239.98 0.0 173.06 296.31 35.0
				SWITCH_ROADS_OFF -35.27 221.91 0.0 107.16 260.17 35.0
				SWITCH_ROADS_OFF -40.81 152.92 0.0 -1.02 221.9 35.0
				SWITCH_ROADS_OFF -41.29 138.68 0.0 -5.22 153.63 35.0
				SWITCH_ROADS_OFF 2.4 45.65 0.0 193.04 118.35 35.0
				SWITCH_ROADS_OFF 154.86 110.33 0.0 170.11 216.07 35.0
				SWITCH_ROADS_OFF 93.85 112.87 0.0 158.93 187.09 35.0
				SWITCH_ROADS_OFF 60.3 117.41 0.0 94.84 165.74 35.0
				SWITCH_ROADS_OFF 31.83 117.18 0.0 61.28 138.8 35.0
				SWITCH_ROADS_OFF -33.24 -172.84 0.0 187.9 75.76 35.0
				SWITCH_ROADS_OFF -59.67 -148.44 0.0 -17.48 -48.79 35.0
				SWITCH_ROADS_OFF -0.97 188.27 0.0 42.15 221.92 35.0
				// SCFIX: END

				//SWITCH_ROADS_OFF -291.0 -287.0 0.0 208.0 648.0 35.0
				//SWITCH_ROADS_OFF -291.0 -287.0 0.0 208.0 648.0 35.0
				//SWITCH_ROADS_OFF -283.0 372.0 0.0 -137.0 608.0 35.0
				
				/*
				SWITCH_ROADS_OFF 84.0 286.0 0.0 88.0 290.0 30.0 
				SWITCH_ROADS_OFF 92.0 301.0 0.0 96.0 305.0 30.0 
				SWITCH_ROADS_OFF 76.0 312.0 0.0 80.0 316.0 30.0 
				SWITCH_ROADS_OFF 144.0 458.0 0.0 148.0 502.0 30.0 
				SWITCH_ROADS_OFF 109.0 483.0 0.0 113.0 487.0 30.0 
				SWITCH_ROADS_OFF 96.0 492.0 0.0 100.0 496.0 30.0 
				SWITCH_ROADS_OFF -96.0 557.0 0.0 -100.0 561.0 30.0 
				SWITCH_ROADS_OFF -121.0 571.0 0.0 -117.0 575.0 30.0 
				SWITCH_ROADS_OFF -176.0 481.0 0.0 -172.0 485.0 30.0 
				SWITCH_ROADS_OFF 15.6 102.0 0.0 19.6 106.0 30.0 
				SWITCH_ROADS_OFF 144.0 66.5 0.0 148.0 70.5 30.0
				*/ 
				flag_golf_course_nodes = 0
			ENDIF
		ENDIF
	ENDIF



//	IF IS_PLAYER_PLAYING player1
//		IF IS_PLAYER_IN_ZONE player1 


IF sec_counter > 1
	sec_counter = 0
ENDIF
GOTO security_inner



get_ammo:
	// SCFIX: START
	LVAR_INT flag_used_slot1
	flag_used_slot1 = 0
	IF IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_UNARMED
	OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_BRASSKNUCKLE
		flag_used_slot1 = 1
	ENDIF
	// SCFIX: END

	GET_CHAR_WEAPON_IN_SLOT scplayer 1 bollox_1 ammo_slot_1 weapon_model_slot_1
	GET_CHAR_WEAPON_IN_SLOT scplayer 2 bollox_2 ammo_slot_2 weapon_model_slot_2
	GET_CHAR_WEAPON_IN_SLOT scplayer 3 bollox_3 ammo_slot_3 weapon_model_slot_3
	GET_CHAR_WEAPON_IN_SLOT scplayer 4 bollox_3 ammo_slot_4 weapon_model_slot_4
	GET_CHAR_WEAPON_IN_SLOT scplayer 5 bollox_3 ammo_slot_5 weapon_model_slot_5
	GET_CHAR_WEAPON_IN_SLOT scplayer 6 bollox_3 ammo_slot_6 weapon_model_slot_6
	GET_CHAR_WEAPON_IN_SLOT scplayer 7 bollox_3 ammo_slot_7 weapon_model_slot_7
	GET_CHAR_WEAPON_IN_SLOT scplayer 8 bollox_3 ammo_slot_8 weapon_model_slot_8
	GET_CHAR_WEAPON_IN_SLOT scplayer 9 bollox_3 ammo_slot_9 weapon_model_slot_9

	REMOVE_ALL_PLAYER_WEAPONS player1
	
	IF flag_zone = 1
		IF weapon_model_slot_1 > 0
			GIVE_WEAPON_TO_PLAYER player1 bollox_1 ammo_slot_1
		ENDIF
		IF weapon_model_slot_2 > 0
			GIVE_WEAPON_TO_PLAYER player1 bollox_2 ammo_slot_2
		ENDIF
	ENDIF

	// SCFIX: START
	IF flag_used_slot1 = 1
		SET_CURRENT_PLAYER_WEAPON player1 bollox_1
	ENDIF
	// SCFIX: END
	
	//shotgun_ammo = 10 //test stuff to come out!
	//PRINT_WITH_NUMBER_NOW QTY_1 shotgun_ammo 3000 2	// test stuff to come out!
	outer_switch_quickstep = 0
	counter_quickstep = 0

RETURN

security_pickups:

	IF flag_zone = 2
		IF weapon_model_slot_1 > 0
			//++ outer_switch_quickstep
			/*
			REQUEST_MODEL weapon_model_slot_1
			WHILE NOT HAS_MODEL_LOADED weapon_model_slot_1
				WAIT 0
			ENDWHILE
			*/
			REMOVE_PICKUP slot1_pickup_security
			GOSUB quick_stepping
			CREATE_PICKUP_WITH_AMMO weapon_model_slot_1 PICKUP_ONCE ammo_slot_1 pickup_x pickup_y pickup_z slot1_pickup_security
			//flag_slot1_pickup = 1
		ENDIF
		
		IF weapon_model_slot_2 > 0
			//++ outer_switch_quickstep
			/*
			REQUEST_MODEL weapon_model_slot_2
			WHILE NOT HAS_MODEL_LOADED weapon_model_slot_2
				WAIT 0
			ENDWHILE
			*/
			REMOVE_PICKUP slot2_pickup_security
			GOSUB quick_stepping
			CREATE_PICKUP_WITH_AMMO weapon_model_slot_2 PICKUP_ONCE ammo_slot_2 pickup_x pickup_y pickup_z slot2_pickup_security
			//ADD_BLIP_FOR_COORD pickup_x pickup_y pickup_z blippage_de_test2 // TEST TO COME OUT !!!!
			//flag_slot2_pickup = 1
		ENDIF
	ENDIF
	
	IF weapon_model_slot_3 > 0
	AND ammo_slot_3 > 0 // SCFIX
		//++ outer_switch_quickstep
			/*
		REQUEST_MODEL weapon_model_slot_3
		WHILE NOT HAS_MODEL_LOADED weapon_model_slot_3
			WAIT 0
		ENDWHILE
			*/
		REMOVE_PICKUP slot3_pickup_security
		GOSUB quick_stepping																		
		CREATE_PICKUP_WITH_AMMO weapon_model_slot_3 PICKUP_ONCE ammo_slot_3 pickup_x pickup_y pickup_z slot3_pickup_security
		//ADD_BLIP_FOR_COORD pickup_x pickup_y pickup_z blippage_de_test // TEST TO COME OUT !!!!
		//flag_slot3_pickup = 1
	ENDIF
	
	IF weapon_model_slot_4 > 0
	AND ammo_slot_4 > 0 // SCFIX
		//++ outer_switch_quickstep
			/*
		REQUEST_MODEL weapon_model_slot_4
		WHILE NOT HAS_MODEL_LOADED weapon_model_slot_4
			WAIT 0
		ENDWHILE
			*/
		REMOVE_PICKUP slot4_pickup_security
		GOSUB quick_stepping
		CREATE_PICKUP_WITH_AMMO weapon_model_slot_4 PICKUP_ONCE ammo_slot_4 pickup_x pickup_y pickup_z slot4_pickup_security
		//flag_slot4_pickup = 1
	ENDIF
	
	IF weapon_model_slot_5 > 0
	AND ammo_slot_5 > 0 // SCFIX
		//++ outer_switch_quickstep
			/*
		REQUEST_MODEL weapon_model_slot_5
		WHILE NOT HAS_MODEL_LOADED weapon_model_slot_5
			WAIT 0
		ENDWHILE
			*/
		REMOVE_PICKUP slot5_pickup_security
		GOSUB quick_stepping
		CREATE_PICKUP_WITH_AMMO weapon_model_slot_5 PICKUP_ONCE ammo_slot_5 pickup_x pickup_y pickup_z slot5_pickup_security
		//flag_slot5_pickup = 1
	ENDIF
	
	IF weapon_model_slot_6 > 0
	AND ammo_slot_6 > 0 // SCFIX
		//++ outer_switch_quickstep
			/*
		REQUEST_MODEL weapon_model_slot_6
		WHILE NOT HAS_MODEL_LOADED weapon_model_slot_6
			WAIT 0
		ENDWHILE
			*/
		REMOVE_PICKUP slot6_pickup_security
		GOSUB quick_stepping
		CREATE_PICKUP_WITH_AMMO weapon_model_slot_6 PICKUP_ONCE ammo_slot_6 pickup_x pickup_y pickup_z slot6_pickup_security
		//flag_slot6_pickup = 1
	ENDIF

	IF weapon_model_slot_7 > 0
	AND ammo_slot_7 > 0 // SCFIX
		//++ outer_switch_quickstep
			/*
		REQUEST_MODEL weapon_model_slot_7
		WHILE NOT HAS_MODEL_LOADED weapon_model_slot_7
			WAIT 0
		ENDWHILE
			*/
		REMOVE_PICKUP slot7_pickup_security
		GOSUB quick_stepping
		CREATE_PICKUP_WITH_AMMO weapon_model_slot_7 PICKUP_ONCE ammo_slot_7 pickup_x pickup_y pickup_z slot7_pickup_security
		//flag_slot7_pickup = 1
	ENDIF
	
	IF weapon_model_slot_8 > 0
	AND ammo_slot_8 > 0 // SCFIX
		//++ outer_switch_quickstep
			/*
		REQUEST_MODEL weapon_model_slot_8
		WHILE NOT HAS_MODEL_LOADED weapon_model_slot_8
			WAIT 0
		ENDWHILE
			*/
		REMOVE_PICKUP slot8_pickup_security
		GOSUB quick_stepping
		CREATE_PICKUP_WITH_AMMO weapon_model_slot_8 PICKUP_ONCE ammo_slot_8 pickup_x pickup_y pickup_z slot8_pickup_security
		//flag_slot8_pickup = 1
	ENDIF

	IF weapon_model_slot_9 > 0
	AND ammo_slot_9 > 0 // SCFIX
		//++ outer_switch_quickstep
			/*
		REQUEST_MODEL weapon_model_slot_8
		WHILE NOT HAS_MODEL_LOADED weapon_model_slot_8
			WAIT 0
		ENDWHILE
			*/
		REMOVE_PICKUP slot9_pickup_security
		GOSUB quick_stepping
		CREATE_PICKUP_WITH_AMMO weapon_model_slot_9 PICKUP_ONCE ammo_slot_9 pickup_x pickup_y pickup_z slot9_pickup_security
		//flag_slot8_pickup = 1
	ENDIF

RETURN







quick_stepping:

quick_stepping_inner:
	WAIT 0	
	++ outer_switch_quickstep
	IF flag_zone = 1
		IF outer_switch_quickstep > 1
			// SCFIX: START - simplified and fixed this bit
			IF counter_quickstep = 1
				pickup_x = pickup_x - 3.7
				pickup_y = pickup_y - 1.5
				pickup_y = pickup_y - 1.85
				pickup_x = pickup_x + 0.75
				counter_quickstep = 0
			ELSE
				IF counter_quickstep = 0
					pickup_x = pickup_x + 3.7
					pickup_y = pickup_y + 1.5
					++ counter_quickstep
				ENDIF
			ENDIF
			// SCFIX: END
		ELSE
			pickup_x = metal_detector_x - 1.4
			pickup_y = metal_detector_y - 2.6
		ENDIF
	ENDIF
	IF flag_zone = 2
		IF flag_gate = 1
			theta_mod = -5.0
		ELSE
			theta_mod = 5.0
		ENDIF
		IF outer_switch_quickstep > 1
			IF counter_quickstep < 10
				theta_security = theta_security + theta_mod
				GOSUB radial_malarkey
				++ counter_quickstep
			ELSE
				counter_quickstep = 0
			ENDIF
		ELSE
			IF flag_gate = 1
				theta_security = 220.0
				GOSUB radial_malarkey
			ENDIF
			IF flag_gate = 2
				theta_security = 140.0
				GOSUB radial_malarkey
			ENDIF	
		ENDIF
	ENDIF
	IF IS_ANY_PICKUP_AT_COORDS pickup_x pickup_y pickup_z
		GOTO quick_stepping_inner
	ENDIF
RETURN


radial_malarkey:
	SIN theta_security pickup_x
	pickup_x = pickup_x * 34.5
	pickup_x = pickup_x + cent_x
	COS theta_security pickup_y
	pickup_y = pickup_y * 34.5
	pickup_y = pickup_y + cent_y
RETURN

/*
pickup_check:
	
	IF IS_PLAYER_PLAYING player1
	AND flag_zone > 0
		GET_CHAR_WEAPON_IN_SLOT scplayer 1 bollox_1 ammo_slot_1 weapon_model_slot_1
		GET_CHAR_WEAPON_IN_SLOT scplayer 2 bollox_2 ammo_slot_2 weapon_model_slot_2
		GET_CHAR_WEAPON_IN_SLOT scplayer 3 bollox_3 ammo_slot_3 weapon_model_slot_3
		GET_CHAR_WEAPON_IN_SLOT scplayer 4 bollox_4 ammo_slot_4 weapon_model_slot_4
		GET_CHAR_WEAPON_IN_SLOT scplayer 5 bollox_5 ammo_slot_5 weapon_model_slot_5
		GET_CHAR_WEAPON_IN_SLOT scplayer 6 bollox_6 ammo_slot_6 weapon_model_slot_6
		GET_CHAR_WEAPON_IN_SLOT scplayer 7 bollox_7 ammo_slot_7 weapon_model_slot_7
		GET_CHAR_WEAPON_IN_SLOT scplayer 8 bollox_8 ammo_slot_8 weapon_model_slot_8

		
		IF flag_slot1_pickup = 1 
		AND bollox_1 > 0
			REMOVE_PICKUP slot1_pickup_security
			flag_slot1_pickup = 0
		ENDIF
		IF flag_slot2_pickup = 1 
		AND bollox_2 > 0
			REMOVE_PICKUP slot2_pickup_security
			flag_slot2_pickup = 0
		ENDIF
		IF flag_slot3_pickup = 1 
		AND bollox_3	> 0
			REMOVE_PICKUP slot3_pickup_security
			flag_slot3_pickup = 0
		ENDIF
		IF flag_slot4_pickup = 1 
		AND bollox_4 > 0
			REMOVE_PICKUP slot4_pickup_security
			flag_slot4_pickup = 0
		ENDIF
		IF flag_slot5_pickup = 1 
		AND bollox_5 > 0
			REMOVE_PICKUP slot5_pickup_security
			flag_slot5_pickup = 0
		ENDIF
		IF flag_slot6_pickup = 1 
		AND bollox_6 > 0
			REMOVE_PICKUP slot6_pickup_security
			flag_slot6_pickup = 0
		ENDIF
		IF flag_slot7_pickup = 1 
		AND bollox_7 > 0
			REMOVE_PICKUP slot7_pickup_security
			flag_slot7_pickup = 0
		ENDIF
		IF flag_slot8_pickup = 1 
		AND bollox_8 > 0
			REMOVE_PICKUP slot8_pickup_security
			flag_slot8_pickup = 0
		ENDIF
	ENDIF
		
RETURN
*/




security_zone_cleanup:
	
	IF flag_cam_switch > 0
		RESTORE_CAMERA_JUMPCUT
	ENDIF
	SWITCH_SECURITY_CAMERA OFF
	/*
	REMOVE_PICKUP slot1_pickup_security
	REMOVE_PICKUP slot2_pickup_security
	REMOVE_PICKUP slot3_pickup_security
	REMOVE_PICKUP slot4_pickup_security
	REMOVE_PICKUP slot5_pickup_security
	REMOVE_PICKUP slot6_pickup_security
	REMOVE_PICKUP slot7_pickup_security
	REMOVE_PICKUP slot8_pickup_security
	flag_slot1_pickup = 0
	flag_slot2_pickup = 0
	flag_slot3_pickup = 0
	flag_slot4_pickup = 0
	flag_slot5_pickup = 0
	flag_slot6_pickup = 0
	flag_slot7_pickup = 0
	flag_slot8_pickup = 0
	*/
	flag_player_on_bike = 0
	flag_player_been_frisked = 0
RETURN




is_player_on_bike:
IF IS_PLAYER_PLAYING player1
	IF IS_PLAYER_ON_ANY_BIKE player1
		flag_player_on_bike = 1
	ENDIF
ENDIF
RETURN



kill_them_all_1:
	IF NOT IS_CHAR_DEAD security_bloke1
		IF IS_PLAYER_PLAYING player1
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS security_bloke1 player1
			security_disturbed = 1 // SCFIX
			IF flag_1_tooled = 0
			AND HAS_MODEL_LOADED nitestick
				GIVE_WEAPON_TO_CHAR security_bloke1 WEAPONTYPE_NIGHTSTICK 0	
				flag_1_tooled = 1
			ENDIF
		ENDIF
	ENDIF
RETURN




kill_them_all_2:
	IF NOT IS_CHAR_DEAD security_bloke2
		IF IS_PLAYER_PLAYING player1
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS security_bloke2 player1
			security_disturbed = 1 // SCFIX
			IF flag_2_tooled = 0
				GIVE_WEAPON_TO_CHAR security_bloke2 WEAPONTYPE_NIGHTSTICK 0	
				flag_2_tooled = 1
			ENDIF
		ENDIF
	ENDIF
RETURN

// SCFIX: START
play_golf_security_audio:
	IF flag_playing_security_audio = 1
		GENERATE_RANDOM_INT_IN_RANGE 1 4 random_int
		IF random_int = 1
			LOAD_MISSION_AUDIO 2 golf_1
		ENDIF
		IF random_int = 2
			LOAD_MISSION_AUDIO 2 golf_2
		ENDIF
		IF random_int = 3
			LOAD_MISSION_AUDIO 2 golf_3
		ENDIF
		WHILE NOT HAS_MISSION_AUDIO_LOADED 2
			WAIT 0
		ENDWHILE
		PLAY_MISSION_AUDIO 2
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
			WAIT 0
		ENDWHILE
		CLEAR_MISSION_AUDIO 2
		flag_playing_security_audio = 0
	ENDIF
	WAIT 0
	GOTO play_golf_security_audio
	RETURN
// SCFIX: END


}
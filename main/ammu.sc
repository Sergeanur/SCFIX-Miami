MISSION_START

VAR_INT	camera_ammu1 camera_hard1
VAR_INT ammu_bloke_kill_player hard_bloke_hide
VAR_INT special_ammu_audio sniper_in_stock spaz_in_stock
VAR_INT in_shopping_mode1 in_shopping_mode2 dpad_stateX	ReturnedAmmo
VAR_INT ammu_shop_bloke1 hard_shop_bloke1 M4_in_stock laser_in_stock
VAR_INT time_difference1, time_difference2, current_time, time_since_murdering_shopkeeper1, time_since_murdering_shopkeeper2
VAR_INT first_interpolate second_interpolate shop_alarm_played shop_alarm
VAR_INT hands_up_before	armour_in_stock stubby_in_stock	what_WeaponType what_Model
VAR_INT in_this_state1 in_this_state2 players_armour katana_in_stock
VAR_INT hard_weapon1 hard_weapon2 hard_weapon3 hard_weapon4 hard_weapon5
VAR_INT LStickX LStickY RStickX RStickY	ArmourToAdd	cost_of_tool robbed_hardshop_1 robbed_hardshop_2 robbed_hardshop_3
VAR_INT ammu_gun1 ammu_gun2 ammu_gun3 ammu_gun4 ammu_gun5 ammu_gun6 ammu_gun7
VAR_FLOAT shop_blokeX shop_blokeY shop_blokeZ playera_x playera_y playera_z
VAR_INT shotgun_in_stock ruger_in_stock	bbat_in_stock machete_in_stock mp5_in_stock python_in_stock	frenzy_status_ammu

current_time = 0
time_since_murdering_shopkeeper1 = -30000
time_since_murdering_shopkeeper2 = -60000
dpad_stateX = 0
in_shopping_mode1 = 0
in_shopping_mode2 = 0
camera_ammu1 = 0
camera_hard1 = 0
special_ammu_audio = 0
ammu_bloke_kill_player = 0
hard_bloke_hide = 0
hands_up_before = 0
first_interpolate = 0
second_interpolate = 0
in_this_state1 = 0
in_this_state2 = 0
shotgun_in_stock = 0
ruger_in_stock = 0
bbat_in_stock = 0
machete_in_stock = 0
armour_in_stock = 0
stubby_in_stock = 0
sniper_in_stock = 0
M4_in_stock = 0
spaz_in_stock = 0
laser_in_stock = 0
python_in_stock	= 0
mp5_in_stock = 0
katana_in_stock = 0
robbed_hardshop_1 = 0
robbed_hardshop_2 = 0
robbed_hardshop_3 = 0
													 
ADD_CONTINUOUS_SOUND shop_blokeX shop_blokeY shop_blokeZ SOUND_BANK_ALARM_LOOP shop_alarm
REMOVE_SOUND shop_alarm

SCRIPT_NAME	ammu

SET_DEATHARREST_STATE OFF


mission_start_ammu:

{
	START_NEW_SCRIPT shop_ammu1
	START_NEW_SCRIPT shop_ammu2
	START_NEW_SCRIPT shop_ammu3
	START_NEW_SCRIPT shop_hardware1
	START_NEW_SCRIPT shop_hardware2
	START_NEW_SCRIPT shop_hardware3

	MISSION_END
}


shop_ammu1:
{

// AMMU NATION OCEAN BEACH**************************************************************************

	SCRIPT_NAME AMMU1

shop_ammu1_inner:
	
	WAIT 0

	IF IS_PLAYER_PLAYING player1

		IF IS_PLAYER_IN_ZONE player1 BEACH1
		
			IF LOCATE_PLAYER_ANY_MEANS_3D player1 ammu1X ammu1Y ammu1Z 35.0 35.0 20.0 FALSE
					 
				IF camera_ammu1 = 0
					GOSUB load_up_sam
						
					time_difference1 = current_time - time_since_murdering_shopkeeper1

					CREATE_OBJECT colt45 -60.793 -1488.141 12.24 ammu_gun1
					SET_OBJECT_DYNAMIC ammu_gun1 FALSE
					SET_OBJECT_ROTATION ammu_gun1 0.0 8.0 0.0

					CREATE_OBJECT ingramsl -62.293 -1488.241 12.223 ammu_gun2
					SET_OBJECT_DYNAMIC ammu_gun2 FALSE
					SET_OBJECT_ROTATION ammu_gun2 0.0 2.0 0.0

					CREATE_OBJECT chromegun -63.993 -1488.241 12.24 ammu_gun3
					SET_OBJECT_DYNAMIC ammu_gun3 FALSE
					SET_OBJECT_ROTATION ammu_gun3 0.0 7.0 0.0

					CREATE_OBJECT ruger -65.393 -1488.221 12.18 ammu_gun4
					SET_OBJECT_DYNAMIC ammu_gun4 FALSE

					CREATE_OBJECT bodyarmour -66.629 -1488.0 12.113 ammu_gun5
					SET_OBJECT_DYNAMIC ammu_gun5 FALSE

					IF time_difference1 > 30000 
						CREATE_CHAR PEDTYPE_CIVMALE SPECIAL21 -62.5 -1485.1 9.6 ammu_shop_bloke1
						CLEAR_CHAR_THREAT_SEARCH ammu_shop_bloke1
						SET_CHAR_STAY_IN_SAME_PLACE ammu_shop_bloke1 TRUE
						GOSUB ammu_shop_keeper_setup
					ENDIF

					camera_ammu1 = 1
				ELSE //	camera_ammu1 = 1
					
					IF IS_PLAYER_IN_AREA_3D Player1 -57.7 -1468.8 13.4 -69.1 -1487.2 9.0 FALSE
						GOSUB ammu_bloke_goes_radge
					ENDIF	   

				ENDIF // camera_ammu1 


				IF NOT IS_CHAR_DEAD ammu_shop_bloke1 

					IF ammu_bloke_kill_player = 0

						IF flag_cell_nation = 0

							READ_KILL_FRENZY_STATUS frenzy_status_ammu 
							IF NOT frenzy_status_ammu = 1 ////Kill frenzie flag

								IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D player1 ammu1X ammu1Y ammu1Z 1.0 1.0 2.0 TRUE
									
									GOSUB ammu_chat

					 				WHILE in_shopping_mode1 = 0 
									   	flag_cell_nation = 1
										WAIT 0

										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 0
												SET_PLAYER_CONTROL player1 OFF
												IF NOT IS_CHAR_DEAD	ammu_shop_bloke1
													TURN_PLAYER_TO_FACE_CHAR Player1 ammu_shop_bloke1
												ENDIF
												//SET_PLAYER_HEADING player1 180.0
												SET_FIXED_CAMERA_POSITION -60.508 -1486.245 12.428 0.0 0.0 0.0
												POINT_CAMERA_AT_POINT -60.593 -1487.241 12.433 INTERPOLATION //JUMP_CUT

												IF first_interpolate = 0
													SET_INTERPOLATION_PARAMETERS 0.0 1200
													first_interpolate = 1
												ELSE
													SET_INTERPOLATION_PARAMETERS 0.0 800
												ENDIF
			  									second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 ammu1X ammu1Y ammu1Z
													FREEZE_CHAR_POSITION scplayer TRUE
												ENDIF
												WHILE dpad_stateX = 0
													WAIT 0

													PRINT_BIG ( PISTOL ) 1000 4
													PRINT_WITH_NUMBER_NOW ( G_COST ) 100 1000 1
													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state1

														GET_CHAR_WEAPON_IN_SLOT scplayer 4 what_WeaponType ReturnedAmmo what_Model
														GOSUB set_current_weapon

														IF HAS_PLAYER_GOT_WEAPON Player1 WEAPONTYPE_PYTHON
															PRINT_WITH_NUMBER_NOW ( HELP54 ) 100 1000 1
														ENDIF

														IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
															GET_AMMO_IN_PLAYER_WEAPON player1 WEAPONTYPE_PISTOL ReturnedAmmo
															IF IS_SCORE_GREATER player1 99
																IF ReturnedAmmo < 9999
																	GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_PISTOL 68
																	IF ReturnedAmmo > 9999
																		GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_PISTOL 9999
																	ENDIF
																	SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_PISTOL
																	GOSUB buy_noise
																	ADD_SCORE player1 -100
																	ADD_MONEY_SPENT_ON_WEAPONS 100
																	WAIT 300
																ENDIF
															ELSE
																GOSUB denied_noise
															ENDIF
														ENDIF

														IF in_shopping_mode1 = 1
															GOTO shop_ammu1_inner
														ENDIF

													ENDIF

												ENDWHILE
											ENDIF
										ENDIF

										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 1
												SET_FIXED_CAMERA_POSITION -62.008 -1486.245 12.428 0.0 0.0 0.0
												POINT_CAMERA_AT_POINT -62.093 -1487.241 12.433 INTERPOLATION //JUMP_CUT
												SET_INTERPOLATION_PARAMETERS 0.0 800
												in_this_state1 = 0
												in_this_state2 = 0
												second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 ammu1X ammu1Y ammu1Z
												ENDIF
												WHILE dpad_stateX = 1
													WAIT 0

													PRINT_BIG ( INGRAM ) 1000 4
													PRINT_WITH_NUMBER_NOW ( G_COST ) 300 1000 1

													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state1

														GET_CHAR_WEAPON_IN_SLOT scplayer 6 what_WeaponType ReturnedAmmo what_Model
														GOSUB set_current_weapon

														IF HAS_PLAYER_GOT_WEAPON Player1 WEAPONTYPE_MP5
														OR HAS_PLAYER_GOT_WEAPON Player1 WEAPONTYPE_UZI
														OR HAS_PLAYER_GOT_WEAPON Player1 WEAPONTYPE_TEC9
															PRINT_WITH_NUMBER_NOW ( HELP54 ) 300 1000 1
														ENDIF

														IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
															GET_AMMO_IN_PLAYER_WEAPON player1 WEAPONTYPE_SILENCED_INGRAM ReturnedAmmo
															IF IS_SCORE_GREATER player1 299
																IF ReturnedAmmo < 9999
																	GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_SILENCED_INGRAM 120
																	IF ReturnedAmmo > 9999
																		GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_SILENCED_INGRAM 9999
																	ENDIF
																	SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_SILENCED_INGRAM
																	GOSUB buy_noise
																	ADD_SCORE player1 -300
																	ADD_MONEY_SPENT_ON_WEAPONS 300
																	WAIT 300
																ENDIF
															ELSE
																GOSUB denied_noise
															ENDIF
														ENDIF

														IF in_shopping_mode1 = 1
															GOTO shop_ammu1_inner
														ENDIF

													ENDIF

												ENDWHILE
											ENDIF
										ENDIF


										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 2
												SET_FIXED_CAMERA_POSITION -63.508 -1486.245 12.428 0.0 0.0 0.0
												POINT_CAMERA_AT_POINT -63.593 -1487.241 12.433 INTERPOLATION //JUMP_CUT
												SET_INTERPOLATION_PARAMETERS 0.0 800
												in_this_state1 = 0
												in_this_state2 = 0
												second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 ammu1X ammu1Y ammu1Z
												ENDIF
												WHILE dpad_stateX = 2
													WAIT 0

													PRINT_BIG ( SHOTGN1 ) 1000 4
													IF shotgun_in_stock = 0
														PRINT_NOW ( STOCK ) 1000 1	
													ELSE
														PRINT_WITH_NUMBER_NOW ( G_COST ) 500 1000 1 
													ENDIF

													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state1

														GET_CHAR_WEAPON_IN_SLOT scplayer 5 what_WeaponType ReturnedAmmo what_Model
														GOSUB set_current_weapon

														IF shotgun_in_stock = 1
															IF HAS_PLAYER_GOT_WEAPON Player1 WEAPONTYPE_SPAS12_SHOTGUN
															OR HAS_PLAYER_GOT_WEAPON Player1 WEAPONTYPE_STUBBY_SHOTGUN
																PRINT_WITH_NUMBER_NOW ( HELP54 ) 500 1000 1
															ENDIF
														ENDIF

														IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
															IF shotgun_in_stock = 1
																GET_AMMO_IN_PLAYER_WEAPON player1 WEAPONTYPE_SHOTGUN ReturnedAmmo
																IF IS_SCORE_GREATER player1 499
																	IF ReturnedAmmo < 9999
																		GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_SHOTGUN 32
																		IF ReturnedAmmo > 9999
																			GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_SHOTGUN 9999
																		ENDIF
																		SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_SHOTGUN
																		GOSUB buy_noise
																		ADD_SCORE player1 -500
																		ADD_MONEY_SPENT_ON_WEAPONS 500
																		WAIT 300
																	ENDIF
																ELSE
																	GOSUB denied_noise
																ENDIF
															ELSE
																GOSUB denied_noise
															ENDIF
														ENDIF

														IF in_shopping_mode1 = 1
															GOTO shop_ammu1_inner
														ENDIF

													ENDIF

												ENDWHILE
											ENDIF
										ENDIF


										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 3
												SET_FIXED_CAMERA_POSITION -65.008 -1486.245 12.428 0.0 0.0 0.0
												POINT_CAMERA_AT_POINT -65.093 -1487.241 12.433 INTERPOLATION //JUMP_CUT
												SET_INTERPOLATION_PARAMETERS 0.0 800
												in_this_state1 = 0
												in_this_state2 = 0
												second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 ammu1X ammu1Y ammu1Z
												ENDIF
												WHILE dpad_stateX = 3
													WAIT 0

													PRINT_BIG ( RUGER ) 1000 4
													IF ruger_in_stock = 0
														PRINT_NOW ( STOCK ) 1000 1	
													ELSE
														PRINT_WITH_NUMBER_NOW ( G_COST ) 1000 1000 1 
													ENDIF
													
													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state1

														GET_CHAR_WEAPON_IN_SLOT scplayer 7 what_WeaponType ReturnedAmmo what_Model
														GOSUB set_current_weapon

														IF ruger_in_stock = 1
															IF HAS_PLAYER_GOT_WEAPON Player1 WEAPONTYPE_M4
																PRINT_WITH_NUMBER_NOW ( HELP54 ) 1000 1000 1
															ENDIF
														ENDIF

														IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
															IF ruger_in_stock = 1
																GET_AMMO_IN_PLAYER_WEAPON player1 WEAPONTYPE_RUGER ReturnedAmmo
																IF IS_SCORE_GREATER player1 999
																	IF ReturnedAmmo < 9999
																		GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_RUGER 150
																		IF ReturnedAmmo > 9999
																			GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_RUGER 9999
																		ENDIF
																		SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_RUGER
																		GOSUB buy_noise
																		ADD_SCORE player1 -1000
																		ADD_MONEY_SPENT_ON_WEAPONS 1000
																		WAIT 300
																	ENDIF
																ELSE
																	GOSUB denied_noise
																ENDIF
															ELSE
																GOSUB denied_noise
															ENDIF
														ENDIF

														IF in_shopping_mode1 = 1
															GOTO shop_ammu1_inner
														ENDIF

													ENDIF

												ENDWHILE
											ENDIF
										ENDIF

										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 4
												SET_FIXED_CAMERA_POSITION -66.508 -1486.245 12.428 0.0 0.0 0.0
												POINT_CAMERA_AT_POINT -66.593 -1487.241 12.433 INTERPOLATION //JUMP_CUT
												SET_INTERPOLATION_PARAMETERS 0.0 800
												in_this_state1 = 0
												in_this_state2 = 0
												second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 ammu1X ammu1Y ammu1Z
												ENDIF
												WHILE dpad_stateX = 4
													WAIT 0

													PRINT_BIG ( ARMOUR ) 1000 4

													IF armour_in_stock = 0
														PRINT_NOW ( STOCK ) 1000 1	
													ELSE
														PRINT_WITH_NUMBER_NOW ( G_COST ) 200 1000 1 
													ENDIF

													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state1

														GET_CHAR_ARMOUR scplayer players_armour

														IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
															IF armour_in_stock = 1
																IF IS_SCORE_GREATER player1 199
																	IF players_armour < 100
																		ADD_ARMOUR_TO_PLAYER Player1 200
																		GOSUB buy_noise
																		ADD_SCORE player1 -200
																		ADD_MONEY_SPENT_ON_WEAPONS 200
																		WAIT 300
																	ELSE
																		IF done_copcar_progress = 1
																			IF players_armour < 200
																				ADD_ARMOUR_TO_PLAYER Player1 200
																				GOSUB buy_noise
																				ADD_SCORE player1 -200
																				ADD_MONEY_SPENT_ON_WEAPONS 200
																				WAIT 300
																			ENDIF
																		ENDIF 
																	ENDIF

																ELSE
																	GOSUB denied_noise
																ENDIF
															ELSE
																GOSUB denied_noise
															ENDIF
														ENDIF

											   			IF in_shopping_mode1 = 1
															GOTO shop_ammu1_inner
														ENDIF
														  
													ENDIF

												ENDWHILE
											ENDIF
										ENDIF

									ENDWHILE //IF shopping_mode 

								ELSE //LOCATE_PLAYER_IN_AREA_3D	(wee one)

									IF NOT LOCATE_PLAYER_ON_FOOT_3D player1 ammu1X ammu1Y ammu1Z 1.0 1.0 2.0 TRUE
										IF in_shopping_mode1 = 1
											IF IS_PLAYER_PLAYING player1
												GOSUB not_in_wee_ammu_zone
											ENDIF
										ENDIF
									ENDIF

								ENDIF //LOCATE_PLAYER_IN_AREA_3D (wee one)
							
							ENDIF //Kill frenzie flag

						ENDIF //Flag for mobile

					ENDIF //ammubloke kills player

				ENDIF //IF NOT IS_CHAR_DEAD

		
			ELSE //LOCATE_PLAYER_IN_AREA_3D	(big one)

				IF camera_ammu1 = 1
					GOSUB not_in_big_ammu_zone	
				ENDIF

			ENDIF //LOCATE_PLAYER_IN_AREA_3D (big one)

		ENDIF //IS_PLAYER_IN_ZONE

	ELSE //IS_PLAYER_PLAYING
		GOSUB not_in_big_ammu_zone	
	ENDIF

			
	GOTO shop_ammu1_inner
}


shop_ammu2:
{

// AMMU NATION SHOPPING MALL**************************************************************************

	SCRIPT_NAME AMMU2

shop_ammu2_inner:
	
	WAIT 0

	IF IS_PLAYER_PLAYING player1

		IF flag_player_in_mall = 1

			IF IS_PLAYER_IN_AREA_3D Player1 357.7 1016.6 30.1 410.4 1110.4 16.0 FALSE
				IF camera_ammu1 = 0								
					GOSUB load_up_sam	

					time_difference1 = current_time - time_since_murdering_shopkeeper1

					CREATE_OBJECT colt45 367.0 1049.5 21.09 ammu_gun1
					SET_OBJECT_DYNAMIC ammu_gun1 FALSE
					SET_OBJECT_ROTATION ammu_gun1 0.0 8.0 0.0

					CREATE_OBJECT uzi 366.0 1049.5 21.05 ammu_gun2
					SET_OBJECT_DYNAMIC ammu_gun2 FALSE
					SET_OBJECT_ROTATION ammu_gun2 0.0 4.0 0.0

					CREATE_OBJECT buddyshot 364.9 1049.5 21.067 ammu_gun3
					SET_OBJECT_DYNAMIC ammu_gun3 FALSE
					SET_OBJECT_ROTATION ammu_gun3 0.0 9.0 0.0

					CREATE_OBJECT sniper 363.9 1049.5 21.05 ammu_gun4
					SET_OBJECT_DYNAMIC ammu_gun4 FALSE
					SET_OBJECT_ROTATION ammu_gun4 0.0 5.0 0.0

					CREATE_OBJECT grenade 363.1 1049.5 20.76 ammu_gun5
					SET_OBJECT_DYNAMIC ammu_gun5 FALSE

					CREATE_OBJECT grenade 363.0 1049.5 20.72 ammu_gun6
					SET_OBJECT_DYNAMIC ammu_gun6 FALSE

					CREATE_OBJECT bodyarmour 362.1 1049.5 20.9 ammu_gun7
					SET_OBJECT_DYNAMIC ammu_gun7 FALSE

					IF time_difference1 > 30000 
						CREATE_CHAR PEDTYPE_CIVMALE SPECIAL21 366.1 1052.2 18.2 ammu_shop_bloke1
						CLEAR_CHAR_THREAT_SEARCH ammu_shop_bloke1
						SET_CHAR_STAY_IN_SAME_PLACE ammu_shop_bloke1 TRUE
						//SET_CHAR_HEADING ammu_shop_bloke1 180.0
						GOSUB ammu_shop_keeper_setup
					ENDIF

					camera_ammu1 = 1
				ELSE	//	camera_ammu1 = 1

					IF IS_PLAYER_IN_AREA_3D Player1 369.9 1068.7 22.3 359.8 1048.5 18.1 FALSE
						GOSUB ammu_bloke_goes_radge
					ENDIF

				ENDIF // camera_ammu1 


				IF NOT IS_CHAR_DEAD ammu_shop_bloke1 

					IF ammu_bloke_kill_player = 0

						IF flag_cell_nation = 0

							READ_KILL_FRENZY_STATUS frenzy_status_ammu 
							IF NOT frenzy_status_ammu = 1 //Kill frenzie flag

								IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D player1 ammu2X ammu2Y ammu2Z 1.0 1.0 2.0 TRUE
									GOSUB ammu_chat

					 				WHILE in_shopping_mode1 = 0 
										flag_cell_nation = 1
										WAIT 0

										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 0
												SET_PLAYER_CONTROL player1 OFF
												IF NOT IS_CHAR_DEAD	ammu_shop_bloke1
													TURN_PLAYER_TO_FACE_CHAR Player1 ammu_shop_bloke1
												ENDIF
												SET_FIXED_CAMERA_POSITION 367.203 1051.161 21.269 0.0 0.0 0.0
												POINT_CAMERA_AT_POINT 367.152 1050.163 21.291 INTERPOLATION //JUMP_CUT

												IF first_interpolate = 0
													SET_INTERPOLATION_PARAMETERS 0.0 1200
													first_interpolate = 1
												ELSE
													SET_INTERPOLATION_PARAMETERS 0.0 800
												ENDIF
			  									second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 ammu2X ammu2Y ammu2Z
													FREEZE_CHAR_POSITION scplayer TRUE
												ENDIF
												WHILE dpad_stateX = 0
													WAIT 0

													PRINT_BIG ( PISTOL ) 1000 4
													PRINT_WITH_NUMBER_NOW ( G_COST ) 100 1000 1

													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state1_2

														GET_CHAR_WEAPON_IN_SLOT scplayer 4 what_WeaponType ReturnedAmmo what_Model
														GOSUB set_current_weapon

														IF HAS_PLAYER_GOT_WEAPON Player1 WEAPONTYPE_PYTHON
															PRINT_WITH_NUMBER_NOW ( HELP54 ) 100 1000 1
														ENDIF

														IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
															GET_AMMO_IN_PLAYER_WEAPON player1 WEAPONTYPE_PISTOL ReturnedAmmo
															IF IS_SCORE_GREATER player1 99
																IF ReturnedAmmo < 9999
																	GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_PISTOL 68
																	IF ReturnedAmmo > 9999
																		GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_PISTOL 9999
																	ENDIF
																	SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_PISTOL
																	GOSUB buy_noise
																	ADD_SCORE player1 -100
																	ADD_MONEY_SPENT_ON_WEAPONS 100
																	WAIT 300
																ENDIF
															ELSE
																GOSUB denied_noise
															ENDIF
														ENDIF

														IF in_shopping_mode1 = 1
															GOTO shop_ammu2_inner
														ENDIF

													ENDIF

												ENDWHILE
											ENDIF
										ENDIF

										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 1
												SET_FIXED_CAMERA_POSITION 366.203 1051.161 21.269 0.0 0.0 0.0
												POINT_CAMERA_AT_POINT 366.152 1050.163 21.291 INTERPOLATION //JUMP_CUT
												SET_INTERPOLATION_PARAMETERS 0.0 800
												in_this_state1 = 0
												in_this_state2 = 0
												second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 ammu2X ammu2Y ammu2Z
												ENDIF
												WHILE dpad_stateX = 1
													WAIT 0

													PRINT_BIG ( UZI ) 1000 4
													PRINT_WITH_NUMBER_NOW ( G_COST ) 400 1000 1

													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state1_2

														GET_CHAR_WEAPON_IN_SLOT scplayer 6 what_WeaponType ReturnedAmmo what_Model
														GOSUB set_current_weapon

														IF HAS_PLAYER_GOT_WEAPON Player1 WEAPONTYPE_MP5
														OR HAS_PLAYER_GOT_WEAPON Player1 WEAPONTYPE_SILENCED_INGRAM
														OR HAS_PLAYER_GOT_WEAPON Player1 WEAPONTYPE_TEC9
															PRINT_WITH_NUMBER_NOW ( HELP54 ) 400 1000 1
														ENDIF

														IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
															GET_AMMO_IN_PLAYER_WEAPON player1 WEAPONTYPE_UZI ReturnedAmmo
															IF IS_SCORE_GREATER player1 399
																IF ReturnedAmmo < 9999
																	GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_UZI 120
																	IF ReturnedAmmo > 9999
																		GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_UZI 9999
																	ENDIF
																	SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_UZI
																	GOSUB buy_noise
																	ADD_SCORE player1 -400
																	ADD_MONEY_SPENT_ON_WEAPONS 400
																	WAIT 300
																ENDIF
															ELSE
																GOSUB denied_noise
															ENDIF
														ENDIF

														IF in_shopping_mode1 = 1
															GOTO shop_ammu2_inner
														ENDIF

													ENDIF

												ENDWHILE
											ENDIF
										ENDIF


										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 2
												SET_FIXED_CAMERA_POSITION 365.203 1051.161 21.269 0.0 0.0 0.0
												POINT_CAMERA_AT_POINT 365.152 1050.163 21.291 INTERPOLATION //JUMP_CUT
												SET_INTERPOLATION_PARAMETERS 0.0 800
												in_this_state1 = 0
												in_this_state2 = 0
												second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 ammu2X ammu2Y ammu2Z
												ENDIF
												WHILE dpad_stateX = 2
													WAIT 0

													PRINT_BIG ( SHOTGN3 ) 1000 4

													IF stubby_in_stock = 0
														PRINT_NOW ( STOCK ) 1000 1	
													ELSE
														PRINT_WITH_NUMBER_NOW ( G_COST ) 600 1000 1 
													ENDIF

													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state1_2

														GET_CHAR_WEAPON_IN_SLOT scplayer 5 what_WeaponType ReturnedAmmo what_Model
														GOSUB set_current_weapon

														IF stubby_in_stock = 1
															IF HAS_PLAYER_GOT_WEAPON Player1 WEAPONTYPE_SPAS12_SHOTGUN
															OR HAS_PLAYER_GOT_WEAPON Player1 WEAPONTYPE_SHOTGUN
																PRINT_WITH_NUMBER_NOW ( HELP54 ) 600 1000 1
															ENDIF
														ENDIF

														IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
															IF stubby_in_stock = 1
																GET_AMMO_IN_PLAYER_WEAPON player1 WEAPONTYPE_STUBBY_SHOTGUN ReturnedAmmo
																IF IS_SCORE_GREATER player1 599
																	IF ReturnedAmmo < 9999
																		GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_STUBBY_SHOTGUN 20
																		IF ReturnedAmmo > 9999
																			GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_STUBBY_SHOTGUN 9999
																		ENDIF
																		SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_STUBBY_SHOTGUN
																		GOSUB buy_noise
																		ADD_SCORE player1 -600
																		ADD_MONEY_SPENT_ON_WEAPONS 600
																		WAIT 300
																	ENDIF
																ELSE
																	GOSUB denied_noise
																ENDIF
															ELSE
																GOSUB denied_noise
															ENDIF
														ENDIF

														IF in_shopping_mode1 = 1
															GOTO shop_ammu2_inner
														ENDIF

													ENDIF

												ENDWHILE
											ENDIF
										ENDIF


										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 3
												SET_FIXED_CAMERA_POSITION 364.203 1051.161 21.269 0.0 0.0 0.0
												POINT_CAMERA_AT_POINT 364.152 1050.163 21.291 INTERPOLATION //JUMP_CUT
												SET_INTERPOLATION_PARAMETERS 0.0 800
												in_this_state1 = 0
												in_this_state2 = 0
												second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 ammu2X ammu2Y ammu2Z
												ENDIF
												WHILE dpad_stateX = 3
													WAIT 0

													PRINT_BIG ( SNIPE ) 1000 4

													IF sniper_in_stock = 0
														PRINT_NOW ( STOCK ) 1000 1	
													ELSE
														PRINT_WITH_NUMBER_NOW ( G_COST ) 1500 1000 1 
													ENDIF

													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state1_2

														GET_CHAR_WEAPON_IN_SLOT scplayer 9 what_WeaponType ReturnedAmmo what_Model
														GOSUB set_current_weapon

														IF sniper_in_stock = 1
															IF HAS_PLAYER_GOT_WEAPON Player1 WEAPONTYPE_LASERSCOPE
																PRINT_WITH_NUMBER_NOW ( HELP54 ) 1500 1000 1
															ENDIF
														ENDIF

														IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
															IF sniper_in_stock = 1
																GET_AMMO_IN_PLAYER_WEAPON player1 WEAPONTYPE_SNIPERRIFLE ReturnedAmmo
																IF IS_SCORE_GREATER player1 1499
																	IF ReturnedAmmo < 9999
																		GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_SNIPERRIFLE 40
																		IF ReturnedAmmo > 9999
																			GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_SNIPERRIFLE 9999
																		ENDIF
																		SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_SNIPERRIFLE
																		GOSUB buy_noise
																		ADD_SCORE player1 -1500
																		ADD_MONEY_SPENT_ON_WEAPONS 1500
																		WAIT 300
																	ENDIF
																ELSE
																	GOSUB denied_noise
																ENDIF
															ELSE
																GOSUB denied_noise
															ENDIF
														ENDIF

														IF in_shopping_mode1 = 1
															GOTO shop_ammu2_inner
														ENDIF

													ENDIF

												ENDWHILE
											ENDIF
										ENDIF


										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 4
												SET_FIXED_CAMERA_POSITION 363.203 1051.161 21.269 0.0 0.0 0.0
												POINT_CAMERA_AT_POINT 363.152 1050.163 21.291 INTERPOLATION //JUMP_CUT
												SET_INTERPOLATION_PARAMETERS 0.0 800
												in_this_state1 = 0
												in_this_state2 = 0
												second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 ammu2X ammu2Y ammu2Z
												ENDIF
												WHILE dpad_stateX = 4
													WAIT 0

													PRINT_BIG ( GRENADE ) 1000 4
													PRINT_WITH_NUMBER_NOW ( G_COST ) 300 1000 1

													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state1_2

														GET_CHAR_WEAPON_IN_SLOT scplayer 3 what_WeaponType ReturnedAmmo what_Model
														GOSUB set_current_weapon

														IF HAS_PLAYER_GOT_WEAPON Player1 WEAPONTYPE_DETONATOR_GRENADE
														OR HAS_PLAYER_GOT_WEAPON Player1 WEAPONTYPE_MOLOTOV
														OR HAS_PLAYER_GOT_WEAPON Player1 WEAPONTYPE_TEARGAS
															PRINT_WITH_NUMBER_NOW ( HELP54 ) 300 1000 1
														ENDIF

															IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
																GET_AMMO_IN_PLAYER_WEAPON player1 WEAPONTYPE_GRENADE ReturnedAmmo
																IF IS_SCORE_GREATER player1 299
																	IF ReturnedAmmo < 9999
																		GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_GRENADE 8
																		IF ReturnedAmmo > 9999
																			GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_GRENADE 9999
																		ENDIF
																		
																		GOSUB buy_noise
																		ADD_SCORE player1 -300
																		ADD_MONEY_SPENT_ON_WEAPONS 300
																		WAIT 300
																	ENDIF
																ELSE
																	GOSUB denied_noise
																ENDIF
															ENDIF

											   			IF in_shopping_mode1 = 1
															GOTO shop_ammu2_inner
														ENDIF
														  
													ENDIF

												ENDWHILE
											ENDIF
										ENDIF


										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 5
												SET_FIXED_CAMERA_POSITION 362.203 1051.161 21.269 0.0 0.0 0.0
												POINT_CAMERA_AT_POINT 362.152 1050.163 21.291 INTERPOLATION //JUMP_CUT
												SET_INTERPOLATION_PARAMETERS 0.0 800
												in_this_state1 = 0
												in_this_state2 = 0
												second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 ammu2X ammu2Y ammu2Z
												ENDIF
												WHILE dpad_stateX = 5
													WAIT 0

													PRINT_BIG ( ARMOUR ) 1000 4

													IF armour_in_stock = 0
														PRINT_NOW ( STOCK ) 1000 1	
													ELSE
														PRINT_WITH_NUMBER_NOW ( G_COST ) 200 1000 1 
													ENDIF

													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state1_2

														GET_CHAR_ARMOUR scplayer players_armour

														IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
															IF armour_in_stock = 1
																IF IS_SCORE_GREATER player1 199
																	IF players_armour < 100
																		ADD_ARMOUR_TO_PLAYER Player1 200
																		GOSUB buy_noise
																		ADD_SCORE player1 -200
																		ADD_MONEY_SPENT_ON_WEAPONS 200
																		WAIT 300
																	ELSE
																		IF done_copcar_progress = 1
																			IF players_armour < 200
																				ADD_ARMOUR_TO_PLAYER Player1 200
																				GOSUB buy_noise
																				ADD_SCORE player1 -200
																				ADD_MONEY_SPENT_ON_WEAPONS 200
																				WAIT 300
																			ENDIF
																		ENDIF
																	ENDIF
																ELSE
																	GOSUB denied_noise
																ENDIF
															ELSE
																GOSUB denied_noise
															ENDIF
														ENDIF

											   			IF in_shopping_mode1 = 1
															GOTO shop_ammu2_inner
														ENDIF
														  
													ENDIF

												ENDWHILE
											ENDIF
										ENDIF

									ENDWHILE //IF shopping_mode 


								ELSE //LOCATE_PLAYER_IN_AREA_3D	(wee one)
										
									IF NOT LOCATE_PLAYER_ON_FOOT_3D player1 ammu2X ammu2Y ammu2Z 1.0 1.0 2.0 TRUE
										IF in_shopping_mode1 = 1
											IF IS_PLAYER_PLAYING player1
												GOSUB not_in_wee_ammu_zone
											ENDIF
										ENDIF
									ENDIF

								ENDIF //LOCATE_PLAYER_IN_AREA_3D (wee one)

							ENDIF //Kill frenzie flag

						ENDIF //Flag for mobile

					ENDIF //ammubloke kills player

				ENDIF //IF NOT IS_CHAR_DEAD

		
			ELSE //LOCATE_PLAYER_IN_AREA_3D	(big one)

				IF camera_ammu1 = 1
					GOSUB not_in_big_ammu_zone
				ENDIF

			ENDIF //LOCATE_PLAYER_IN_AREA_3D (big one)

		ENDIF //IS_PLAYER_IN_ZONE

	ELSE //IS_PLAYER_PLAYING
		GOSUB not_in_big_ammu_zone	
	ENDIF

			
	GOTO shop_ammu2_inner
}




shop_ammu3:
{

// AMMU NATION DOWNTOWN**************************************************************************

	SCRIPT_NAME AMMU3

shop_ammu3_inner:
	
	WAIT 0

	IF IS_PLAYER_PLAYING player1

		IF IS_PLAYER_IN_ZONE player1 DTOWN

			IF LOCATE_PLAYER_ANY_MEANS_3D player1 ammu3X ammu3Y ammu3Z 35.0 35.0 20.0 FALSE
				IF camera_ammu1 = 0
					GOSUB load_up_sam

					time_difference1 = current_time - time_since_murdering_shopkeeper1

					CREATE_OBJECT python -683.6 1200.549 12.93 ammu_gun1
					SET_OBJECT_DYNAMIC ammu_gun1 FALSE
					SET_OBJECT_ROTATION ammu_gun1 0.0 4.0 90.0

					CREATE_OBJECT mp5lng -683.6 1202.049 12.86 ammu_gun2
					SET_OBJECT_DYNAMIC ammu_gun2 FALSE
					SET_OBJECT_ROTATION ammu_gun2 0.0 8.0 95.0

					CREATE_OBJECT shotgspa -683.6 1203.449 12.91 ammu_gun3
					SET_OBJECT_DYNAMIC ammu_gun3 FALSE
					SET_OBJECT_ROTATION ammu_gun3 0.0 9.0 95.0

					CREATE_OBJECT m4 -683.6 1205.049 12.88 ammu_gun4
					SET_OBJECT_DYNAMIC ammu_gun4 FALSE
					SET_OBJECT_ROTATION ammu_gun4 0.0 3.0 95.0

					CREATE_OBJECT laser -683.6 1206.549 12.81 ammu_gun5
					SET_OBJECT_DYNAMIC ammu_gun5 FALSE
					SET_OBJECT_ROTATION ammu_gun5 0.0 2.0 95.0

					CREATE_OBJECT bodyarmour -683.5 1208.189 12.809 ammu_gun6
					SET_OBJECT_DYNAMIC ammu_gun6 FALSE
					SET_OBJECT_HEADING ammu_gun6 90.0

					//IF flag_player_on_bank_2 = 0
					IF time_difference1 > 30000 
						CREATE_CHAR PEDTYPE_CIVMALE SPECIAL21 -679.97 1203.5 10.0 ammu_shop_bloke1
						SET_CHAR_HEADING ammu_shop_bloke1 270.0
						CLEAR_CHAR_THREAT_SEARCH ammu_shop_bloke1
						SET_CHAR_STAY_IN_SAME_PLACE ammu_shop_bloke1 TRUE
						GOSUB ammu_shop_keeper_setup
					ENDIF
					//ENDIF
					camera_ammu1 = 1
				ELSE	//	camera_ammu1 = 1

					//IF LOCATE_PLAYER_ANY_MEANS_3D player1 ammu3X ammu3Y ammu3Z 6.0 6.0 6.0 FALSE
					IF IS_PLAYER_IN_AREA_3D Player1 -684.5 1199.3 16.9 -663.8 1211.1 10.0 FALSE
						GOSUB ammu_bloke_goes_radge
					ENDIF

				ENDIF // camera_ammu1 

				IF flag_player_on_bank_2 = 0 //Willie's flag

					IF NOT IS_CHAR_DEAD ammu_shop_bloke1
				 
						IF ammu_bloke_kill_player = 0

							IF flag_cell_nation = 0
								
								READ_KILL_FRENZY_STATUS frenzy_status_ammu 
								IF NOT frenzy_status_ammu = 1 ////Kill frenzie flag

			   						IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D player1 ammu3X ammu3Y ammu3Z 1.0 1.0 2.0 TRUE

										GOSUB ammu_chat

						 				WHILE in_shopping_mode1 = 0 
											flag_cell_nation = 1
											WAIT 0

											IF IS_PLAYER_PLAYING player1
												IF dpad_stateX = 0
													SET_PLAYER_CONTROL player1 OFF
													IF NOT IS_CHAR_DEAD	ammu_shop_bloke1
														TURN_PLAYER_TO_FACE_CHAR Player1 ammu_shop_bloke1
													ENDIF

													SET_FIXED_CAMERA_POSITION -682.161 1200.594 13.133 0.0 0.0 0.0
													POINT_CAMERA_AT_POINT -683.155 1200.697 13.171 INTERPOLATION //JUMP_CUT

													IF first_interpolate = 0
														SET_INTERPOLATION_PARAMETERS 0.0 1200
														first_interpolate = 1
													ELSE
														SET_INTERPOLATION_PARAMETERS 0.0 800
													ENDIF
				  									second_interpolate = 0
													WAIT 800
													IF IS_PLAYER_PLAYING player1
														SET_PLAYER_COORDINATES Player1 ammu3X ammu3Y ammu3Z
														FREEZE_CHAR_POSITION scplayer TRUE
													ENDIF
													WHILE dpad_stateX = 0
														WAIT 0

														PRINT_BIG ( PYTHON ) 2000 4
														
														IF python_in_stock = 0
															PRINT_NOW ( STOCK ) 1000 1	
														ELSE
															PRINT_WITH_NUMBER_NOW ( G_COST ) 2000 1000 1 
														ENDIF

														IF IS_PLAYER_PLAYING player1

															GOSUB check_dpad_state1_2

															GET_CHAR_WEAPON_IN_SLOT scplayer 4 what_WeaponType ReturnedAmmo what_Model
															GOSUB set_current_weapon

															IF python_in_stock = 1
																IF HAS_PLAYER_GOT_WEAPON Player1 WEAPONTYPE_PISTOL
																	PRINT_WITH_NUMBER_NOW ( HELP54 ) 2000 1000 1
																ENDIF
															ENDIF

															IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
																IF python_in_stock = 1
																	GET_AMMO_IN_PLAYER_WEAPON player1 WEAPONTYPE_PYTHON ReturnedAmmo
																	IF IS_SCORE_GREATER player1 1999
																		IF ReturnedAmmo < 9999
																			GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_PYTHON 24
																			IF ReturnedAmmo > 9999
																				GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_PYTHON 9999
																			ENDIF
																			SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_PYTHON
																			GOSUB buy_noise
																			ADD_SCORE player1 -2000
																			ADD_MONEY_SPENT_ON_WEAPONS 2000
																			WAIT 300
																		ENDIF
																	ELSE
																		GOSUB denied_noise
																	ENDIF
																ELSE
																	GOSUB denied_noise
																ENDIF
															ENDIF

															IF in_shopping_mode1 = 1
																GOTO shop_ammu3_inner
															ENDIF

														ENDIF

													ENDWHILE
												ENDIF
											ENDIF

											IF IS_PLAYER_PLAYING player1
												IF dpad_stateX = 1
													SET_FIXED_CAMERA_POSITION -682.161 1202.094 13.133 0.0 0.0 0.0
													POINT_CAMERA_AT_POINT -683.155 1202.197 13.171 INTERPOLATION //JUMP_CUT
													SET_INTERPOLATION_PARAMETERS 0.0 800
													in_this_state1 = 0
													in_this_state2 = 0
													second_interpolate = 0
													WAIT 800
													IF IS_PLAYER_PLAYING player1
														SET_PLAYER_COORDINATES Player1 ammu3X ammu3Y ammu3Z
													ENDIF
													WHILE dpad_stateX = 1
														WAIT 0

														PRINT_BIG ( MP5 ) 1000 4
														
														IF mp5_in_stock = 0
															PRINT_NOW ( STOCK ) 1000 1	
														ELSE
															PRINT_WITH_NUMBER_NOW ( G_COST ) 3000 1000 1 
														ENDIF

														IF IS_PLAYER_PLAYING player1

															GOSUB check_dpad_state1_2

															GET_CHAR_WEAPON_IN_SLOT scplayer 6 what_WeaponType ReturnedAmmo what_Model
															GOSUB set_current_weapon

															IF mp5_in_stock = 1
																IF HAS_PLAYER_GOT_WEAPON Player1 WEAPONTYPE_UZI
																OR HAS_PLAYER_GOT_WEAPON Player1 WEAPONTYPE_SILENCED_INGRAM
																OR HAS_PLAYER_GOT_WEAPON Player1 WEAPONTYPE_TEC9
																	PRINT_WITH_NUMBER_NOW ( HELP54 ) 3000 1000 1
																ENDIF
															ENDIF

															IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
																IF mp5_in_stock = 1
																	GET_AMMO_IN_PLAYER_WEAPON player1 WEAPONTYPE_MP5 ReturnedAmmo
																	IF IS_SCORE_GREATER player1 2999
																		IF ReturnedAmmo < 9999
																			GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_MP5 120
																			IF ReturnedAmmo > 9999
																				GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_MP5 9999
																			ENDIF
																			SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_MP5
																			GOSUB buy_noise
																			ADD_SCORE player1 -3000
																			ADD_MONEY_SPENT_ON_WEAPONS 3000
																			WAIT 300
																		ENDIF
																	ELSE
																		GOSUB denied_noise
																	ENDIF
																ELSE
																	GOSUB denied_noise
																ENDIF
															ENDIF

															IF in_shopping_mode1 = 1
																GOTO shop_ammu3_inner
															ENDIF

														ENDIF

													ENDWHILE
												ENDIF
											ENDIF


											IF IS_PLAYER_PLAYING player1
												IF dpad_stateX = 2
													SET_FIXED_CAMERA_POSITION -682.161 1203.594 13.133 0.0 0.0 0.0
													POINT_CAMERA_AT_POINT -683.155 1203.697 13.171 INTERPOLATION //JUMP_CUT
													SET_INTERPOLATION_PARAMETERS 0.0 800
													in_this_state1 = 0
													in_this_state2 = 0
													second_interpolate = 0
													WAIT 800
													IF IS_PLAYER_PLAYING player1
														SET_PLAYER_COORDINATES Player1 ammu3X ammu3Y ammu3Z
													ENDIF
													WHILE dpad_stateX = 2
														WAIT 0

														PRINT_BIG ( SHOTGN2 ) 1000 4
														
														IF spaz_in_stock = 0
															PRINT_NOW ( STOCK ) 1000 1	
														ELSE
															PRINT_WITH_NUMBER_NOW ( G_COST ) 4000 1000 1 
														ENDIF

														IF IS_PLAYER_PLAYING player1

															GOSUB check_dpad_state1_2

															GET_CHAR_WEAPON_IN_SLOT scplayer 5 what_WeaponType ReturnedAmmo what_Model
															GOSUB set_current_weapon

															IF spaz_in_stock = 1
																IF HAS_PLAYER_GOT_WEAPON Player1 WEAPONTYPE_STUBBY_SHOTGUN
																OR HAS_PLAYER_GOT_WEAPON Player1 WEAPONTYPE_SHOTGUN
																	PRINT_WITH_NUMBER_NOW ( HELP54 ) 4000 1000 1
																ENDIF
															ENDIF

															IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
																IF spaz_in_stock = 1
																	GET_AMMO_IN_PLAYER_WEAPON player1 WEAPONTYPE_SPAS12_SHOTGUN ReturnedAmmo
																	IF IS_SCORE_GREATER player1 3999
																		IF ReturnedAmmo < 9999
																			GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_SPAS12_SHOTGUN 28
																			IF ReturnedAmmo > 9999
																				GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_SPAS12_SHOTGUN 9999
																			ENDIF
																			SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_SPAS12_SHOTGUN
																			GOSUB buy_noise
																			ADD_SCORE player1 -4000
																			ADD_MONEY_SPENT_ON_WEAPONS 4000
																			WAIT 300
																		ENDIF
																	ELSE
																		GOSUB denied_noise
																	ENDIF
																ELSE
																	GOSUB denied_noise
																ENDIF
															ENDIF

															IF in_shopping_mode1 = 1
																GOTO shop_ammu3_inner
															ENDIF

														ENDIF

													ENDWHILE
												ENDIF
											ENDIF


											IF IS_PLAYER_PLAYING player1
												IF dpad_stateX = 3
													SET_FIXED_CAMERA_POSITION -682.161 1205.094 13.133 0.0 0.0 0.0
													POINT_CAMERA_AT_POINT -683.155 1205.197 13.171 INTERPOLATION //JUMP_CUT
													SET_INTERPOLATION_PARAMETERS 0.0 800
													in_this_state1 = 0
													in_this_state2 = 0
													second_interpolate = 0
													WAIT 800
													IF IS_PLAYER_PLAYING player1
														SET_PLAYER_COORDINATES Player1 ammu3X ammu3Y ammu3Z
													ENDIF
													WHILE dpad_stateX = 3
														WAIT 0

														PRINT_BIG ( M4 ) 1000 4
														
														IF M4_in_stock = 0
															PRINT_NOW ( STOCK ) 1000 1	
														ELSE
															PRINT_WITH_NUMBER_NOW ( G_COST ) 5000 1000 1 
														ENDIF

														IF IS_PLAYER_PLAYING player1

															GOSUB check_dpad_state1_2

															GET_CHAR_WEAPON_IN_SLOT scplayer 7 what_WeaponType ReturnedAmmo what_Model
															GOSUB set_current_weapon

															IF M4_in_stock = 1
																IF HAS_PLAYER_GOT_WEAPON Player1 WEAPONTYPE_RUGER
																	PRINT_WITH_NUMBER_NOW ( HELP54 ) 5000 1000 1
																ENDIF
															ENDIF

															IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
																IF M4_in_stock = 1
																	GET_AMMO_IN_PLAYER_WEAPON player1 WEAPONTYPE_M4 ReturnedAmmo
																	IF IS_SCORE_GREATER player1 4999
																		IF ReturnedAmmo < 9999
																			GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_M4 150
																			IF ReturnedAmmo > 9999
																				GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_M4 9999
																			ENDIF
																			SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_M4
																			GOSUB buy_noise
																			ADD_SCORE player1 -5000
																			ADD_MONEY_SPENT_ON_WEAPONS 5000
																			WAIT 300
																		ENDIF
																	ELSE
																		GOSUB denied_noise
																	ENDIF
																ELSE
																	GOSUB denied_noise
																ENDIF
															ENDIF

															IF in_shopping_mode1 = 1
																GOTO shop_ammu3_inner
															ENDIF

														ENDIF

													ENDWHILE
												ENDIF
											ENDIF


											IF IS_PLAYER_PLAYING player1
												IF dpad_stateX = 4
													SET_FIXED_CAMERA_POSITION -682.161 1206.594 13.133 0.0 0.0 0.0
													POINT_CAMERA_AT_POINT -683.155 1206.697 13.171 INTERPOLATION //JUMP_CUT
													SET_INTERPOLATION_PARAMETERS 0.0 800
													in_this_state1 = 0
													in_this_state2 = 0
													second_interpolate = 0
													WAIT 800
													IF IS_PLAYER_PLAYING player1
														SET_PLAYER_COORDINATES Player1 ammu3X ammu3Y ammu3Z
													ENDIF
													WHILE dpad_stateX = 4
														WAIT 0

														PRINT_BIG ( LASER ) 1000 4
														
														IF laser_in_stock = 0
															PRINT_NOW ( STOCK ) 1000 1	
														ELSE
															PRINT_WITH_NUMBER_NOW ( G_COST ) 6000 1000 1 
														ENDIF

														IF IS_PLAYER_PLAYING player1

															GOSUB check_dpad_state1_2

															GET_CHAR_WEAPON_IN_SLOT scplayer 9 what_WeaponType ReturnedAmmo what_Model
															GOSUB set_current_weapon

															IF laser_in_stock = 1
																IF HAS_PLAYER_GOT_WEAPON Player1 WEAPONTYPE_SNIPERRIFLE
																	PRINT_WITH_NUMBER_NOW ( HELP54 ) 6000 1000 1
																ENDIF
															ENDIF

															IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
																IF laser_in_stock = 1
																	GET_AMMO_IN_PLAYER_WEAPON player1 WEAPONTYPE_LASERSCOPE ReturnedAmmo
																	IF IS_SCORE_GREATER player1 5999
																		IF ReturnedAmmo < 9999
																			GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_LASERSCOPE 28
																			IF ReturnedAmmo > 9999
																				GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_LASERSCOPE 9999
																			ENDIF
																			
																			GOSUB buy_noise
																			ADD_SCORE player1 -6000
																			ADD_MONEY_SPENT_ON_WEAPONS 6000
																			WAIT 300
																		ENDIF
																	ELSE
																		GOSUB denied_noise
																	ENDIF
																ELSE
																	GOSUB denied_noise
																ENDIF
															ENDIF

												   			IF in_shopping_mode1 = 1
																GOTO shop_ammu3_inner
															ENDIF
															  
														ENDIF

													ENDWHILE
												ENDIF
											ENDIF


											IF IS_PLAYER_PLAYING player1
												IF dpad_stateX = 5
													SET_FIXED_CAMERA_POSITION -682.161 1208.094 13.133 0.0 0.0 0.0
													POINT_CAMERA_AT_POINT -683.155 1208.197 13.171 INTERPOLATION //JUMP_CUT
													SET_INTERPOLATION_PARAMETERS 0.0 800
													in_this_state1 = 0
													in_this_state2 = 0
													second_interpolate = 0
													WAIT 800
													IF IS_PLAYER_PLAYING player1
														SET_PLAYER_COORDINATES Player1 ammu3X ammu3Y ammu3Z
													ENDIF
													WHILE dpad_stateX = 5
														WAIT 0

														PRINT_BIG ( ARMOUR ) 1000 4
														PRINT_WITH_NUMBER_NOW ( G_COST ) 200 1000 1

														IF IS_PLAYER_PLAYING player1

															GOSUB check_dpad_state1_2

															GET_CHAR_ARMOUR scplayer players_armour

															IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
																IF IS_SCORE_GREATER player1 199
																	IF players_armour < 100
																		ADD_ARMOUR_TO_PLAYER Player1 200
																		GOSUB buy_noise
																		ADD_SCORE player1 -200
																		ADD_MONEY_SPENT_ON_WEAPONS 200
																		WAIT 300
																	ELSE
																		IF done_copcar_progress = 1
																			IF players_armour < 200
																				ADD_ARMOUR_TO_PLAYER Player1 200
																				GOSUB buy_noise
																				ADD_SCORE player1 -200
																				ADD_MONEY_SPENT_ON_WEAPONS 200
																				WAIT 300
																			ENDIF
																		ENDIF
																	ENDIF
																ELSE
																	GOSUB denied_noise
																ENDIF
															ENDIF

												   			IF in_shopping_mode1 = 1
																GOTO shop_ammu3_inner
															ENDIF
															  
														ENDIF

													ENDWHILE
												ENDIF
											ENDIF

										ENDWHILE //IF shopping_mode

									ELSE //LOCATE_PLAYER_IN_AREA_3D	(wee one)

										IF NOT LOCATE_PLAYER_ON_FOOT_3D player1	ammu3X ammu3Y ammu3Z 1.0 1.0 2.0 TRUE
											IF in_shopping_mode1 = 1
												IF IS_PLAYER_PLAYING player1
													GOSUB not_in_wee_ammu_zone
												ENDIF
											ENDIF
										ENDIF

									ENDIF //LOCATE_PLAYER_IN_AREA_3D (wee one)

								ENDIF //Kill frenzie flag

							ENDIF //Flag for mobile

						ENDIF //ammubloke kills player
						
					ENDIF //IF NOT IS_CHAR_DEAD

				ENDIF //Willie's flag 

		
			ELSE //LOCATE_PLAYER_IN_AREA_3D	(big one)

				IF camera_ammu1 = 1
					GOSUB not_in_big_ammu_zone
				ENDIF

			ENDIF //LOCATE_PLAYER_IN_AREA_3D (big one)

		ENDIF //IS_PLAYER_IN_ZONE

	ELSE //IS_PLAYER_PLAYING
		GOSUB not_in_big_ammu_zone	
	ENDIF
			
	GOTO shop_ammu3_inner
}




shop_hardware1:
{

// HARDWARE STORE OCEAN BEACH**************************************************************************

	SCRIPT_NAME hard1

shop_hardware_inner1:
	
	WAIT 0

	IF IS_PLAYER_PLAYING player1

		IF IS_PLAYER_IN_ZONE player1 BEACH2

			IF LOCATE_PLAYER_ANY_MEANS_3D player1 hard1X hard1Y hard1Z 35.0 35.0 30.0 FALSE
				IF camera_hard1 = 0
					GOSUB load_up_hard_keeper

					time_difference2 = current_time - time_since_murdering_shopkeeper2

					CREATE_OBJECT screwdriver 201.508 -469.297 13.79 hard_weapon1
					SET_OBJECT_DYNAMIC hard_weapon1 FALSE

					CREATE_OBJECT hammer 202.508 -469.297 13.73 hard_weapon2
					SET_OBJECT_DYNAMIC hard_weapon2 FALSE
					SET_OBJECT_ROTATION hard_weapon2 0.0 4.0 0.0

					CREATE_OBJECT cleaver 203.508 -469.297 13.77 hard_weapon3
					SET_OBJECT_DYNAMIC hard_weapon3 FALSE

					CREATE_OBJECT bat 204.606 -469.297 13.91 hard_weapon4
					SET_OBJECT_DYNAMIC hard_weapon4 FALSE
					SET_OBJECT_ROTATION hard_weapon4 85.0 0.0 90.0

					CREATE_OBJECT machete 205.858 -469.297 14.0 hard_weapon5
					SET_OBJECT_DYNAMIC hard_weapon5 FALSE
					SET_OBJECT_ROTATION hard_weapon5 0.0 90.0 0.0

					IF time_difference2 > 60000
						CREATE_CHAR PEDTYPE_CIVMALE SPECIAL16 202.4 -471.1 10.1 hard_shop_bloke1 
						SET_CHAR_HEADING hard_shop_bloke1 180.1
						GOSUB hard_shop_keeper_setup
					ENDIF

					camera_hard1 = 1
				ELSE	//	camera_hard1 = 1

					//IF LOCATE_PLAYER_ANY_MEANS_3D player1 199.0 -474.0 10.1 8.0 6.0 6.0 FALSE
					IF IS_PLAYER_IN_AREA_3D Player1 190.0 -481.0 15.7 209.6 -468.5 10.0 FALSE
						GOSUB hard_bloke_goes_radge
					ENDIF

				ENDIF // camera_hard1 			


				IF NOT IS_CHAR_DEAD hard_shop_bloke1 

					IF hard_bloke_hide = 0

						IF flag_cell_nation = 0

							READ_KILL_FRENZY_STATUS frenzy_status_ammu 
							IF NOT frenzy_status_ammu = 1 ////Kill frenzie flag

								IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D	player1 hard1X hard1Y hard1Z 1.0 1.0 2.0 TRUE

									GOSUB hardware_chat

					 				WHILE in_shopping_mode2 = 0 
										flag_cell_nation = 1
										WAIT 0

										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 0
												SET_PLAYER_CONTROL player1 OFF
												//SET_PLAYER_HEADING player1 180.0
												IF NOT IS_CHAR_DEAD	hard_shop_bloke1
													TURN_PLAYER_TO_FACE_CHAR Player1 hard_shop_bloke1
												ENDIF
												SET_FIXED_CAMERA_POSITION 201.616 -470.795 14.284 0.0 0.0 0.0						
												POINT_CAMERA_AT_POINT 201.608 -469.797 14.217 INTERPOLATION //JUMP_CUT

												IF first_interpolate = 0
													SET_INTERPOLATION_PARAMETERS 0.0 1200
													first_interpolate = 1
												ELSE
													SET_INTERPOLATION_PARAMETERS 0.0 800
												ENDIF
			  									second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 hard1X hard1Y hard1Z
													FREEZE_CHAR_POSITION scplayer TRUE
												ENDIF
												WHILE dpad_stateX = 0
													WAIT 0

													PRINT_BIG ( SCREWD ) 1000 4
													PRINT_WITH_NUMBER_NOW ( G_COST ) 10 1000 1

													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state2

														cost_of_tool = 10 
														GOSUB you_have_a_weapon

														IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
															IF IS_SCORE_GREATER player1 9
																IF NOT IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_SCREWDRIVER
																	GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_SCREWDRIVER 0
																	SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_SCREWDRIVER
																	GOSUB buy_noise
																	ADD_SCORE player1 -10
																	ADD_MONEY_SPENT_ON_WEAPONS 10
																	WAIT 300
																ELSE
																	GOSUB denied_noise
																ENDIF
															ELSE
																GOSUB denied_noise
															ENDIF
														ENDIF

														IF in_shopping_mode2 = 1
															GOTO shop_hardware_inner1
														ENDIF

													ENDIF

												ENDWHILE
											ENDIF
										ENDIF


										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 1
												SET_FIXED_CAMERA_POSITION 202.616 -470.795 14.284 0.0 0.0 0.0						
												POINT_CAMERA_AT_POINT 202.608 -469.797 14.217 INTERPOLATION //JUMP_CUT
												SET_INTERPOLATION_PARAMETERS 0.0 800
												second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 hard1X hard1Y hard1Z
												ENDIF
												WHILE dpad_stateX = 1
													WAIT 0

													PRINT_BIG ( HAMMER ) 1000 4
													PRINT_WITH_NUMBER_NOW ( G_COST ) 20 1000 1

													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state2

														cost_of_tool = 20
														GOSUB you_have_a_weapon

														IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
															IF IS_SCORE_GREATER player1 19
																IF NOT IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_HAMMER
																	GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_HAMMER 0
																	SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_HAMMER
																	GOSUB buy_noise
																	ADD_SCORE player1 -20
																	ADD_MONEY_SPENT_ON_WEAPONS 20
																	WAIT 300
																ELSE
																	GOSUB denied_noise
																ENDIF
															ELSE
																GOSUB denied_noise
															ENDIF
														ENDIF

														IF in_shopping_mode2 = 1
															GOTO shop_hardware_inner1
														ENDIF

													ENDIF

												ENDWHILE
											ENDIF
										ENDIF


										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 2
												SET_FIXED_CAMERA_POSITION 203.616 -470.795 14.284 0.0 0.0 0.0						
												POINT_CAMERA_AT_POINT 203.608 -469.797 14.217 INTERPOLATION //JUMP_CUT
												SET_INTERPOLATION_PARAMETERS 0.0 800
												second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 hard1X hard1Y hard1Z
												ENDIF
												WHILE dpad_stateX = 2
													WAIT 0

													PRINT_BIG ( CLEVER ) 1000 4
													PRINT_WITH_NUMBER_NOW ( G_COST ) 50 1000 1

													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state2

														cost_of_tool = 50
														GOSUB you_have_a_weapon

														IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
															IF IS_SCORE_GREATER player1 49
																IF NOT IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_CLEAVER
																	GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_CLEAVER 0
																	SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_CLEAVER
																	GOSUB buy_noise
																	ADD_SCORE player1 -50
																	ADD_MONEY_SPENT_ON_WEAPONS 50
																	WAIT 300
																ELSE
																	GOSUB denied_noise
																ENDIF
															ELSE
																GOSUB denied_noise
															ENDIF
														ENDIF

											   			IF in_shopping_mode2 = 1
															GOTO shop_hardware_inner1
														ENDIF
														  
													ENDIF

												ENDWHILE
											ENDIF
										ENDIF

										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 3
												SET_FIXED_CAMERA_POSITION 204.816 -470.795 14.284 0.0 0.0 0.0						
												POINT_CAMERA_AT_POINT 204.808 -469.797 14.217 INTERPOLATION //JUMP_CUT
												SET_INTERPOLATION_PARAMETERS 0.0 800
												second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 hard1X hard1Y hard1Z
												ENDIF
												WHILE dpad_stateX = 3
													WAIT 0

													PRINT_BIG ( BASEBAT ) 1000 4

													IF bbat_in_stock = 0
														PRINT_NOW ( STOCK ) 1000 1 
													ELSE
														PRINT_WITH_NUMBER_NOW ( G_COST ) 80 1000 1
													ENDIF

													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state2

														IF bbat_in_stock = 1
															cost_of_tool = 80
															GOSUB you_have_a_weapon
														ENDIF

														IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
															IF bbat_in_stock = 1
																IF IS_SCORE_GREATER player1 79
																	IF NOT IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_BASEBALLBAT
																		GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_BASEBALLBAT 0
																		SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_BASEBALLBAT
																		GOSUB buy_noise
																		ADD_SCORE player1 -80
																		ADD_MONEY_SPENT_ON_WEAPONS 80
																		WAIT 300
																	ELSE
																		GOSUB denied_noise
																	ENDIF
																ELSE
																	GOSUB denied_noise
																ENDIF
															ELSE
																GOSUB denied_noise
															ENDIF
														ENDIF

											   			IF in_shopping_mode2 = 1
															GOTO shop_hardware_inner1
														ENDIF
														  
													ENDIF

												ENDWHILE
											ENDIF
										ENDIF


										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 4
												SET_FIXED_CAMERA_POSITION 206.116 -470.795 14.284 0.0 0.0 0.0						
												POINT_CAMERA_AT_POINT 206.108 -469.797 14.217 INTERPOLATION //JUMP_CUT
												SET_INTERPOLATION_PARAMETERS 0.0 800
												second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 hard1X hard1Y hard1Z
												ENDIF
												WHILE dpad_stateX = 4
													WAIT 0

													PRINT_BIG ( MACHETE ) 1000 4
													
													IF machete_in_stock = 0
														PRINT_NOW ( STOCK ) 1000 1 
													ELSE
														PRINT_WITH_NUMBER_NOW ( G_COST ) 100 1000 1
													ENDIF

													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state2

														IF machete_in_stock = 1
															cost_of_tool = 100
															GOSUB you_have_a_weapon
														ENDIF

														IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
															IF machete_in_stock	= 1
																IF IS_SCORE_GREATER player1 99
																	IF NOT IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_MACHETE
																		GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_MACHETE 0
																		SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_MACHETE
																		GOSUB buy_noise
																		ADD_SCORE player1 -100
																		ADD_MONEY_SPENT_ON_WEAPONS 100
																		WAIT 300
																	ELSE
																		GOSUB denied_noise
																	ENDIF
																ELSE
																	GOSUB denied_noise
																ENDIF
															ELSE
																GOSUB denied_noise
															ENDIF
														ENDIF

											   			IF in_shopping_mode2 = 1
															GOTO shop_hardware_inner1
														ENDIF
														  
													ENDIF

												ENDWHILE
											ENDIF
										ENDIF

									ENDWHILE //IF shopping_mode 

								ELSE //LOCATE_PLAYER_IN_AREA_3D	(wee one)

									IF NOT LOCATE_PLAYER_ON_FOOT_3D player1 hard1X hard1Y hard1Z 1.0 1.0 2.0 TRUE
										IF in_shopping_mode2 = 1
											IF IS_PLAYER_PLAYING player1
												GOSUB not_in_wee_hard_zone
											ENDIF
										ENDIF
									ENDIF

								ENDIF //LOCATE_PLAYER_IN_AREA_3D (wee one)

							ENDIF //Kill frenzie flag

						ENDIF //Flag for mobile

					ENDIF //bloke kills player

				ENDIF //IF NOT IS_CHAR_DEAD

		
			ELSE //LOCATE_PLAYER_IN_AREA_3D	(big one)

				IF camera_hard1 = 1
					GOSUB not_in_big_hard_zone	
				ENDIF

			ENDIF //LOCATE_PLAYER_IN_AREA_3D (big one)

		ENDIF //IS_PLAYER_IN_ZONE

	ELSE //IS_PLAYER_PLAYING
		GOSUB not_in_big_hard_zone	
	ENDIF
			
	GOTO shop_hardware_inner1
}


shop_hardware2:
{

// HARDWARE STORE SHOPPING MALL**************************************************************************

	SCRIPT_NAME hard2

shop_hardware2_inner:
	
	WAIT 0

	IF IS_PLAYER_PLAYING player1

		IF flag_player_in_mall = 1

			IF IS_PLAYER_IN_AREA_3D Player1 357.7 1016.6 30.1 410.4 1110.4 16.0 FALSE
				IF camera_hard1 = 0
					GOSUB load_up_hard_keeper	

					time_difference2 = current_time - time_since_murdering_shopkeeper2

					CREATE_OBJECT screwdriver 365.960 1072.8 20.68 hard_weapon1
					SET_OBJECT_DYNAMIC hard_weapon1 FALSE

					CREATE_OBJECT hammer 364.960 1072.8 20.669 hard_weapon2
					SET_OBJECT_DYNAMIC hard_weapon2 FALSE
					SET_OBJECT_ROTATION hard_weapon2 0.0 4.0 0.0

					CREATE_OBJECT cleaver 363.960 1072.8 20.729 hard_weapon3
					SET_OBJECT_DYNAMIC hard_weapon3 FALSE

					CREATE_OBJECT knifecur 362.920 1072.8 20.639 hard_weapon4
					SET_OBJECT_DYNAMIC hard_weapon4 FALSE

					CREATE_OBJECT katana 362.0 1072.8 20.75 hard_weapon5
					SET_OBJECT_DYNAMIC hard_weapon5 FALSE
					SET_OBJECT_ROTATION hard_weapon5 0.0 -20.0 0.0

					IF time_difference2 > 60000 
						CREATE_CHAR PEDTYPE_CIVMALE SPECIAL16 364.5 1074.3 18.0 hard_shop_bloke1
						SET_CHAR_HEADING hard_shop_bloke1 358.1
						GOSUB hard_shop_keeper_setup
					ENDIF


					camera_hard1 = 1
				ELSE	//	camera_hard1 = 1

					IF IS_PLAYER_IN_AREA_3D Player1 369.9 1089.8 22.3 359.8 1071.7 18.1 FALSE
						GOSUB hard_bloke_goes_radge
					ENDIF

				ENDIF // camera_hard1 


				IF NOT IS_CHAR_DEAD hard_shop_bloke1 

					IF hard_bloke_hide = 0

						IF flag_cell_nation = 0

							READ_KILL_FRENZY_STATUS frenzy_status_ammu 
							IF NOT frenzy_status_ammu = 1 ////Kill frenzie flag

								IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D player1 hard2X hard2Y hard2Z 1.0 1.0 2.0 TRUE

									GOSUB hardware_chat

					 				WHILE in_shopping_mode2 = 0 
										flag_cell_nation = 1
										WAIT 0
										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 0
												SET_PLAYER_CONTROL player1 OFF
												IF NOT IS_CHAR_DEAD	hard_shop_bloke1
													TURN_PLAYER_TO_FACE_CHAR Player1 hard_shop_bloke1
												ENDIF
												SET_FIXED_CAMERA_POSITION 366.100 1074.719 21.062 0.0 0.0 0.0
												POINT_CAMERA_AT_POINT 366.089 1073.720 21.084 INTERPOLATION //JUMP_CUT

												IF first_interpolate = 0
													SET_INTERPOLATION_PARAMETERS 0.0 1200
													first_interpolate = 1
												ELSE
													SET_INTERPOLATION_PARAMETERS 0.0 800
												ENDIF
			  									second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 hard2X hard2Y hard2Z
													FREEZE_CHAR_POSITION scplayer TRUE
												ENDIF
												WHILE dpad_stateX = 0
													WAIT 0

													PRINT_BIG ( SCREWD ) 1000 4
													PRINT_WITH_NUMBER_NOW ( G_COST ) 10 1000 1

													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state2

														cost_of_tool = 10
														GOSUB you_have_a_weapon

														IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
															IF IS_SCORE_GREATER player1 9
																IF NOT IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_SCREWDRIVER
																	GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_SCREWDRIVER 0
																	SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_SCREWDRIVER
																	GOSUB buy_noise
																	ADD_SCORE player1 -10
																	ADD_MONEY_SPENT_ON_WEAPONS 10
																	WAIT 300
																ELSE
																	GOSUB denied_noise
																ENDIF
															ELSE
																GOSUB denied_noise
															ENDIF
														ENDIF

														IF in_shopping_mode2 = 1
															GOTO shop_hardware2_inner
														ENDIF

													ENDIF

												ENDWHILE
											ENDIF
										ENDIF


										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 1
												SET_FIXED_CAMERA_POSITION 365.100 1074.719 21.062 0.0 0.0 0.0
												POINT_CAMERA_AT_POINT 365.089 1073.720 21.084 INTERPOLATION //JUMP_CUT
												SET_INTERPOLATION_PARAMETERS 0.0 800
												second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 hard2X hard2Y hard2Z
												ENDIF
												WHILE dpad_stateX = 1
													WAIT 0

													PRINT_BIG ( HAMMER ) 1000 4
													PRINT_WITH_NUMBER_NOW ( G_COST ) 20 1000 1

													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state2

														cost_of_tool = 20
														GOSUB you_have_a_weapon

														IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
															IF IS_SCORE_GREATER player1 19
																IF NOT IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_HAMMER
																	GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_HAMMER 0
																	SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_HAMMER
																	GOSUB buy_noise
																	ADD_SCORE player1 -20
																	ADD_MONEY_SPENT_ON_WEAPONS 20
																	WAIT 300
																ELSE
																	GOSUB denied_noise
																ENDIF
															ELSE
																GOSUB denied_noise
															ENDIF
														ENDIF

														IF in_shopping_mode2 = 1
															GOTO shop_hardware2_inner
														ENDIF

													ENDIF

												ENDWHILE
											ENDIF
										ENDIF


										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 2
												SET_FIXED_CAMERA_POSITION 364.100 1074.719 21.062 0.0 0.0 0.0
												POINT_CAMERA_AT_POINT 364.089 1073.720 21.084 INTERPOLATION //JUMP_CUT
												SET_INTERPOLATION_PARAMETERS 0.0 800
												second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 hard2X hard2Y hard2Z
												ENDIF
												WHILE dpad_stateX = 2
													WAIT 0

													PRINT_BIG ( CLEVER ) 1000 4
													PRINT_WITH_NUMBER_NOW ( G_COST ) 50 1000 1

													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state2

														cost_of_tool = 50
														GOSUB you_have_a_weapon

														IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
															IF IS_SCORE_GREATER player1 49
																IF NOT IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_CLEAVER
																	GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_CLEAVER 0
																	SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_CLEAVER
																	GOSUB buy_noise
																	ADD_SCORE player1 -50
																	ADD_MONEY_SPENT_ON_WEAPONS 50
																	WAIT 300
																ELSE
																	GOSUB denied_noise
																ENDIF
															ELSE
																GOSUB denied_noise
															ENDIF
														ENDIF

											   			IF in_shopping_mode2 = 1
															GOTO shop_hardware2_inner
														ENDIF
														  
													ENDIF

												ENDWHILE
											ENDIF
										ENDIF

										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 3
												SET_FIXED_CAMERA_POSITION 363.100 1074.719 21.062 0.0 0.0 0.0
												POINT_CAMERA_AT_POINT 363.089 1073.720 21.084 INTERPOLATION //JUMP_CUT
												SET_INTERPOLATION_PARAMETERS 0.0 800
												second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 hard2X hard2Y hard2Z
												ENDIF
												WHILE dpad_stateX = 3
													WAIT 0							   

													PRINT_BIG ( KNIFE ) 1000 4
													PRINT_WITH_NUMBER_NOW ( G_COST ) 90 1000 1

													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state2

														cost_of_tool = 90
														GOSUB you_have_a_weapon

														IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
															IF IS_SCORE_GREATER player1 89
																IF NOT IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_KNIFE
																	GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_KNIFE 0
																	SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_KNIFE
																	GOSUB buy_noise
																	ADD_SCORE player1 -90
																	ADD_MONEY_SPENT_ON_WEAPONS 90
																	WAIT 300
																ELSE
																	GOSUB denied_noise
																ENDIF
															ELSE
																GOSUB denied_noise
															ENDIF
														ENDIF

											   			IF in_shopping_mode2 = 1
															GOTO shop_hardware2_inner
														ENDIF
														  
													ENDIF

												ENDWHILE
											ENDIF
										ENDIF

										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 4
												SET_FIXED_CAMERA_POSITION 362.100 1074.719 21.062 0.0 0.0 0.0
												POINT_CAMERA_AT_POINT 362.089 1073.720 21.084 INTERPOLATION //JUMP_CUT
												SET_INTERPOLATION_PARAMETERS 0.0 800
												second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 hard2X hard2Y hard2Z
												ENDIF
												WHILE dpad_stateX = 4
													WAIT 0

													PRINT_BIG ( KATANA ) 1000 4

													IF katana_in_stock = 0
														PRINT_NOW ( STOCK ) 1000 1 
													ELSE
														PRINT_WITH_NUMBER_NOW ( G_COST ) 300 1000 1
													ENDIF												

													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state2

														IF katana_in_stock = 1
															cost_of_tool = 300
															GOSUB you_have_a_weapon
														ENDIF
													
														IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
															IF katana_in_stock = 1
																IF IS_SCORE_GREATER player1 299
																	IF NOT IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_KATANA
																		GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_KATANA 0
																		SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_KATANA
																		GOSUB buy_noise
																		ADD_SCORE player1 -300
																		ADD_MONEY_SPENT_ON_WEAPONS 300
																		WAIT 300
																	ELSE
																		GOSUB denied_noise
																	ENDIF
																ELSE
																	GOSUB denied_noise
																ENDIF
															ELSE
																GOSUB denied_noise
															ENDIF
														ENDIF

											   			IF in_shopping_mode2 = 1
															GOTO shop_hardware2_inner
														ENDIF
														  
													ENDIF

												ENDWHILE
											ENDIF
										ENDIF

									ENDWHILE //IF shopping_mode 

								ELSE //LOCATE_PLAYER_IN_AREA_3D	(wee one)

									IF NOT LOCATE_PLAYER_ON_FOOT_3D player1 hard2X hard2Y hard2Z 1.0 1.0 2.0 FALSE
										IF in_shopping_mode2 = 1
											IF IS_PLAYER_PLAYING player1
												GOSUB not_in_wee_hard_zone
											ENDIF
										ENDIF
									ENDIF

								ENDIF //LOCATE_PLAYER_IN_AREA_3D (wee one)

							ENDIF //Kill frenzie flag

						ENDIF //Flag for mobile

					ENDIF //bloke kills player

				ENDIF //IF NOT IS_CHAR_DEAD

		
			ELSE //LOCATE_PLAYER_IN_AREA_3D	(big one)

				IF camera_hard1 = 1
					GOSUB not_in_big_hard_zone
				ENDIF

			ENDIF //LOCATE_PLAYER_IN_AREA_3D (big one)

		ENDIF

	ELSE //IS_PLAYER_PLAYING
		GOSUB not_in_big_hard_zone	
	ENDIF
			
	GOTO shop_hardware2_inner
}



shop_hardware3:
{

// HARDWARE STORE LITTLE HAVANA**************************************************************************

	SCRIPT_NAME hard3

shop_hardware3_inner:
	
	WAIT 0

	IF IS_PLAYER_PLAYING player1

		IF IS_PLAYER_IN_ZONE player1 HAVANA

			IF LOCATE_PLAYER_ANY_MEANS_3D player1 hard3X hard3Y hard3Z 35.0 35.0 20.0 FALSE
				IF camera_hard1 = 0
					GOSUB load_up_hard_keeper	
					
					time_difference2 = current_time - time_since_murdering_shopkeeper2

					CREATE_OBJECT screwdriver -961.0 -689.87 14.080 hard_weapon1
					SET_OBJECT_DYNAMIC hard_weapon1 FALSE
					SET_OBJECT_HEADING hard_weapon1 270.0

					CREATE_OBJECT hammer -960.95 -690.88 14.032 hard_weapon2
					SET_OBJECT_DYNAMIC hard_weapon2 FALSE
					SET_OBJECT_ROTATION hard_weapon2 0.0 4.0 270.0

					CREATE_OBJECT cleaver -960.95 -691.9 14.08 hard_weapon3
					SET_OBJECT_DYNAMIC hard_weapon3 FALSE
					SET_OBJECT_HEADING hard_weapon3 270.0

					CREATE_OBJECT machete -960.8 -693.0 14.08 hard_weapon4
					SET_OBJECT_DYNAMIC hard_weapon4 FALSE
					SET_OBJECT_HEADING hard_weapon4 270.0

					CREATE_OBJECT chnsaw -960.8 -694.0 14.162 hard_weapon5
					SET_OBJECT_DYNAMIC hard_weapon5 FALSE
					SET_OBJECT_HEADING hard_weapon5 270.0

					IF time_difference2 > 60000 			 
						CREATE_CHAR PEDTYPE_CIVMALE SPECIAL16 -963.8 -692.3 10.3 hard_shop_bloke1
						SET_CHAR_HEADING hard_shop_bloke1 90.0
						GOSUB hard_shop_keeper_setup
					ENDIF

					camera_hard1 = 1
				ELSE	//	camera_hard1 = 1

					//IF LOCATE_PLAYER_ANY_MEANS_3D player1 hard3X hard3Y hard3Z 6.0 6.0 6.0 FALSE
					IF IS_PLAYER_IN_AREA_3D Player1 -981.0 -688.0 15.1 -959.8 -696.0 10.1 FALSE
						GOSUB hard_bloke_goes_radge
					ENDIF

				ENDIF // camera_hard1 


				IF NOT IS_CHAR_DEAD hard_shop_bloke1 

					IF hard_bloke_hide = 0

						IF flag_cell_nation = 0

							READ_KILL_FRENZY_STATUS frenzy_status_ammu 
							IF NOT frenzy_status_ammu = 1 ////Kill frenzie flag

								IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D player1 hard3X hard3Y hard3Z 1.0 1.0 2.0 TRUE

									GOSUB hardware_chat

					 				WHILE in_shopping_mode2 = 0 
										flag_cell_nation = 1
										WAIT 0

										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 0
												SET_PLAYER_CONTROL player1 OFF
												IF NOT IS_CHAR_DEAD	hard_shop_bloke1
													TURN_PLAYER_TO_FACE_CHAR Player1 hard_shop_bloke1
												ENDIF
												SET_FIXED_CAMERA_POSITION -962.483 -690.104 14.470 0.0 0.0 0.0
												POINT_CAMERA_AT_POINT -961.485 -690.029 14.481 INTERPOLATION //JUMP_CUT

												IF first_interpolate = 0
													SET_INTERPOLATION_PARAMETERS 0.0 1200
													first_interpolate = 1
												ELSE
													SET_INTERPOLATION_PARAMETERS 0.0 800
												ENDIF
													second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 hard3X hard3Y hard3Z
													FREEZE_CHAR_POSITION scplayer TRUE
												ENDIF
												WHILE dpad_stateX = 0
													WAIT 0

													PRINT_BIG ( SCREWD ) 1000 4
													PRINT_WITH_NUMBER_NOW ( G_COST ) 10 1000 1

													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state2

														cost_of_tool = 10
														GOSUB you_have_a_weapon

														IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
															IF IS_SCORE_GREATER player1 9
																IF NOT IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_SCREWDRIVER
																	GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_SCREWDRIVER 0
																	SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_SCREWDRIVER
																	GOSUB buy_noise
																	ADD_SCORE player1 -10
																	ADD_MONEY_SPENT_ON_WEAPONS 10
																	WAIT 300
																ELSE
																	GOSUB denied_noise
																ENDIF
															ELSE
																GOSUB denied_noise
															ENDIF
														ENDIF

														IF in_shopping_mode2 = 1
															GOTO shop_hardware3_inner
														ENDIF

													ENDIF

												ENDWHILE
											ENDIF
										ENDIF


										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 1
												SET_FIXED_CAMERA_POSITION -962.483 -691.104 14.470 0.0 0.0 0.0
												POINT_CAMERA_AT_POINT -961.485 -691.029 14.481 INTERPOLATION //JUMP_CUT
												SET_INTERPOLATION_PARAMETERS 0.0 800
												second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 hard3X hard3Y hard3Z
												ENDIF
												WHILE dpad_stateX = 1
													WAIT 0

													PRINT_BIG ( HAMMER ) 1000 4
													PRINT_WITH_NUMBER_NOW ( G_COST ) 20 1000 1

													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state2

														cost_of_tool = 20
														GOSUB you_have_a_weapon

														IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
															IF IS_SCORE_GREATER player1 19
																IF NOT IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_HAMMER
																	GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_HAMMER 0
																	SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_HAMMER
																	GOSUB buy_noise
																	ADD_SCORE player1 -20
																	ADD_MONEY_SPENT_ON_WEAPONS 20
																	WAIT 300
																ELSE
																	GOSUB denied_noise
																ENDIF
															ELSE
																GOSUB denied_noise
															ENDIF
														ENDIF

														IF in_shopping_mode2 = 1
															GOTO shop_hardware3_inner
														ENDIF

													ENDIF

												ENDWHILE
											ENDIF
										ENDIF


										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 2
												SET_FIXED_CAMERA_POSITION -962.483 -692.104 14.470 0.0 0.0 0.0
												POINT_CAMERA_AT_POINT -961.485 -692.029 14.481 INTERPOLATION //JUMP_CUT
												SET_INTERPOLATION_PARAMETERS 0.0 800
												second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 hard3X hard3Y hard3Z
												ENDIF
												WHILE dpad_stateX = 2
													WAIT 0

													PRINT_BIG ( CLEVER ) 1000 4
													PRINT_WITH_NUMBER_NOW ( G_COST ) 50 1000 1

													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state2

														cost_of_tool = 50
														GOSUB you_have_a_weapon

														IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
															IF IS_SCORE_GREATER player1 49
																IF NOT IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_CLEAVER
																	GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_CLEAVER 0
																	SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_CLEAVER
																	GOSUB buy_noise
																	ADD_SCORE player1 -50
																	ADD_MONEY_SPENT_ON_WEAPONS 50
																	WAIT 300
																ELSE
																	GOSUB denied_noise
																ENDIF
															ELSE
																GOSUB denied_noise
															ENDIF
														ENDIF

											   			IF in_shopping_mode2 = 1
															GOTO shop_hardware3_inner
														ENDIF
														  
													ENDIF

												ENDWHILE
											ENDIF
										ENDIF

										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 3
												SET_FIXED_CAMERA_POSITION -962.483 -693.204 14.470 0.0 0.0 0.0
												POINT_CAMERA_AT_POINT -961.485 -693.129 14.481 INTERPOLATION //JUMP_CUT
												SET_INTERPOLATION_PARAMETERS 0.0 800
												second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 hard3X hard3Y hard3Z
												ENDIF
												WHILE dpad_stateX = 3
													WAIT 0

													PRINT_BIG ( MACHETE ) 1000 4
													PRINT_WITH_NUMBER_NOW ( G_COST ) 100 1000 1

													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state2

														cost_of_tool = 100
														GOSUB you_have_a_weapon

														IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
															IF IS_SCORE_GREATER player1 99
																IF NOT IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_MACHETE
																	GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_MACHETE 0
																	SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_MACHETE
																	GOSUB buy_noise
																	ADD_SCORE player1 -100
																	ADD_MONEY_SPENT_ON_WEAPONS 100
																	WAIT 300
																ELSE
																	GOSUB denied_noise
																ENDIF
															ELSE
																GOSUB denied_noise
															ENDIF
														ENDIF

											   			IF in_shopping_mode2 = 1
															GOTO shop_hardware3_inner
														ENDIF
														  
													ENDIF

												ENDWHILE
											ENDIF
										ENDIF

										IF IS_PLAYER_PLAYING player1
											IF dpad_stateX = 4
												SET_FIXED_CAMERA_POSITION -962.483 -694.504 14.470 0.0 0.0 0.0
												POINT_CAMERA_AT_POINT -961.485 -694.429 14.481 INTERPOLATION //JUMP_CUT
												SET_INTERPOLATION_PARAMETERS 0.0 800
												second_interpolate = 0
												WAIT 800
												IF IS_PLAYER_PLAYING player1
													SET_PLAYER_COORDINATES Player1 hard3X hard3Y hard3Z
												ENDIF
												WHILE dpad_stateX = 4
													WAIT 0

													PRINT_BIG ( CHAINSA ) 1000 4
													PRINT_WITH_NUMBER_NOW ( G_COST ) 500 1000 1

													IF IS_PLAYER_PLAYING player1

														GOSUB check_dpad_state2

														cost_of_tool = 500
														GOSUB you_have_a_weapon

														IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
															IF IS_SCORE_GREATER player1 499
																IF NOT IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_CHAINSAW
																	GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_CHAINSAW 0
																	SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_CHAINSAW
																	GOSUB buy_noise
																	ADD_SCORE player1 -500
																	ADD_MONEY_SPENT_ON_WEAPONS 500
																	WAIT 300
																ELSE
																	GOSUB denied_noise
																ENDIF
															ELSE
																GOSUB denied_noise
															ENDIF
														ENDIF

											   			IF in_shopping_mode2 = 1
															GOTO shop_hardware3_inner
														ENDIF
														  
													ENDIF

												ENDWHILE
											ENDIF
										ENDIF

									ENDWHILE //IF shopping_mode 

								ELSE //LOCATE_PLAYER_IN_AREA_3D	(wee one)

									IF NOT LOCATE_PLAYER_ON_FOOT_3D player1 hard3X hard3Y hard3Z 1.0 1.0 2.0 FALSE
										IF in_shopping_mode2 = 1
											IF IS_PLAYER_PLAYING player1
												GOSUB not_in_wee_hard_zone
											ENDIF
										ENDIF
									ENDIF

								ENDIF //LOCATE_PLAYER_IN_AREA_3D (wee one)

							ENDIF //Kill frenzie flag

						ENDIF //Flag for mobile

					ENDIF //bloke kills player

				ENDIF //IF NOT IS_CHAR_DEAD
		
			ELSE //LOCATE_PLAYER_IN_AREA_3D	(big one)

				IF camera_hard1 = 1
					GOSUB not_in_big_hard_zone
				ENDIF

			ENDIF //LOCATE_PLAYER_IN_AREA_3D (big one)

		ENDIF //IS_PLAYER_IN_ZONE

	ELSE //IS_PLAYER_PLAYING
		GOSUB not_in_big_hard_zone	
	ENDIF
			
	GOTO shop_hardware3_inner
}




{

ammu_bloke_goes_radge:

	IF NOT IS_CHAR_DEAD ammu_shop_bloke1

		IF IS_PLAYER_SHOOTING player1
		OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON ammu_shop_bloke1 WEAPONTYPE_ANYWEAPON
			IF ammu_bloke_kill_player = 0
				IF IS_PLAYER_PLAYING player1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT ammu_shop_bloke1 player1
				ENDIF
				ammu_bloke_kill_player = 1
			ENDIF
		ENDIF

	ENDIF

RETURN

hard_bloke_goes_radge:

	IF NOT IS_CHAR_DEAD hard_shop_bloke1

		IF IS_PLAYER_TARGETTING_CHAR player1 hard_shop_bloke1
			IF hard_bloke_hide = 0
				STOP_CHAR_LOOKING hard_shop_bloke1
				IF NOT IS_CHAR_DEAD hard_shop_bloke1
					SET_CHAR_CROUCH hard_shop_bloke1 FALSE 9999999
					SET_CHAR_WAIT_STATE hard_shop_bloke1 WAITSTATE_FALSE 0
					SET_CHAR_WAIT_STATE hard_shop_bloke1 WAITSTATE_PLAYANIM_HANDSUP 9999999
					GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS hard_shop_bloke1 0.0 1.2 0.0 shop_blokeX shop_blokeY shop_blokeZ
				ENDIF
				TIMERA = 0
				hard_bloke_hide = 1
			ELSE
				IF TIMERA > 2000
				AND TIMERA < 6000
					IF robbed_money1_created = 0
						CREATE_MONEY_PICKUP shop_blokeX shop_blokeY shop_blokeZ 50 robbed_money1
						ADD_ONE_OFF_SOUND shop_blokeX shop_blokeY shop_blokeZ SOUND_AMMUNATION_BUY_WEAPON
						GOSUB add_stat_point2
						robbed_money1_created = 1
					ENDIF	
				ENDIF
				IF TIMERA > 6000
				AND TIMERA < 10000
					IF robbed_money2_created = 0
						shop_blokeY = shop_blokeY + 0.1
						shop_blokeX = shop_blokeX + 0.1
						CREATE_MONEY_PICKUP shop_blokeX shop_blokeY shop_blokeZ 100 robbed_money2
						ADD_ONE_OFF_SOUND shop_blokeX shop_blokeY shop_blokeZ SOUND_AMMUNATION_BUY_WEAPON
						ALTER_WANTED_LEVEL_NO_DROP Player1 1
						robbed_money2_created = 1
					ENDIF
				ENDIF
				IF TIMERA > 10000
				AND TIMERA < 14000
					IF robbed_money3_created = 0
						shop_blokeY = shop_blokeY + 0.1
						CREATE_MONEY_PICKUP shop_blokeX shop_blokeY shop_blokeZ 250 robbed_money3
						ADD_ONE_OFF_SOUND shop_blokeX shop_blokeY shop_blokeZ SOUND_AMMUNATION_BUY_WEAPON
						ALTER_WANTED_LEVEL_NO_DROP Player1 2
						robbed_money3_created = 1
					ENDIF
				ENDIF
				IF TIMERA > 14000
				AND TIMERA < 20000
					IF robbed_money4_created = 0
						shop_blokeY = shop_blokeY + 0.1
						shop_blokeX = shop_blokeX + 0.1
						CREATE_MONEY_PICKUP shop_blokeX shop_blokeY shop_blokeZ 600 robbed_money4
						ADD_ONE_OFF_SOUND shop_blokeX shop_blokeY shop_blokeZ SOUND_AMMUNATION_BUY_WEAPON
						ALTER_WANTED_LEVEL_NO_DROP Player1 3
						robbed_money4_created = 1
					ENDIF
				ENDIF
			ENDIF

			IF IS_PLAYER_SHOOTING player1
			OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON hard_shop_bloke1 WEAPONTYPE_ANYWEAPON
				GOTO duck_hardware
			ENDIF

		ELSE

			duck_hardware:

			IF hard_bloke_hide = 0
				IF IS_PLAYER_SHOOTING player1
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON hard_shop_bloke1 WEAPONTYPE_ANYWEAPON
					hard_bloke_hide = 1
				ENDIF
			ELSE
				IF NOT IS_CHAR_DEAD hard_shop_bloke1
						SET_CHAR_WAIT_STATE hard_shop_bloke1 WAITSTATE_FALSE 0
						SET_CHAR_CROUCH hard_shop_bloke1 TRUE 9999999
					IF shop_alarm_played = 0
						STOP_CHAR_LOOKING hard_shop_bloke1
						GET_CHAR_COORDINATES hard_shop_bloke1 shop_blokeX shop_blokeY shop_blokeZ 
						ADD_CONTINUOUS_SOUND shop_blokeX shop_blokeY shop_blokeZ SOUND_BANK_ALARM_LOOP shop_alarm
						ALTER_WANTED_LEVEL_NO_DROP Player1 2
						shop_alarm_played = 1
					ENDIF	
				ENDIF
				//hard_bloke_hide = 0
			ENDIF
		ENDIF

	ENDIF

RETURN

denied_noise:
IF IS_PLAYER_PLAYING player1
	GET_PLAYER_COORDINATES Player1 playera_x playera_y playera_z
	ADD_ONE_OFF_SOUND playera_x playera_y playera_z SOUND_AMMUNATION_BUY_WEAPON_DENIED 
ENDIF

WHILE IS_BUTTON_PRESSED	PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
	WAIT 0
ENDWHILE

RETURN

buy_noise:									  

IF IS_PLAYER_PLAYING player1
	GET_PLAYER_COORDINATES Player1 playera_x playera_y playera_z
	ADD_ONE_OFF_SOUND playera_x playera_y playera_z SOUND_AMMUNATION_BUY_WEAPON
ENDIF

WHILE IS_BUTTON_PRESSED	PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
	WAIT 0
ENDWHILE

RETURN

}

{

check_dpad_state1:

	IF IS_JAPANESE_GAME
		PRINT_HELP_FOREVER GUN_H2
	ELSE
		//PRINT_HELP ( GUN_H1 )
		PRINT_HELP_FOREVER GUN_H1
	ENDIF

	GET_POSITION_OF_ANALOGUE_STICKS PAD1 LStickX LStickY RStickX RStickY

	IF IS_BUTTON_PRESSED PAD1 DPADLEFT
	OR LStickX < -100
		dpad_stateX = dpad_stateX - 1
	ENDIF

	IF IS_BUTTON_PRESSED PAD1 DPADRIGHT
	OR LStickX > 100
		dpad_stateX = dpad_stateX + 1
	ENDIF									
  
	IF dpad_stateX < 0
		dpad_stateX = 4
	ENDIF

	IF dpad_stateX > 4
		dpad_stateX = 0
	ENDIF

	IF IS_BUTTON_PRESSED PAD1 PAD_BTN_CANCEL // FIXMIAMI: use button variables instead of copypasted code for JP version
			
		WHILE IS_BUTTON_PRESSED PAD1 PAD_BTN_CANCEL // FIXMIAMI: use button variables instead of copypasted code for JP version
			WAIT 0
			
		ENDWHILE

		IF IS_PLAYER_PLAYING player1
			RESTORE_CAMERA_JUMPCUT
			SET_CAMERA_BEHIND_PLAYER
			CLEAR_HELP
			SET_PLAYER_COORDINATES Player1 ammu1X ammu1Y ammu1Z
			//WAIT 1000

			IF IS_PLAYER_PLAYING player1 
				FREEZE_CHAR_POSITION scplayer FALSE
				SET_PLAYER_CONTROL player1 ON
			ENDIF

			flag_cell_nation = 0
			in_shopping_mode1 = 1
		ENDIF
	ENDIF

RETURN


check_dpad_state1_2:

	IF IS_JAPANESE_GAME
		PRINT_HELP_FOREVER GUN_H2
	ELSE
		//PRINT_HELP ( GUN_H1 )
		PRINT_HELP_FOREVER GUN_H1
	ENDIF

	GET_POSITION_OF_ANALOGUE_STICKS PAD1 LStickX LStickY RStickX RStickY

	IF IS_BUTTON_PRESSED PAD1 DPADLEFT
	OR LStickX < -100
		dpad_stateX = dpad_stateX - 1
	ENDIF

	IF IS_BUTTON_PRESSED PAD1 DPADRIGHT
	OR LStickX > 100
		dpad_stateX = dpad_stateX + 1
	ENDIF									
  
	IF dpad_stateX < 0
		dpad_stateX = 5
	ENDIF

	IF dpad_stateX > 5
		dpad_stateX = 0
	ENDIF

	IF IS_BUTTON_PRESSED PAD1 PAD_BTN_CANCEL // FIXMIAMI: use button variables instead of copypasted code for JP version
		
		WHILE NOT IS_BUTTON_PRESSED PAD1 PAD_BTN_CANCEL // FIXMIAMI: use button variables instead of copypasted code for JP version
			WAIT 0
			
		ENDWHILE

		IF IS_PLAYER_PLAYING player1
			RESTORE_CAMERA_JUMPCUT
			SET_CAMERA_BEHIND_PLAYER
			CLEAR_HELP
			IF IS_PLAYER_PLAYING player1
				IF IS_PLAYER_IN_ZONE player1 BEACH3
					SET_PLAYER_COORDINATES Player1 ammu2X ammu2Y ammu2Z
				ENDIF
				IF IS_PLAYER_IN_ZONE player1 DTOWN
					SET_PLAYER_COORDINATES Player1 ammu3X ammu3Y ammu3Z
				ENDIF
			ENDIF

			IF IS_PLAYER_PLAYING player1 
				FREEZE_CHAR_POSITION scplayer FALSE
				SET_PLAYER_CONTROL player1 ON
			ENDIF

			flag_cell_nation = 0
			in_shopping_mode1 = 1
		ENDIF

	ENDIF

RETURN


check_dpad_state2:

	IF IS_JAPANESE_GAME
		PRINT_HELP_FOREVER GUN_H2
	ELSE
		//PRINT_HELP ( GUN_H1 )
		PRINT_HELP_FOREVER GUN_H1
	ENDIF

	GET_POSITION_OF_ANALOGUE_STICKS PAD1 LStickX LStickY RStickX RStickY

	IF IS_BUTTON_PRESSED PAD1 DPADLEFT
	OR LStickX < -100
		dpad_stateX = dpad_stateX - 1
	ENDIF

	IF IS_BUTTON_PRESSED PAD1 DPADRIGHT
	OR LStickX > 100
		dpad_stateX = dpad_stateX + 1
	ENDIF

	IF dpad_stateX < 0
		dpad_stateX = 4
	ENDIF

	IF dpad_stateX > 4
		dpad_stateX = 0
	ENDIF

	IF IS_BUTTON_PRESSED PAD1 PAD_BTN_CANCEL // FIXMIAMI: use button variables instead of copypasted code for JP version
		
		WHILE IS_BUTTON_PRESSED PAD1 PAD_BTN_CANCEL // FIXMIAMI: use button variables instead of copypasted code for JP version
			WAIT 0
			
		ENDWHILE

		IF IS_PLAYER_PLAYING player1
			RESTORE_CAMERA_JUMPCUT
			SET_CAMERA_BEHIND_PLAYER
			CLEAR_HELP
			IF IS_PLAYER_PLAYING player1
				IF IS_PLAYER_IN_ZONE player1 BEACH2
					SET_PLAYER_COORDINATES Player1 hard1X hard1Y hard1Z
				ENDIF
				IF IS_PLAYER_IN_ZONE player1 BEACH3
					SET_PLAYER_COORDINATES Player1 hard2X hard2Y hard2Z
				ENDIF
				IF IS_PLAYER_IN_ZONE player1 HAVANA
					SET_PLAYER_COORDINATES Player1 hard3X hard3Y hard3Z
				ENDIF
			ENDIF
			//WAIT 1000
			IF IS_PLAYER_PLAYING player1
				FREEZE_CHAR_POSITION scplayer FALSE 
				SET_PLAYER_CONTROL player1 ON
			ENDIF
			flag_cell_nation = 0
			in_shopping_mode2 = 1
		ENDIF
	ENDIF

RETURN

}


{

ammu_chat:

IF special_ammu_audio = 0 
	special_ammu_audio = 1
ENDIF

RETURN


hardware_chat:

IF special_ammu_audio = 0 
	special_ammu_audio = 1
ENDIF

RETURN


ammu_shop_keeper_setup:
	WAIT 1500

	IF IS_PLAYER_PLAYING player1
		IF NOT IS_CHAR_DEAD ammu_shop_bloke1
			SET_CHAR_PERSONALITY ammu_shop_bloke1 PEDSTAT_TOUGH_GUY
			IF IS_PLAYER_IN_ZONE player1 BEACH1
				IF HAS_MODEL_LOADED ingramsl
				 	GIVE_WEAPON_TO_CHAR ammu_shop_bloke1 WEAPONTYPE_SILENCED_INGRAM 9999
				ENDIF 
			ENDIF
			IF IS_PLAYER_IN_ZONE player1 BEACH3
				IF HAS_MODEL_LOADED uzi
					GIVE_WEAPON_TO_CHAR ammu_shop_bloke1 WEAPONTYPE_UZI 9999
				ENDIF 
			ENDIF
			IF IS_PLAYER_IN_ZONE player1 DTOWN
				IF HAS_MODEL_LOADED python
					GIVE_WEAPON_TO_CHAR ammu_shop_bloke1 WEAPONTYPE_PYTHON 9999
				ENDIF 
			ENDIF
			IF IS_PLAYER_PLAYING player1
				CHAR_LOOK_AT_PLAYER_ALWAYS ammu_shop_bloke1 player1
			ENDIF
		ENDIF
	ENDIF
RETURN


not_in_wee_ammu_zone:

	in_shopping_mode1 = 0
	dpad_stateX = 0
	special_ammu_audio = 0
	first_interpolate = 0
	CLEAR_HELP
 
RETURN

not_in_big_ammu_zone:

	IF IS_CHAR_DEAD	ammu_shop_bloke1
	AND	time_difference1 > 30000 //time_difference is greater than 30,000 means shopkeeper has been created 
		GET_GAME_TIMER time_since_murdering_shopkeeper1 
	ENDIF
	DELETE_CHAR	ammu_shop_bloke1
	UNLOAD_SPECIAL_CHARACTER 21
	IF IS_PLAYER_PLAYING player1
		FREEZE_CHAR_POSITION scplayer FALSE
	ENDIF
	DELETE_OBJECT ammu_gun1
	DELETE_OBJECT ammu_gun2
	DELETE_OBJECT ammu_gun3
	DELETE_OBJECT ammu_gun4				
	DELETE_OBJECT ammu_gun5	
	DELETE_OBJECT ammu_gun6	
	DELETE_OBJECT ammu_gun7		
	ammu_bloke_kill_player = 0	
	camera_ammu1 = 0
	hands_up_before = 0
	REMOVE_SOUND shop_alarm
	
	IF NOT IS_PLAYER_PLAYING player1
		time_since_murdering_shopkeeper1 = -30000
	ENDIF
					 
RETURN

hard_shop_keeper_setup:
		
	IF NOT IS_CHAR_DEAD	hard_shop_bloke1								  
		SET_CHAR_PERSONALITY hard_shop_bloke1 PEDSTAT_TOUGH_GUY 
		CLEAR_CHAR_THREAT_SEARCH hard_shop_bloke1
		SET_CHAR_STAY_IN_SAME_PLACE hard_shop_bloke1 TRUE
		IF IS_PLAYER_PLAYING player1
			CHAR_LOOK_AT_PLAYER_ALWAYS hard_shop_bloke1 player1
		ENDIF
	ENDIF

RETURN

not_in_wee_hard_zone:

	in_shopping_mode2 = 0
	dpad_stateX = 0
	special_ammu_audio = 0
	first_interpolate = 0
	CLEAR_HELP

RETURN

not_in_big_hard_zone:

	IF IS_CHAR_DEAD	hard_shop_bloke1
	OR hard_bloke_hide = 1
		IF	time_difference2 > 60000 //time_difference is greater than 60,000 means shopkeeper has been created 
			GET_GAME_TIMER time_since_murdering_shopkeeper2 
		ENDIF
	ENDIF
	DELETE_CHAR	hard_shop_bloke1
	DELETE_OBJECT hard_weapon1
	DELETE_OBJECT hard_weapon2
	DELETE_OBJECT hard_weapon3
	DELETE_OBJECT hard_weapon4
	DELETE_OBJECT hard_weapon5
	UNLOAD_SPECIAL_CHARACTER 16
	IF IS_PLAYER_PLAYING player1
		FREEZE_CHAR_POSITION scplayer FALSE
	ENDIF
	robbed_money1_created = 0
	robbed_money2_created = 0
	robbed_money3_created = 0
	robbed_money4_created = 0	
	hard_bloke_hide = 0	
	camera_hard1 = 0
	hands_up_before = 0
	shop_alarm_played = 0
	REMOVE_SOUND shop_alarm
	
	IF NOT IS_PLAYER_PLAYING player1
		time_since_murdering_shopkeeper2 = -60000
	ENDIF
					 
RETURN

load_up_sam:

	LOAD_SPECIAL_CHARACTER 21 sam

	WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 21 //HAS_MODEL_LOADED BMODK //BMODK
		WAIT 0
		LOAD_SPECIAL_CHARACTER 21 sam
	ENDWHILE	

	GET_GAME_TIMER current_time

	DELETE_CHAR ammu_shop_bloke1

RETURN

load_up_hard_keeper:

	LOAD_SPECIAL_CHARACTER 16 s_keep

	WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 16 //HAS_MODEL_LOADED BMODK //BMODK
		WAIT 0
		LOAD_SPECIAL_CHARACTER 16 s_keep
	ENDWHILE	

	GET_GAME_TIMER current_time

	DELETE_CHAR	hard_shop_bloke1

RETURN


you_have_a_weapon:

	GET_CHAR_WEAPON_IN_SLOT scplayer 2 what_WeaponType ReturnedAmmo what_Model
	SET_CURRENT_PLAYER_WEAPON player1 what_WeaponType
	IF NOT what_WeaponType = WEAPONTYPE_UNARMED
		PRINT_WITH_NUMBER_NOW ( HELP54 ) cost_of_tool 1000 1
	ENDIF

RETURN

set_current_weapon:

	IF ReturnedAmmo > 0
		SET_CURRENT_PLAYER_WEAPON player1 what_WeaponType
	ENDIF

RETURN


add_stat_point2:

	// WASHINGTON BEACH
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 hard1X hard1Y hard1Z 35.0 35.0 30.0 FALSE
	AND robbed_hardshop_1 = 0
	 	ADD_STORES_KNOCKED_OFF 1
		robbed_every_shop ++
		robbed_hardshop_1 = 1
	ENDIF

	// MALL
	IF IS_PLAYER_IN_AREA_3D Player1 357.7 1016.6 30.1 410.4 1110.4 16.0 FALSE
	AND robbed_hardshop_2 = 0
	 	ADD_STORES_KNOCKED_OFF 1
		robbed_every_shop ++
		robbed_hardshop_2 = 1
	ENDIF

	//HAVANA
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 hard3X hard3Y hard3Z 35.0 35.0 20.0 FALSE
	AND robbed_hardshop_3 = 0
	 	ADD_STORES_KNOCKED_OFF 1
		robbed_every_shop ++
		robbed_hardshop_3 = 1
	ENDIF

RETURN

}
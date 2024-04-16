MISSION_START

VAR_INT	time_since_murdering_shopkeeper3 time_since_murdering_shopkeeper4 time_since_murdering_shopkeeper5  
VAR_INT create_shop_keeper1 create_shop_keeper2 create_shop_keeper3	shop_bloke_hide	robbed_every_shop 
VAR_INT shop_bloke1	time_difference3 time_difference4 time_difference5 robbed_money1 robbed_money2 robbed_money3 robbed_money4
VAR_INT robbed_money1_created robbed_money2_created robbed_money3_created robbed_money4_created
VAR_INT robbed_shop_1 robbed_shop_2 robbed_shop_3 robbed_shop_4 robbed_shop_5 robbed_shop_6 robbed_shop_7 
VAR_INT robbed_shop_8 robbed_shop_9 robbed_shop_10 robbed_shop_11 robbed_shop_12

time_since_murdering_shopkeeper3 = -60000
time_since_murdering_shopkeeper4 = -60000
time_since_murdering_shopkeeper5 = -60000
create_shop_keeper1 = 0
shop_bloke_hide = 0
shop_alarm_played = 0
robbed_money1_created = 0
robbed_money2_created = 0
robbed_money3_created = 0
robbed_money4_created = 0
robbed_shop_1 = 0
robbed_shop_2 = 0
robbed_shop_3 = 0
robbed_shop_4 = 0
robbed_shop_5 = 0
robbed_shop_6 = 0
robbed_shop_7 = 0
robbed_shop_8 = 0
robbed_shop_9 = 0
robbed_shop_10 = 0
robbed_shop_11 = 0
robbed_shop_12 = 0
robbed_every_shop = 0

SCRIPT_NAME	shops

SET_DEATHARREST_STATE OFF

mission_start_shops:

{
	START_NEW_SCRIPT shopware1
	START_NEW_SCRIPT shopware2
	START_NEW_SCRIPT shopware3
	START_NEW_SCRIPT shopware4
	START_NEW_SCRIPT shopware5

	MISSION_END
}




shopware1:
{

// VICE POINT**************************************************************************

	SCRIPT_NAME shop1

shopware_inner1:
	
	WAIT 0

	IF IS_PLAYER_PLAYING player1
		IF IS_PLAYER_IN_ZONE player1 BEACH3
		AND flag_player_in_mall = 0
			
			// 7-11
			IF LOCATE_PLAYER_ANY_MEANS_3D player1 449.7 781.5 12.2 30.0 30.0 30.0 FALSE
				IF create_shop_keeper1 = 0	
					GOSUB load_shop_keeper
					time_difference3 = current_time - time_since_murdering_shopkeeper3
					IF time_difference3 > 60000
						CREATE_CHAR PEDTYPE_CIVMALE SPECIAL16 450.0 782.5 12.2 shop_bloke1 
						GOSUB set_up_shopkeeper
					ENDIF
					create_shop_keeper1 = 1
				ELSE
					IF time_difference3 > 60000	
						IF NOT IS_CHAR_DEAD shop_bloke1 
							IF IS_PLAYER_IN_AREA_3D Player1 472.7 800.4 11.5 438.1 779.0 17.0 FALSE
								GOSUB shop_bloke_goes_radge
							ENDIF
						ELSE 
							ALTER_WANTED_LEVEL_NO_DROP Player1 1
						ENDIF
					ENDIF
				ENDIF  			
			ELSE 
				IF create_shop_keeper1 = 1
					GOSUB cleanup_shop_robbing
				ENDIF
			ENDIF 
		
			IF IS_PLAYER_PLAYING player1
				// Chemist
				IF LOCATE_PLAYER_ANY_MEANS_3D player1 383.2 759.7 11.0 30.0 30.0 30.0 FALSE
					IF create_shop_keeper2 = 0
						GOSUB load_shop_keeper
						time_difference4 = current_time - time_since_murdering_shopkeeper4
						IF time_difference4 > 60000
							CREATE_CHAR PEDTYPE_CIVMALE SPECIAL16 383.2 759.7 11.0 shop_bloke1 
							SET_CHAR_HEADING shop_bloke1 180.0
							GOSUB set_up_shopkeeper
						ENDIF
						create_shop_keeper2 = 1
					ELSE
						IF time_difference4 > 60000	
							IF NOT IS_CHAR_DEAD shop_bloke1 
								IF LOCATE_PLAYER_ANY_MEANS_3D player1 383.2 759.7 11.0 8.0 8.0 6.0 FALSE
									GOSUB shop_bloke_goes_radge
								ENDIF
							ELSE 
								ALTER_WANTED_LEVEL_NO_DROP Player1 1
							ENDIF
						ENDIF
					ENDIF  			
				ELSE 
					IF create_shop_keeper2 = 1
						GOSUB cleanup_shop_robbing
					ENDIF
				ENDIF
			ENDIF

			IF IS_PLAYER_PLAYING player1
				// Jewllers
				IF LOCATE_PLAYER_ANY_MEANS_3D player1 379.9 210.2 10.6 30.0 30.0 30.0 FALSE
					IF create_shop_keeper3 = 0
						GOSUB load_shop_keeper
						time_difference5 = current_time - time_since_murdering_shopkeeper5
						IF time_difference5 > 60000
							CREATE_CHAR PEDTYPE_CIVMALE SPECIAL16 379.9 210.2 10.6 shop_bloke1 
							SET_CHAR_HEADING shop_bloke1 280.0
							GOSUB set_up_shopkeeper
						ENDIF
						create_shop_keeper3 = 1
					ELSE	
						IF time_difference5 > 60000
							IF NOT IS_CHAR_DEAD shop_bloke1 
								IF LOCATE_PLAYER_ANY_MEANS_3D player1 379.9 210.2 10.6 8.0 8.0 6.0 FALSE
									GOSUB shop_bloke_goes_radge
								ENDIF
							ELSE 
								ALTER_WANTED_LEVEL_NO_DROP Player1 1
							ENDIF
						ENDIF
					ENDIF  			
				ELSE 
					IF create_shop_keeper3 = 1
						GOSUB cleanup_shop_robbing
					ENDIF
				ENDIF
			ENDIF

		ENDIF 
	ELSE
		GOSUB cleanup_shop_robbing
	ENDIF 
			
	GOTO shopware_inner1
}


shopware2:
{

// HAITI**************************************************************************

	SCRIPT_NAME shop2

shopware_inner2:
	
	WAIT 0

	IF IS_PLAYER_PLAYING player1
		IF IS_PLAYER_IN_ZONE player1 HAITI
			
			// Chemist
			IF LOCATE_PLAYER_ANY_MEANS_3D player1 -846.6 -72.6 10.8 30.0 30.0 30.0 FALSE
				IF create_shop_keeper1 = 0
					GOSUB load_shop_keeper

					time_difference3 = current_time - time_since_murdering_shopkeeper3
					IF time_difference3 > 60000
						CREATE_CHAR PEDTYPE_CIVMALE SPECIAL16 -846.6 -72.6 10.8 shop_bloke1 
						SET_CHAR_HEADING shop_bloke1 166.0
						GOSUB set_up_shopkeeper
					ENDIF
					create_shop_keeper1 = 1
				ELSE
					IF time_difference3 > 60000
						IF NOT IS_CHAR_DEAD shop_bloke1 
							IF LOCATE_PLAYER_ANY_MEANS_3D player1 -846.6 -72.6 10.8 8.0 8.0 6.0 FALSE
								GOSUB shop_bloke_goes_radge
							ENDIF
						ELSE 
							ALTER_WANTED_LEVEL_NO_DROP Player1 1
						ENDIF
					ENDIF
				ENDIF  			
			ELSE 
				IF create_shop_keeper1 = 1
					GOSUB cleanup_shop_robbing
				ENDIF
			ENDIF 

		ENDIF 
	ELSE
		GOSUB cleanup_shop_robbing
	ENDIF 
			
	GOTO shopware_inner2
}


shopware3:
{

// DOWNTOWN**************************************************************************

	SCRIPT_NAME shop3

shopware_inner3:
	
	WAIT 0

	IF IS_PLAYER_PLAYING player1
		IF IS_PLAYER_IN_ZONE player1 DTOWN
			
			// Chemist
			IF LOCATE_PLAYER_ANY_MEANS_3D player1 -830.4 741.9 10.6 30.0 30.0 30.0 FALSE
				IF create_shop_keeper1 = 0
					GOSUB load_shop_keeper
					time_difference3 = current_time - time_since_murdering_shopkeeper3
					IF time_difference3 > 60000
						CREATE_CHAR PEDTYPE_CIVMALE SPECIAL16 -830.4 741.9 10.6 shop_bloke1 
						SET_CHAR_HEADING shop_bloke1 90.0
						GOSUB set_up_shopkeeper
					ENDIF
					create_shop_keeper1 = 1
				ELSE
					IF time_difference3 > 60000	
						IF NOT IS_CHAR_DEAD shop_bloke1 
							IF LOCATE_PLAYER_ANY_MEANS_3D player1 -830.4 741.9 10.6 8.0 8.0 6.0 FALSE
								GOSUB shop_bloke_goes_radge
							ENDIF
						ELSE 
							ALTER_WANTED_LEVEL_NO_DROP Player1 1
						ENDIF
					ENDIF
				ENDIF  			
			ELSE 
				IF create_shop_keeper1 = 1
					GOSUB cleanup_shop_robbing
				ENDIF
			ENDIF 

			IF IS_PLAYER_PLAYING player1
				// Jewllers
				IF LOCATE_PLAYER_ANY_MEANS_3D player1 -854.3 850.0 10.6 30.0 30.0 30.0 FALSE
					IF create_shop_keeper2 = 0
						GOSUB load_shop_keeper
						time_difference4 = current_time - time_since_murdering_shopkeeper4
						IF time_difference4 > 60000
							CREATE_CHAR PEDTYPE_CIVMALE SPECIAL16 -854.3 850.0 10.6 shop_bloke1 
							SET_CHAR_HEADING shop_bloke1 110.0
							GOSUB set_up_shopkeeper
						ENDIF
						create_shop_keeper2 = 1
					ELSE
						IF time_difference4 > 60000	
							IF NOT IS_CHAR_DEAD shop_bloke1 
								IF LOCATE_PLAYER_ANY_MEANS_3D player1 -854.3 850.0 10.6 8.0 8.0 6.0 FALSE
									GOSUB shop_bloke_goes_radge
								ENDIF
							ELSE 
								ALTER_WANTED_LEVEL_NO_DROP Player1 1
							ENDIF
						ENDIF
					ENDIF  			
				ELSE 
					IF create_shop_keeper2 = 1
						GOSUB cleanup_shop_robbing
					ENDIF
				ENDIF
			ENDIF

		ENDIF 
	ELSE
		GOSUB cleanup_shop_robbing
	ENDIF 
			
	GOTO shopware_inner3
}


shopware4:
{

// HAVANA**************************************************************************

	SCRIPT_NAME shop4

shopware_inner4:
	
	WAIT 0

	IF IS_PLAYER_PLAYING player1
		IF IS_PLAYER_IN_ZONE player1 HAVANA
			
			//Deli
			IF LOCATE_PLAYER_ANY_MEANS_3D player1 -859.2 -632.7 10.6 30.0 30.0 30.0 FALSE
				IF create_shop_keeper1 = 0
					GOSUB load_shop_keeper
					time_difference3 = current_time - time_since_murdering_shopkeeper3
					IF time_difference3 > 60000
						CREATE_CHAR PEDTYPE_CIVMALE SPECIAL16 -858.8 -632.66 10.6 shop_bloke1 
						SET_CHAR_HEADING shop_bloke1 193.0
						GOSUB set_up_shopkeeper
					ENDIF
					create_shop_keeper1 = 1
				ELSE
					IF time_difference3 > 60000	
						IF NOT IS_CHAR_DEAD shop_bloke1 
							IF LOCATE_PLAYER_ANY_MEANS_3D player1 -859.2 -632.7 10.6 8.0 8.0 6.0 FALSE
								GOSUB shop_bloke_goes_radge
							ENDIF
						ELSE 
							ALTER_WANTED_LEVEL_NO_DROP Player1 1
						ENDIF
					ENDIF
				ENDIF  
							
			ELSE 
				IF create_shop_keeper1 = 1
					GOSUB cleanup_shop_robbing
				ENDIF
			ENDIF
			
			IF IS_PLAYER_PLAYING player1
				//Cuban Cafe
				IF IS_PLAYER_PLAYING player1
					IF LOCATE_PLAYER_ANY_MEANS_3D player1 -1167.1 -615.8 11.0 30.0 30.0 30.0 FALSE
						IF create_shop_keeper2 = 0
							GOSUB load_shop_keeper
							time_difference4 = current_time - time_since_murdering_shopkeeper4
							IF time_difference4 > 60000
								CREATE_CHAR PEDTYPE_CIVMALE SPECIAL16 -1167.1 -615.8 11.0 shop_bloke1 
								SET_CHAR_HEADING shop_bloke1 90.0
								GOSUB set_up_shopkeeper
							ENDIF
							create_shop_keeper2 = 1
						ELSE
							IF time_difference4 > 60000	
								IF NOT IS_CHAR_DEAD shop_bloke1 
									IF LOCATE_PLAYER_ANY_MEANS_3D player1 -1167.1 -615.8 11.0 8.0 8.0 6.0 FALSE
										GOSUB shop_bloke_goes_radge
									ENDIF
								ELSE 
									ALTER_WANTED_LEVEL_NO_DROP Player1 1
								ENDIF
							ENDIF
						ENDIF  			
					ELSE 
						IF create_shop_keeper2 = 1
							GOSUB cleanup_shop_robbing
						ENDIF
					ENDIF
				ENDIF
			ENDIF

			IF IS_PLAYER_PLAYING player1
				//Laundrete
				IF IS_PLAYER_PLAYING player1
					IF LOCATE_PLAYER_ANY_MEANS_3D player1 -1192.2 -323.7 11.1 30.0 30.0 30.0 FALSE
						IF create_shop_keeper3 = 0
							GOSUB load_shop_keeper
							time_difference5 = current_time - time_since_murdering_shopkeeper5
							IF time_difference5 > 60000
								CREATE_CHAR PEDTYPE_CIVMALE SPECIAL16 -1192.2 -323.7 11.1 shop_bloke1 
								SET_CHAR_HEADING shop_bloke1 90.0
								GOSUB set_up_shopkeeper
							ENDIF
							create_shop_keeper3 = 1
						ELSE
							IF time_difference5 > 60000	
								IF NOT IS_CHAR_DEAD shop_bloke1 
									IF LOCATE_PLAYER_ANY_MEANS_3D player1 -1192.2 -323.7 11.1 8.0 8.0 6.0 FALSE
										GOSUB shop_bloke_goes_radge
									ENDIF
								ELSE 
									ALTER_WANTED_LEVEL_NO_DROP Player1 1
								ENDIF
							ENDIF
						ENDIF  			
					ELSE 
						IF create_shop_keeper3 = 1
							GOSUB cleanup_shop_robbing
						ENDIF
					ENDIF
				ENDIF
			ENDIF

		ENDIF 
	ELSE
		GOSUB cleanup_shop_robbing
	ENDIF 
			
	GOTO shopware_inner4
}


shopware5:
{

// MALL**************************************************************************

	SCRIPT_NAME shop5

shopware_inner5:
	
	WAIT 0

	IF IS_PLAYER_PLAYING player1
		IF flag_player_in_mall = 1
			
			// Music store
			IF LOCATE_PLAYER_ANY_MEANS_3D player1 352.7 1111.3 24.5 30.0 30.0 15.0 FALSE
				IF create_shop_keeper1 = 0
					GOSUB load_shop_keeper
					time_difference3 = current_time - time_since_murdering_shopkeeper3
					IF time_difference3 > 60000
						CREATE_CHAR PEDTYPE_CIVMALE SPECIAL16 352.7 1111.3 24.5 shop_bloke1
						SET_CHAR_HEADING shop_bloke1 290.0
						GOSUB set_up_shopkeeper
					ENDIF
					create_shop_keeper1 = 1
				ELSE
					IF time_difference3 > 60000	
						IF NOT IS_CHAR_DEAD shop_bloke1 
							IF LOCATE_PLAYER_ANY_MEANS_3D player1 352.7 1111.3 24.5 8.0 8.0 6.0 FALSE
								GOSUB shop_bloke_goes_radge
							ENDIF
						ELSE 
							ALTER_WANTED_LEVEL_NO_DROP Player1 1
						ENDIF
					ENDIF
				ENDIF  			
			ELSE 
				IF create_shop_keeper1 = 1
					GOSUB cleanup_shop_robbing
				ENDIF
			ENDIF
				
			IF IS_PLAYER_PLAYING player1
				// Gash
				IF LOCATE_PLAYER_ANY_MEANS_3D player1 424.0 1039.4 18.1 30.0 30.0 15.0 FALSE // SCFIX: x was 423.5
					IF create_shop_keeper2 = 0
						GOSUB load_shop_keeper
						time_difference4 = current_time - time_since_murdering_shopkeeper4
						IF time_difference4 > 60000
							CREATE_CHAR PEDTYPE_CIVMALE SPECIAL16 424.0 1039.4 18.1 shop_bloke1  // SCFIX: x was 423.5
							SET_CHAR_HEADING shop_bloke1 136.0
							GOSUB set_up_shopkeeper
						ENDIF
						create_shop_keeper2 = 1
					ELSE
						IF time_difference4 > 60000	
							IF NOT IS_CHAR_DEAD shop_bloke1 
								IF LOCATE_PLAYER_ANY_MEANS_3D player1 424.0 1039.4 18.1 8.0 8.0 6.0 FALSE // SCFIX: x was 423.5
									GOSUB shop_bloke_goes_radge
								ENDIF
							ELSE 
								ALTER_WANTED_LEVEL_NO_DROP Player1 1
							ENDIF
						ENDIF
					ENDIF  			
				ELSE
					IF create_shop_keeper2 = 1 
						GOSUB cleanup_shop_robbing
					ENDIF
				ENDIF
			ENDIF

			IF IS_PLAYER_PLAYING player1
				// Jewllers
				IF LOCATE_PLAYER_ANY_MEANS_3D player1 468.7 1206.6 19.0 30.0 30.0 15.0 FALSE
					IF create_shop_keeper3 = 0
						GOSUB load_shop_keeper
						time_difference5 = current_time - time_since_murdering_shopkeeper5
						IF time_difference5 > 60000
							CREATE_CHAR PEDTYPE_CIVMALE SPECIAL16 468.7 1206.6 19.0 shop_bloke1 
							SET_CHAR_HEADING shop_bloke1 90.0
							GOSUB set_up_shopkeeper
						ENDIF
						create_shop_keeper3 = 1
					ELSE
						IF time_difference5 > 60000	
							IF NOT IS_CHAR_DEAD shop_bloke1 
								IF LOCATE_PLAYER_ANY_MEANS_3D player1 468.7 1206.6 19.0 8.0 8.0 6.0 FALSE
									GOSUB shop_bloke_goes_radge
								ENDIF
							ELSE 
								ALTER_WANTED_LEVEL_NO_DROP Player1 1
							ENDIF
						ENDIF
					ENDIF  			
				ELSE 
					IF create_shop_keeper3 = 1
						GOSUB cleanup_shop_robbing
					ENDIF
				ENDIF
			ENDIF
			 
		ENDIF 
	ELSE
		GOSUB cleanup_shop_robbing
	ENDIF 
			
	GOTO shopware_inner5
}



//GOSUBS***************************************************************************
{

shop_bloke_goes_radge:

	IF NOT IS_CHAR_DEAD shop_bloke1

		IF IS_PLAYER_TARGETTING_CHAR player1 shop_bloke1
			IF shop_bloke_hide = 0
				STOP_CHAR_LOOKING shop_bloke1
				IF NOT IS_CHAR_DEAD shop_bloke1
					SET_CHAR_CROUCH shop_bloke1 FALSE 9999999
					SET_CHAR_WAIT_STATE shop_bloke1 WAITSTATE_FALSE 0
					SET_CHAR_WAIT_STATE shop_bloke1 WAITSTATE_PLAYANIM_HANDSUP 9999999
					GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS shop_bloke1 0.0 1.2 0.0 shop_blokeX shop_blokeY shop_blokeZ
				ENDIF
				TIMERA = 0
				shop_bloke_hide = 1
			ELSE
				IF shop_alarm_played = 0
					IF TIMERA > 2000
					AND TIMERA < 6000
						IF robbed_money1_created = 0
							shop_blokeZ = shop_blokeZ + 0.15
							CREATE_MONEY_PICKUP shop_blokeX shop_blokeY shop_blokeZ 50 robbed_money1
							ADD_ONE_OFF_SOUND shop_blokeX shop_blokeY shop_blokeZ SOUND_AMMUNATION_BUY_WEAPON
							GOSUB add_stat_point
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
			ENDIF

			IF IS_PLAYER_SHOOTING player1
			OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON shop_bloke1 WEAPONTYPE_ANYWEAPON
				GOTO duck_shop_robbing
			ENDIF


		ELSE

			duck_shop_robbing:

			IF shop_bloke_hide = 0

				IF IS_PLAYER_SHOOTING player1
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON shop_bloke1 WEAPONTYPE_ANYWEAPON
					shop_bloke_hide = 1
				ENDIF
			ELSE
				IF NOT IS_CHAR_DEAD shop_bloke1
					SET_CHAR_WAIT_STATE shop_bloke1 WAITSTATE_FALSE 0
					SET_CHAR_CROUCH shop_bloke1 TRUE 9999999
					IF shop_alarm_played = 0
						GET_CHAR_COORDINATES shop_bloke1 shop_blokeX shop_blokeY shop_blokeZ 
						ADD_CONTINUOUS_SOUND shop_blokeX shop_blokeY shop_blokeZ SOUND_BANK_ALARM_LOOP shop_alarm
						ALTER_WANTED_LEVEL_NO_DROP Player1 2
						shop_alarm_played = 1
					ENDIF	
				ENDIF
				//shop_bloke_hide = 0
			ENDIF

		ENDIF
		
	ENDIF

RETURN


load_shop_keeper:

	LOAD_SPECIAL_CHARACTER 16 s_keep

	WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 16
		WAIT 0
		LOAD_SPECIAL_CHARACTER 16 s_keep
	ENDWHILE

	GET_GAME_TIMER current_time
	DELETE_CHAR	shop_bloke1

RETURN


cleanup_shop_robbing:

	IF create_shop_keeper1 = 1
		IF IS_CHAR_DEAD	shop_bloke1
		OR shop_bloke_hide = 1
			IF time_difference3 > 60000 //time_difference is greater than 60,000 means shopkeeper has been created 
				GET_GAME_TIMER time_since_murdering_shopkeeper3 
			ENDIF
			
		ENDIF
	ENDIF

	IF create_shop_keeper2 = 1
		IF IS_CHAR_DEAD	shop_bloke1
		OR shop_bloke_hide = 1
			IF time_difference4 > 60000 //time_difference is greater than 60,000 means shopkeeper has been created 
				GET_GAME_TIMER time_since_murdering_shopkeeper4 
			ENDIF
			
		ENDIF
	ENDIF

	IF create_shop_keeper3 = 1
		IF IS_CHAR_DEAD	shop_bloke1
		OR shop_bloke_hide = 1
			IF time_difference5 > 60000 //time_difference is greater than 60,000 means shopkeeper has been created 
				GET_GAME_TIMER time_since_murdering_shopkeeper5
			ENDIF
				 
		ENDIF
	ENDIF

	create_shop_keeper1 = 0
	create_shop_keeper2 = 0
	create_shop_keeper3 = 0
	shop_bloke_hide = 0
	shop_alarm_played = 0
	robbed_money1_created = 0
	robbed_money2_created = 0
	robbed_money3_created = 0
	robbed_money4_created = 0
	REMOVE_PICKUP robbed_money1
	REMOVE_PICKUP robbed_money2
	REMOVE_PICKUP robbed_money3
	REMOVE_PICKUP robbed_money4
	UNLOAD_SPECIAL_CHARACTER 16
	DELETE_CHAR	shop_bloke1
	REMOVE_SOUND shop_alarm

	IF NOT IS_PLAYER_PLAYING player1
		time_since_murdering_shopkeeper3 = -60000
		time_since_murdering_shopkeeper4 = -60000
		time_since_murdering_shopkeeper5 = -60000
	ENDIF

RETURN

set_up_shopkeeper:

	SET_CHAR_PERSONALITY shop_bloke1 PEDSTAT_TOUGH_GUY 
	CLEAR_CHAR_THREAT_SEARCH shop_bloke1
	SET_CHAR_STAY_IN_SAME_PLACE shop_bloke1 TRUE
	IF IS_PLAYER_PLAYING player1
		CHAR_LOOK_AT_PLAYER_ALWAYS shop_bloke1 player1
	ENDIF

RETURN

}


add_stat_point:

//Deli //HAVANA
IF LOCATE_PLAYER_ANY_MEANS_3D player1 -859.2 -632.7 10.6 30.0 30.0 30.0 FALSE
AND robbed_shop_1 = 0
 	ADD_STORES_KNOCKED_OFF 1
	robbed_every_shop ++
	robbed_shop_1 = 1
ENDIF

// Jewllers	//DOWNTOW
IF LOCATE_PLAYER_ANY_MEANS_3D player1 -854.3 850.0 10.6 30.0 30.0 30.0 FALSE
AND robbed_shop_2 = 0
 	ADD_STORES_KNOCKED_OFF 1
	robbed_every_shop ++
	robbed_shop_2 = 1
ENDIF

// Chemist //DOWNTOWN
IF LOCATE_PLAYER_ANY_MEANS_3D player1 -830.4 741.9 10.6 30.0 30.0 30.0 FALSE
AND robbed_shop_3 = 0
 	ADD_STORES_KNOCKED_OFF 1
	robbed_every_shop ++
	robbed_shop_3 = 1
ENDIF

// Chemist //HAITI
IF LOCATE_PLAYER_ANY_MEANS_3D player1 -846.6 -72.6 10.8 30.0 30.0 30.0 FALSE
AND robbed_shop_4 = 0
 	ADD_STORES_KNOCKED_OFF 1
	robbed_every_shop ++
	robbed_shop_4 = 1
ENDIF

// Jewllers	//VICEPOINT
IF LOCATE_PLAYER_ANY_MEANS_3D player1 379.9 210.2 10.6 30.0 30.0 30.0 FALSE
AND robbed_shop_5 = 0
 	ADD_STORES_KNOCKED_OFF 1
	robbed_every_shop ++
	robbed_shop_5 = 1
ENDIF

// Chemist //VICEPOINT
IF LOCATE_PLAYER_ANY_MEANS_3D player1 383.2 759.7 11.0 30.0 30.0 30.0 FALSE
AND robbed_shop_6 = 0
 	ADD_STORES_KNOCKED_OFF 1
	robbed_every_shop ++
	robbed_shop_6 = 1
ENDIF

// 7-11	//VICEPOINT
IF LOCATE_PLAYER_ANY_MEANS_3D player1 449.7 781.5 12.2 30.0 30.0 30.0 FALSE
AND robbed_shop_7 = 0
 	ADD_STORES_KNOCKED_OFF 1
	robbed_every_shop ++
	robbed_shop_7 = 1
ENDIF

// Music store //MALL
IF LOCATE_PLAYER_ANY_MEANS_3D player1 352.7 1111.3 24.5 30.0 30.0 15.0 FALSE
AND robbed_shop_8 = 0
 	ADD_STORES_KNOCKED_OFF 1
	robbed_every_shop ++
	robbed_shop_8 = 1
ENDIF

// Gash	//MALL
IF LOCATE_PLAYER_ANY_MEANS_3D player1 423.5 1039.4 18.1 30.0 30.0 15.0 FALSE
AND robbed_shop_9 = 0
 	ADD_STORES_KNOCKED_OFF 1
	robbed_every_shop ++
	robbed_shop_9 = 1
ENDIF

// Jewllers	//MALL
IF LOCATE_PLAYER_ANY_MEANS_3D player1 468.7 1206.6 18.2 30.0 30.0 15.0 FALSE
AND robbed_shop_10 = 0
 	ADD_STORES_KNOCKED_OFF 1
	robbed_every_shop ++
	robbed_shop_10 = 1
ENDIF

// Cuban Cafe //HAVANA
IF LOCATE_PLAYER_ANY_MEANS_3D player1 -1167.5 -613.5 11.0 30.0 30.0 30.0 FALSE
AND robbed_shop_11 = 0
 	ADD_STORES_KNOCKED_OFF 1
	robbed_every_shop ++
	robbed_shop_11 = 1
ENDIF

// Laundrete //HAVANA
IF LOCATE_PLAYER_ANY_MEANS_3D player1 -1192.2 -323.7 11.1 30.0 30.0 30.0 FALSE
AND robbed_shop_12 = 0
 	ADD_STORES_KNOCKED_OFF 1
	robbed_every_shop ++
	robbed_shop_12 = 1
ENDIF

RETURN
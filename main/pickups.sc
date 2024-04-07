MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// **********************************Pickups************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

 
// Variables for mission
VAR_INT clothes2_created clothes3_created clothes4_created clothes5_created clothes6_created 
VAR_INT clothes7_created clothes8_created clothes9_created clothes10_created clothes11_created clothes12_created clothes13_created       
VAR_INT hotel_clothes_created mansion_clothes_created save1_clothes_created save2_clothes_created save3_clothes_created save4_clothes_created save5_clothes_created 
VAR_INT clothes_pickup1 clothes_pickup2 clothes_pickup3 clothes_pickup4 clothes_pickup5 clothes_pickup6  
VAR_INT clothes_pickup7 clothes_pickup8 clothes_pickup9 clothes_pickup10 clothes_pickup11 clothes_pickup12 clothes_pickup13 
VAR_INT mansion_clothes /*safehouse_clothes1*/ safehouse_clothes2 /*safehouse_clothes3 safehouse_clothes4 safehouse_clothes5 safehouse_clothes6 safehouse_clothes7*/ 
VAR_INT safehouse_created1 safehouse_created2 safehouse_created3 safehouse_created4 safehouse_created5 safehouse_created6 safehouse_created7
VAR_INT number_of_packages_collected jason_knife earned_free_python earned_free_body_armour earned_free_chainsaw earned_free_flame_thrower earned_free_laserscope earned_free_minigun earned_free_rocket
VAR_INT bonus_weapons_created1 bonus_weapons_created2 bonus_weapons_created3 bonus_armour1 bonus_gun1 bonus_gun2 bonus_gun3 bonus_gun4 bonus_gun5 bonus_gun6
VAR_INT moneybag1 boomshine1 hockeymask1 coketotem1 shootingtrophy suitbag1 pornoposter1 trophy_created
VAR_INT shit_counter bollox cheat_clothes crap_created 
VAR_INT flamer trophys helibox rubbish1 shovel1 gundocs gash_bag1 gash_bag2 pizzmess1 pizzmess2 pizzbox photos initial_painting new_painting 
VAR_INT clothes_help_flag final_clothes 

// ****************************************Mission Start************************************

SCRIPT_NAME pickups
SET_DEATHARREST_STATE OFF
{
WAIT 100
START_NEW_SCRIPT check_packages



mission_packages_start:

WAIT 0
	
shit_counter ++

bollox = 0
IF bollox = 1 
	CREATE_OBJECT_NO_OFFSET electricgate -1114.1 67.0 10.1 haitian_gate
	CREATE_CLOTHES_PICKUP -384.5 -591.9 25.3 1 mansion_clothes   
	CREATE_CLOTHES_PICKUP 226.4 -1265.6 20.1 1 clothes_pickup1
	CREATE_CLOTHES_PICKUP 97.5 -1133.6 10.4 2 clothes_pickup2
	CREATE_CLOTHES_PICKUP 364.2 1086.1 19.0 3 clothes_pickup3
	CREATE_CLOTHES_PICKUP 106.5 253.0 21.7 4 clothes_pickup4
	CREATE_CLOTHES_PICKUP -1025.2 -429.2 10.8 5 clothes_pickup5 // SCFIX: fix cuban skin pickup location
	//CREATE_CLOTHES_PICKUP -1024.5 -433.9 10.9 5 clothes_pickup5
	CREATE_CLOTHES_PICKUP 405.7 -485.6 12.3 6 clothes_pickup6
	CREATE_CLOTHES_PICKUP 414.3 1042.0 25.4 8 clothes_pickup7
	CREATE_CLOTHES_PICKUP -917.4 885.1 11.0 10 clothes_pickup9
	CREATE_CLOTHES_PICKUP -917.4 885.1 11.0 10 clothes_pickup10
	CREATE_CLOTHES_PICKUP -917.4 885.1 11.0 10 clothes_pickup11
	CREATE_CLOTHES_PICKUP -917.4 885.1 11.0 10 clothes_pickup12
	CREATE_CLOTHES_PICKUP 465.3 -57.4 15.7 7 clothes_pickup13
	CREATE_CLOTHES_PICKUP -917.4 885.1 11.0 10 clothes_pickup8
	//CREATE_CLOTHES_PICKUP 414.3 1042.0 25.4 8 safehouse_clothes1
	CREATE_CLOTHES_PICKUP 414.3 1042.0 25.4 8 safehouse_clothes2
	//CREATE_CLOTHES_PICKUP 414.3 1042.0 25.4 8 safehouse_clothes3
	//CREATE_CLOTHES_PICKUP 414.3 1042.0 25.4 8 safehouse_clothes4
	//CREATE_CLOTHES_PICKUP 414.3 1042.0 25.4 8 safehouse_clothes5
	//CREATE_CLOTHES_PICKUP 414.3 1042.0 25.4 8 safehouse_clothes6
	//CREATE_CLOTHES_PICKUP 414.3 1042.0 25.4 8 safehouse_clothes7
	CREATE_CLOTHES_PICKUP -1200.3 -322.9 10.9 11 starting_tracksuit
	CREATE_CLOTHES_PICKUP -382.6 -585.9 25.3 12 final_clothes
ENDIF
   

/////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////hotel room trophys/////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
IF shit_counter = 1 
	IF IS_PLAYER_PLAYING player1
		IF flag_player_in_hotel = 1
			IF trophy_created = 0 
				IF flag_counter_mission2_passed = 1 
					CREATE_OBJECT_NO_OFFSET moneybag 228.934 -1269.593 20.228 moneybag1
				ENDIF
			   	IF flag_phil_mission2_passed = 1
					CREATE_OBJECT_NO_OFFSET boomshine 228.934 -1269.593 20.228 boomshine1
				ENDIF
				IF flag_bankjob_mission4_passed = 1
				 	CREATE_OBJECT_NO_OFFSET mask 228.934 -1269.593 20.228 hockeymask1
				ENDIF
				IF flag_baron_mission5_passed = 1
					CREATE_OBJECT_NO_OFFSET coke_voodoo 228.934 -1269.593 20.228 coketotem1
				ENDIF
				IF flag_bankjob_mission2_passed = 1
					CREATE_OBJECT_NO_OFFSET trophy1 228.934 -1269.593 20.228 shootingtrophy
				ENDIF
			   	IF flag_lawyer_mission1_passed = 1
					CREATE_OBJECT_NO_OFFSET sutibag 228.934 -1269.593 20.228 suitbag1
			   	ENDIF
			   	IF flag_porn_mission4_passed = 1
					CREATE_OBJECT_NO_OFFSET pornposters 228.934 -1269.593 20.228 pornoposter1
			   	ENDIF
				trophy_created = 1
			ENDIF
		ELSE
			IF trophy_created = 1
				DELETE_OBJECT moneybag1  
				DELETE_OBJECT boomshine1  
				DELETE_OBJECT hockeymask1  
				DELETE_OBJECT coketotem1  
				DELETE_OBJECT shootingtrophy  
				DELETE_OBJECT suitbag1  
				DELETE_OBJECT pornoposter1
				trophy_created = 0
			ENDIF 
		ENDIF
	
		IF flag_player_in_mansion = 1
			IF crap_created = 0 
				IF flag_protect_mission1_passed = 0
					CREATE_OBJECT_NO_OFFSET frame1 -378.394 -583.35 27.078 initial_painting 
				ELSE
					CREATE_OBJECT_NO_OFFSET frame1damaged -378.374 -583.35 27.078 new_painting
				ENDIF 

				IF earned_free_flame_thrower = 1
					CREATE_OBJECT_NO_OFFSET flame_tins -373.306 -593.374 25.369 flamer 
				ENDIF
				
				IF mm_mission_passed_once = 1
					IF flag_kickstart_passed_1stime = 1
						IF done_ovalring_progress = 1 
							CREATE_OBJECT_NO_OFFSET trophies -408.907 -560.001 20.23 trophys
						ENDIF
					ENDIF
				ENDIF
				
				IF flag_sergio_mission2_passed = 1
					CREATE_OBJECT_NO_OFFSET heli_box -401.955 -566.672 19.234 helibox 
				ENDIF
			
				IF flag_pizza_mission_passed = 1 
					CREATE_OBJECT_NO_OFFSET pizza_box1 -406.211 -559.996 18.654 pizzbox
				ENDIF
				
				IF flag_porn_mission4_passed = 1
					CREATE_OBJECT_NO_OFFSET pizza_mess -383.088 -556.169 18.95 pizzmess1 
					CREATE_OBJECT_NO_OFFSET pizza_mess2 -385.024 -570.197 21.58 pizzmess2 
					CREATE_OBJECT_NO_OFFSET man_rubbish03 -379.201 -568.813 20.695 rubbish1 
					CREATE_OBJECT_NO_OFFSET gash_bags1 -408.239 -563.1 19.054 gash_bag1
					CREATE_OBJECT_NO_OFFSET gashbags2 -383.019 -596.235 25.037 gash_bag2 
				ENDIF

				IF flag_porn_mission3_passed = 1
					CREATE_OBJECT_NO_OFFSET Poloroids -374.306 -593.35 26.475 photos
				ENDIF

				IF flag_bankjob_mission4_passed = 1 
					CREATE_OBJECT_NO_OFFSET gun_docs -381.008 -594.382 25.389 gundocs
				ENDIF  
			
				IF flag_sergio_mission3_passed = 1
					CREATE_OBJECT_NO_OFFSET shovel -375.566 -555.54 19.15 shovel1
				ENDIF 
 				crap_created = 1
			ENDIF
		ELSE
			IF crap_created = 1 
				DELETE_OBJECT flamer
				DELETE_OBJECT trophys
				DELETE_OBJECT helibox
				DELETE_OBJECT rubbish1
				DELETE_OBJECT shovel1
				DELETE_OBJECT gundocs
				DELETE_OBJECT gash_bag1
				DELETE_OBJECT gash_bag2
				DELETE_OBJECT pizzmess1
				DELETE_OBJECT pizzmess2
				DELETE_OBJECT pizzbox
				DELETE_OBJECT photos
				DELETE_OBJECT initial_painting
				DELETE_OBJECT new_painting
				crap_created = 0
			ENDIF
		ENDIF
	ENDIF
ENDIF 

/*
//IF HAS_SONY_CD_BEEN_READ 1
	//special cd
	//METAL (SPECIAL)
	IF clothes10_created = 0
		CREATE_CLOTHES_PICKUP 271.0 -1314.3 11.0 11 clothes_pickup10
		PRINT_HELP ( PICK1 ) //Coveralls outfit delivered to Tooled up in The North Point Mall.
		clothes10_created = 1
	ENDIF 
	//ROMANTIC (SPECIAL)
	IF clothes11_created = 0
		CREATE_CLOTHES_PICKUP 271.0 -1317.3 11.0 12 clothes_pickup11
		PRINT_HELP ( PICK1 ) //Coveralls outfit delivered to Tooled up in The North Point Mall.
		clothes11_created = 1
	ENDIF 
	//MC TOMMY (SPECIAL)
	IF clothes12_created = 0
		CREATE_CLOTHES_PICKUP 271.0 -1320.3 11.0 13 clothes_pickup12
		PRINT_HELP ( PICK1 ) //Coveralls outfit delivered to Tooled up in The North Point Mall.
		clothes12_created = 1
	ENDIF
//ENDIF 
*/

IF shit_counter = 2 
	IF flag_cell_nation = 0 
		
		IF mansion_clothes_created = 1
			IF HAS_PICKUP_BEEN_COLLECTED mansion_clothes
				GOSUB changing_clothes_part1
				IF IS_PLAYER_PLAYING player1 
					UNDRESS_CHAR scplayer player
					ADD_MONEY_SPENT_ON_CLOTHES 50
				ENDIF
				GOSUB changing_clothes_part2
			ENDIF
		ENDIF
		
		IF HAS_PICKUP_BEEN_COLLECTED starting_tracksuit
			GOSUB changing_clothes_part1
			IF IS_PLAYER_PLAYING player1 
				UNDRESS_CHAR scplayer play11
				ADD_MONEY_SPENT_ON_CLOTHES 50
			ENDIF
			GOSUB changing_clothes_part2
		ENDIF
		
		IF created_final_shirt = 1	
			IF HAS_PICKUP_BEEN_COLLECTED final_clothes
				GOSUB changing_clothes_part1
				IF IS_PLAYER_PLAYING player1 
					UNDRESS_CHAR scplayer play12
					ADD_MONEY_SPENT_ON_CLOTHES 120
				ENDIF
				GOSUB changing_clothes_part2
			ENDIF
		ENDIF
		
		
		/*
		IF safehouse_created1 = 1
			IF HAS_PICKUP_BEEN_COLLECTED safehouse_clothes1
				GOSUB changing_clothes_part1
				IF IS_PLAYER_PLAYING player1 
					UNDRESS_CHAR scplayer player
					ADD_MONEY_SPENT_ON_CLOTHES 50
				ENDIF
				GOSUB changing_clothes_part2
			ENDIF
		ENDIF
		*/
		IF safehouse_created2 = 1
			IF HAS_PICKUP_BEEN_COLLECTED safehouse_clothes2
				GOSUB changing_clothes_part1
				IF IS_PLAYER_PLAYING player1 
					UNDRESS_CHAR scplayer player
					ADD_MONEY_SPENT_ON_CLOTHES 50
				ENDIF
				GOSUB changing_clothes_part2
			ENDIF
		ENDIF
		/*
		IF safehouse_created3 = 1
			IF HAS_PICKUP_BEEN_COLLECTED safehouse_clothes3
				GOSUB changing_clothes_part1
				IF IS_PLAYER_PLAYING player1 
					UNDRESS_CHAR scplayer player
					ADD_MONEY_SPENT_ON_CLOTHES 50
				ENDIF
				GOSUB changing_clothes_part2
			ENDIF
		ENDIF
		IF safehouse_created4 = 1
			IF HAS_PICKUP_BEEN_COLLECTED safehouse_clothes4
				GOSUB changing_clothes_part1
				IF IS_PLAYER_PLAYING player1 
					UNDRESS_CHAR scplayer player
					ADD_MONEY_SPENT_ON_CLOTHES 50
				ENDIF
				GOSUB changing_clothes_part2
			ENDIF
		ENDIF
		IF safehouse_created5 = 1
			IF HAS_PICKUP_BEEN_COLLECTED safehouse_clothes5
				GOSUB changing_clothes_part1
				IF IS_PLAYER_PLAYING player1 
					UNDRESS_CHAR scplayer player
					ADD_MONEY_SPENT_ON_CLOTHES 50
				ENDIF
				GOSUB changing_clothes_part2
			ENDIF
		ENDIF
		IF safehouse_created6 = 1
			IF HAS_PICKUP_BEEN_COLLECTED safehouse_clothes6
				GOSUB changing_clothes_part1
				IF IS_PLAYER_PLAYING player1 
					UNDRESS_CHAR scplayer player
					ADD_MONEY_SPENT_ON_CLOTHES 50
				ENDIF
				GOSUB changing_clothes_part2
			ENDIF
		ENDIF
		*/
	ENDIF
ENDIF


IF shit_counter = 3 
	IF flag_cell_nation = 0 
		/*
		IF safehouse_created7 = 1
			IF HAS_PICKUP_BEEN_COLLECTED safehouse_clothes7
				GOSUB changing_clothes_part1
				IF IS_PLAYER_PLAYING player1 
					UNDRESS_CHAR scplayer player
					ADD_MONEY_SPENT_ON_CLOTHES 50
				ENDIF
				GOSUB changing_clothes_part2
			ENDIF
		ENDIF
		*/
		IF hotel_clothes_created = 1
			IF HAS_PICKUP_BEEN_COLLECTED clothes_pickup1
				GOSUB changing_clothes_part1
				IF IS_PLAYER_PLAYING player1 
					UNDRESS_CHAR scplayer player
					ADD_MONEY_SPENT_ON_CLOTHES 50
				ENDIF
				GOSUB changing_clothes_part2
			ENDIF
		ENDIF

		IF clothes2_created = 1
			IF HAS_PICKUP_BEEN_COLLECTED clothes_pickup2
				GOSUB changing_clothes_part1
				IF IS_PLAYER_PLAYING player1 
					UNDRESS_CHAR scplayer player2
					ADD_MONEY_SPENT_ON_CLOTHES 100
				ENDIF
				GOSUB changing_clothes_part2
			ENDIF
		ENDIF

		IF clothes3_created = 1
			IF HAS_PICKUP_BEEN_COLLECTED clothes_pickup3
				GOSUB changing_clothes_part1
				IF IS_PLAYER_PLAYING player1 
					UNDRESS_CHAR scplayer player3
					ADD_MONEY_SPENT_ON_CLOTHES 80
				ENDIF
				GOSUB changing_clothes_part2
			ENDIF
		ENDIF

		IF clothes4_created = 1
			IF HAS_PICKUP_BEEN_COLLECTED clothes_pickup4
				GOSUB changing_clothes_part1
				IF IS_PLAYER_PLAYING player1 
					UNDRESS_CHAR scplayer player4
					ADD_MONEY_SPENT_ON_CLOTHES 40
				ENDIF
				GOSUB changing_clothes_part2
			ENDIF
		ENDIF
		IF clothes5_created = 1
			IF HAS_PICKUP_BEEN_COLLECTED clothes_pickup5
				GOSUB changing_clothes_part1
				IF IS_PLAYER_PLAYING player1 
					UNDRESS_CHAR scplayer player5
					ADD_MONEY_SPENT_ON_CLOTHES 70
				ENDIF
				GOSUB changing_clothes_part2
			ENDIF
		ENDIF

		IF clothes6_created = 1
			IF HAS_PICKUP_BEEN_COLLECTED clothes_pickup6
				GOSUB changing_clothes_part1
				IF IS_PLAYER_PLAYING player1 
					UNDRESS_CHAR scplayer player6
					ADD_MONEY_SPENT_ON_CLOTHES 90
				ENDIF
				GOSUB changing_clothes_part2
			ENDIF
		ENDIF
	ENDIF
ENDIF


IF shit_counter = 4 
	IF flag_cell_nation = 0 
		
		IF clothes7_created = 1
			IF HAS_PICKUP_BEEN_COLLECTED clothes_pickup7
				GOSUB changing_clothes_part1
				IF IS_PLAYER_PLAYING player1 
					UNDRESS_CHAR scplayer player8
					ADD_MONEY_SPENT_ON_CLOTHES 120
				ENDIF
				GOSUB changing_clothes_part2
			ENDIF
		ENDIF

		IF clothes8_created = 1
			IF HAS_PICKUP_BEEN_COLLECTED clothes_pickup8
				GOSUB changing_clothes_part1
				IF IS_PLAYER_PLAYING player1 
					UNDRESS_CHAR scplayer player9
					ADD_MONEY_SPENT_ON_CLOTHES 30
				ENDIF
				GOSUB changing_clothes_part2
			ENDIF
		ENDIF

		IF clothes9_created = 1
			IF HAS_PICKUP_BEEN_COLLECTED clothes_pickup9
				GOSUB changing_clothes_part1
				IF IS_PLAYER_PLAYING player1 
					UNDRESS_CHAR scplayer play10
					ADD_MONEY_SPENT_ON_CLOTHES 100
				ENDIF
				GOSUB changing_clothes_part2
			ENDIF
		ENDIF

		/*
		IF clothes10_created = 1
			IF HAS_PICKUP_BEEN_COLLECTED clothes_pickup10
				GOSUB changing_clothes_part1
				IF IS_PLAYER_PLAYING player1 
					UNDRESS_CHAR scplayer play11
				ENDIF
				GOSUB changing_clothes_part2
			ENDIF
		ENDIF

		IF clothes11_created = 1
			IF HAS_PICKUP_BEEN_COLLECTED clothes_pickup11
				GOSUB changing_clothes_part1
				IF IS_PLAYER_PLAYING player1 
					UNDRESS_CHAR scplayer play12
				ENDIF
				GOSUB changing_clothes_part2
			ENDIF
		ENDIF

		IF clothes12_created = 1
			IF HAS_PICKUP_BEEN_COLLECTED clothes_pickup12
				GOSUB changing_clothes_part1
				IF IS_PLAYER_PLAYING player1 
					UNDRESS_CHAR scplayer play13
				ENDIF
				GOSUB changing_clothes_part2
			ENDIF
		ENDIF
		*/
		IF clothes13_created = 1
			IF HAS_PICKUP_BEEN_COLLECTED clothes_pickup13
				GOSUB changing_clothes_part1
				IF IS_PLAYER_PLAYING player1 
					UNDRESS_CHAR scplayer player7
					ADD_MONEY_SPENT_ON_CLOTHES 120
				ENDIF
				GOSUB changing_clothes_part2
			ENDIF
		ENDIF
	ENDIF
ENDIF










/////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////package pickups////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
//mansion
IF shit_counter = 5 
	IF IS_PLAYER_PLAYING player1
		IF flag_baron_mission5_passed = 1
			IF IS_PLAYER_IN_ZONE player1 STARI
				IF bonus_weapons_created1 = 0
					IF earned_free_body_armour = 1
						CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW -314.7 -551.2 10.3 bonus_armour1 
					ENDIF
				
					IF earned_free_chainsaw = 1
						CREATE_PICKUP chnsaw PICKUP_ON_STREET_SLOW -310.7 -551.2 10.3 bonus_gun1  
					ENDIF
				
					IF earned_free_python = 1
						CREATE_PICKUP_WITH_AMMO python PICKUP_ON_STREET_SLOW 24 -306.7 -551.2 10.3 bonus_gun2
					ENDIF
				
					IF earned_free_flame_thrower = 1
						CREATE_PICKUP_WITH_AMMO flame PICKUP_ON_STREET_SLOW 60 -302.7 -551.2 10.3 bonus_gun3 
					ENDIF
					
					IF earned_free_laserscope = 1
						CREATE_PICKUP_WITH_AMMO laser PICKUP_ON_STREET_SLOW 28 -298.7 -551.2 10.3 bonus_gun4
					ENDIF
				    
				    IF earned_free_minigun = 1
						CREATE_PICKUP_WITH_AMMO minigun PICKUP_ON_STREET_SLOW 500 -294.7 -551.2 10.3 bonus_gun5
					ENDIF
					
					IF earned_free_rocket = 1
						CREATE_PICKUP_WITH_AMMO rocketla PICKUP_ON_STREET_SLOW 8 -290.7 -551.2 10.3 bonus_gun6
					ENDIF

					bonus_weapons_created1 = 1
				ENDIF
			ELSE	
				IF bonus_weapons_created1 = 1
					GOSUB remove_bonus_pickups
					bonus_weapons_created1 = 0
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF


IF shit_counter = 6 
	IF IS_PLAYER_PLAYING player1
	//ocean drive hotel
		IF IS_PLAYER_IN_ZONE player1 BEACH1   
			IF flag_player_in_hotel = 1 
				IF bonus_weapons_created2 = 0
					IF earned_free_body_armour = 1
						CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 214.2 -1275.7 19.2 bonus_armour1 
					ENDIF
				
					IF earned_free_chainsaw = 1
						CREATE_PICKUP chnsaw PICKUP_ON_STREET_SLOW  210.2 -1274.7 19.2 bonus_gun1  
					ENDIF

					IF earned_free_python = 1
						CREATE_PICKUP_WITH_AMMO python PICKUP_ON_STREET_SLOW 24 206.2 -1273.7 19.2 bonus_gun2
					ENDIF
				
					IF earned_free_flame_thrower = 1
						CREATE_PICKUP_WITH_AMMO flame PICKUP_ON_STREET_SLOW 60 224.2 -1273.1 19.2 bonus_gun3 
					ENDIF
					
					IF earned_free_laserscope = 1
						CREATE_PICKUP_WITH_AMMO laser PICKUP_ON_STREET_SLOW 28 228.2 -1279.2 19.2 bonus_gun4
					ENDIF
				    
				    IF earned_free_minigun = 1
						CREATE_PICKUP_WITH_AMMO minigun PICKUP_ON_STREET_SLOW 500 226.0 -1268.6 20.1 bonus_gun5
					ENDIF
					
					IF earned_free_rocket = 1
						CREATE_PICKUP_WITH_AMMO rocketla PICKUP_ON_STREET_SLOW 8 231.7 -1264.4 20.1 bonus_gun6
					ENDIF

					bonus_weapons_created2 = 1
				ENDIF
			ENDIF
		ELSE	
			IF bonus_weapons_created2 = 1
				GOSUB remove_bonus_pickups
				bonus_weapons_created2 = 0
			ENDIF
		ENDIF
	ENDIF
ENDIF


IF shit_counter = 7 
	IF IS_PLAYER_PLAYING player1
	//Hyman Condo
		IF IS_PLAYER_IN_ZONE player1 DTOWN   
			IF Hyman_condo_bought = 1 
				IF bonus_weapons_created3 = 0
					IF earned_free_body_armour = 1
						CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW -813.1 1344.7 66.4 bonus_armour1 
					ENDIF
					
					IF earned_free_chainsaw = 1
						CREATE_PICKUP chnsaw PICKUP_ON_STREET_SLOW -817.1 1344.7 66.4 bonus_gun1  
					ENDIF

					IF earned_free_python = 1
						CREATE_PICKUP_WITH_AMMO python PICKUP_ON_STREET_SLOW 24 -821.1 1344.7 66.4 bonus_gun2
					ENDIF
				
					IF earned_free_flame_thrower = 1
						CREATE_PICKUP_WITH_AMMO flame PICKUP_ON_STREET_SLOW 60 -825.1 1344.7 66.4 bonus_gun3 
					ENDIF
					
					IF earned_free_laserscope = 1
						CREATE_PICKUP_WITH_AMMO laser PICKUP_ON_STREET_SLOW 28 -830.1 1344.7 66.4 bonus_gun4
					ENDIF
				    
				    IF earned_free_minigun = 1
						CREATE_PICKUP_WITH_AMMO minigun PICKUP_ON_STREET_SLOW 500 -833.1 1344.7 66.4 bonus_gun5
					ENDIF
					
					IF earned_free_rocket = 1
						CREATE_PICKUP_WITH_AMMO rocketla PICKUP_ON_STREET_SLOW 8 -839.0 1351.6 66.4 bonus_gun6
					ENDIF

					bonus_weapons_created3 = 1
				ENDIF
			ENDIF
		ELSE	
			IF bonus_weapons_created3 = 1
				GOSUB remove_bonus_pickups
				bonus_weapons_created3 = 0
			ENDIF
		ENDIF
	ENDIF
ENDIF

//warping player to top of lift
IF shit_counter = 8 
	IF IS_PLAYER_PLAYING player1
		IF flag_porn_mission4_passed = 1
			IF IS_PLAYER_IN_ZONE player1 DTOWN
				IF IS_PLAYER_ON_ANY_BIKE player1
					GOSUB warp1
				ELSE
					IF IS_PLAYER_ON_FOOT player1
						GOSUB warp1	
					ENDIF
				ENDIF

				IF IS_PLAYER_ON_ANY_BIKE player1
					GOSUB warp2
				ELSE
					IF IS_PLAYER_ON_FOOT player1
						GOSUB warp2
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF IS_PLAYER_PLAYING player1
		IF IS_PLAYER_IN_ZONE player1 DTOWN
			IF IS_PLAYER_ON_ANY_BIKE player1
				GOSUB warp5
			ELSE
				IF IS_PLAYER_ON_FOOT player1
					GOSUB warp5	
				ENDIF
			ENDIF

			IF IS_PLAYER_ON_ANY_BIKE player1
				GOSUB warp6
			ELSE
				IF IS_PLAYER_ON_FOOT player1
					GOSUB warp6
				ENDIF
			ENDIF
		ENDIF
	ENDIF

ENDIF


//warping player to top of lift
IF shit_counter = 9 
	IF IS_PLAYER_PLAYING player1
		IF Hyman_condo_bought = 1
			IF IS_PLAYER_IN_ZONE player1 DTOWN
				IF IS_PLAYER_ON_ANY_BIKE player1
					GOSUB warp3
				ELSE
					IF IS_PLAYER_ON_FOOT player1
						GOSUB warp3	  
					ENDIF
				ENDIF

				IF IS_PLAYER_ON_ANY_BIKE player1
					GOSUB warp4
				ELSE
					IF IS_PLAYER_ON_FOOT player1
						GOSUB warp4
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF shit_counter > 9
	shit_counter = 0
ENDIF


GOTO mission_packages_start 
}
MISSION_END


cloth1:
{
SCRIPT_NAME cloth1
WAIT 5000 
PRINT_HELP ( CLOTH2 ) //Street outfit delivered to safehouse.

WAIT 10000
PRINT_HELP ( CLOTH1 ) //Soiree outfit delivered to Rafaels on Ocean Beach.
TERMINATE_THIS_SCRIPT
}

cloth2:
{
SCRIPT_NAME cloth2
WAIT 5000 
PRINT_HELP HELP25 //You can now take jobs from Avery Carrington.

WAIT 10000
PRINT_HELP ( CLOTH3 ) //Coveralls outfit delivered to Tooled Up in The North Point Mall.
TERMINATE_THIS_SCRIPT
}

cloth3:
{
SCRIPT_NAME cloth3
WAIT 5000 
PRINT_HELP ( CLOTH4 ) //Country Club outfit delivered to The Golf Club in Leafs Links.
TERMINATE_THIS_SCRIPT
}

cloth4:
{
SCRIPT_NAME cloth4
WAIT 5000 
PRINT_HELP ( CLOTH5 ) //Havana outfit delivered to Little Havana Streetwear in Little Havana.
TERMINATE_THIS_SCRIPT
}

cloth5:
{
SCRIPT_NAME cloth5
WAIT 5000 
PRINT_HELP ( CLOTH6 ) //Cop outfit delivered to Police Station on Washington Beach.
TERMINATE_THIS_SCRIPT
}

cloth6:
{
SCRIPT_NAME cloth6
WAIT 5000 
PRINT_HELP ( CLOTH7 ) //Casual outfit delivered to Gash in The North Point Mall.
TERMINATE_THIS_SCRIPT
}

cloth7:
{
SCRIPT_NAME cloth7
WAIT 20000 
PRINT_HELP ( CLOTH8 ) //Mr Vercetti outfit delivered to Collar & Cuffs on Ocean Beach.
TERMINATE_THIS_SCRIPT
}

cloth8:
{
SCRIPT_NAME cloth8
WAIT 5000 
PRINT_HELP ( CLOTH9 ) //Tracksuit outfit delivered to Jockspot in Downtown.
TERMINATE_THIS_SCRIPT
}

cloth9:
{
SCRIPT_NAME cloth9
WAIT 5000 
PRINT_HELP ( CLOTH10 ) //Bank Job outfit delivered to Malibu Club in Vice Point.
TERMINATE_THIS_SCRIPT
}

check_packages:
{

	SCRIPT_NAME PACKAGE

	WAIT 500

	GET_COLLECTABLE1S_COLLECTED	number_of_packages_collected

	WHILE number_of_packages_collected < 10
		WAIT 500
		GET_COLLECTABLE1S_COLLECTED	number_of_packages_collected
	ENDWHILE
		
	PLAYER_MADE_PROGRESS 1
	PRINT_HELP ( PICK1 ) //Body Armour delivered to safe houses!
	earned_free_body_armour = 1


	WHILE number_of_packages_collected < 20
		WAIT 500
		GET_COLLECTABLE1S_COLLECTED	number_of_packages_collected
	ENDWHILE

	PLAYER_MADE_PROGRESS 1
	PRINT_HELP ( PICK3 ) //Chainsaw delivered to safe houses
	earned_free_chainsaw = 1
	
	WHILE number_of_packages_collected < 30
		WAIT 500
		GET_COLLECTABLE1S_COLLECTED	number_of_packages_collected
	ENDWHILE

	PLAYER_MADE_PROGRESS 1
	PRINT_HELP ( PICK2 ) //Python delivered to safe houses!
	earned_free_python = 1


	WHILE number_of_packages_collected < 40
		WAIT 500
		GET_COLLECTABLE1S_COLLECTED	number_of_packages_collected
	ENDWHILE

	PLAYER_MADE_PROGRESS 1
	PRINT_HELP ( PICK4 ) //Flame Thrower delivered to safe houses!
	earned_free_flame_thrower = 1


	WHILE number_of_packages_collected < 50
		WAIT 500
		GET_COLLECTABLE1S_COLLECTED	number_of_packages_collected
	ENDWHILE

	PLAYER_MADE_PROGRESS 1
	PRINT_HELP ( PICK5 ) //Laser Scope delivered to safe houses!
	earned_free_laserscope = 1


	WHILE number_of_packages_collected < 60
		WAIT 500
		GET_COLLECTABLE1S_COLLECTED	number_of_packages_collected
	ENDWHILE

	PLAYER_MADE_PROGRESS 1
	PRINT_HELP ( PICK6 ) //Minigun delivered to safe houses!
    earned_free_minigun = 1


	WHILE number_of_packages_collected < 70
		WAIT 500
		GET_COLLECTABLE1S_COLLECTED	number_of_packages_collected
	ENDWHILE

	PLAYER_MADE_PROGRESS 1
	PRINT_HELP ( PICK7 ) //Rocket Launcher delivered to safe houses!
	earned_free_rocket = 1


	WHILE number_of_packages_collected < 80
		WAIT 500
		GET_COLLECTABLE1S_COLLECTED	number_of_packages_collected
	ENDWHILE

	PLAYER_MADE_PROGRESS 1
	PRINT_HELP ( PICK8 ) //Sea Sparrow now available from the Mansion!
	//CREATE_CAR_GENERATOR -379.0 -632.1 10.2 187.2 seaspar -1 -1 0 0 0 0 10000 gen_car148 //behind mansion
	SWITCH_CAR_GENERATOR gen_car148 101


	WHILE number_of_packages_collected < 90
		WAIT 500
		GET_COLLECTABLE1S_COLLECTED	number_of_packages_collected
	ENDWHILE

	PLAYER_MADE_PROGRESS 1
	PRINT_HELP ( PICK9 ) //Tank now available from the Army Barracks!
	//CREATE_CAR_GENERATOR -1720.3 -239.6 14.8 92.0 rhino -1 -1 0 0 0 0 10000 gen_car149 //at army barracks
	SWITCH_CAR_GENERATOR gen_car149 101


	WHILE number_of_packages_collected < 100
		WAIT 500
		GET_COLLECTABLE1S_COLLECTED	number_of_packages_collected
	ENDWHILE

	WAIT 5000
	PLAYER_MADE_PROGRESS 1
	
	IF hunter_created = 0
		PRINT_HELP ( PICK10 ) //Hunter now available from the Army Barracks!
		//CREATE_CAR_GENERATOR -1681.2 -103.7 14.7 180.0 hunter -1 -1 0 0 0 0 10000 gen_car150 //at army barracks
		SWITCH_CAR_GENERATOR gen_car150 101
		hunter_created = 1
	ELSE
		PRINT_HELP ( APACHE )
		//CREATE_CAR_GENERATOR -72.4 -1607.9 12.7 0.0 hunter -1 -1 0 0 0 0 10000 south_beach_hunter //at army barracks
		SWITCH_CAR_GENERATOR south_beach_hunter 101
	ENDIF

	TERMINATE_THIS_SCRIPT
}



remove_bonus_pickups:
{
REMOVE_PICKUP bonus_armour1
REMOVE_PICKUP bonus_gun1      
REMOVE_PICKUP bonus_gun2 
REMOVE_PICKUP bonus_gun3
REMOVE_PICKUP bonus_gun4
REMOVE_PICKUP bonus_gun5
REMOVE_PICKUP bonus_gun6
}
RETURN



changing_clothes_part1:
{
flag_cell_nation = 1
IF IS_PLAYER_PLAYING player1
	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT
	WHILE GET_FADING_STATUS
		WAIT 0
	ENDWHILE
ELSE
	flag_cell_nation = 0
ENDIF

IF IS_PLAYER_PLAYING player1
	SET_EVERYONE_IGNORE_PLAYER player1 ON
  	SET_PLAYER_CONTROL player1 OFF
ELSE
	flag_cell_nation = 0
ENDIF
}
RETURN 

	
changing_clothes_part2:	
{
IF IS_PLAYER_PLAYING player1
	LOAD_ALL_MODELS_NOW
	IF IS_PLAYER_PLAYING player1
		DRESS_CHAR scplayer
	ENDIF
	SET_EVERYONE_IGNORE_PLAYER player1 OFF
	IF NOT IS_WANTED_LEVEL_GREATER player1 2
		CLEAR_WANTED_LEVEL player1
	ENDIF
  	SET_PLAYER_CONTROL player1 ON
	flag_cell_nation = 0
	DO_FADE 500 FADE_IN
	IF clothes_help_flag = 0
		PRINT_HELP ( CLT_HL2 ) //When a Clothes Pickup is collected, a one star or two star wanted level will be cleared.
		clothes_help_flag = 1
	ELSE
		PRINT_HELP ( CLOHELP ) //Clean Clothes!!
	ENDIF
ELSE
	flag_cell_nation = 0
ENDIF
}
RETURN

warp1:
{
IF LOCATE_PLAYER_ANY_MEANS_3D player1 -557.1 782.1 21.8 2.5 2.5 2.5 FALSE
	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT
	WHILE GET_FADING_STATUS
		WAIT 0
	ENDWHILE

	IF IS_PLAYER_PLAYING player1
		SET_PLAYER_COORDINATES player1 -556.1 787.8 96.5 
		SET_PLAYER_HEADING player1 100.5
		SET_CAMERA_IN_FRONT_OF_PLAYER
	ENDIF

	DO_FADE 500 FADE_IN
ENDIF
}
RETURN 


warp2:
{
IF LOCATE_PLAYER_ANY_MEANS_3D player1 -551.8 787.4 97.5 2.5 2.5 2.5 FALSE
	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT
	WHILE GET_FADING_STATUS
		WAIT 0
	ENDWHILE

	IF IS_PLAYER_PLAYING player1
		SET_PLAYER_COORDINATES player1 -562.1 782.0 21.8 
		SET_PLAYER_HEADING player1 100.5
		SET_CAMERA_IN_FRONT_OF_PLAYER
	ENDIF

	DO_FADE 500 FADE_IN
ENDIF
}
RETURN 

warp3:
{
IF LOCATE_PLAYER_ANY_MEANS_3D player1 -830.9 1312.4 10.5 2.5 2.5 2.5 FALSE
	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT
	WHILE GET_FADING_STATUS
		WAIT 0
	ENDWHILE

	IF IS_PLAYER_PLAYING player1
		SET_PLAYER_COORDINATES player1 -815.0 1353.9 65.4 
		SET_PLAYER_HEADING player1 87.2
		SET_CAMERA_IN_FRONT_OF_PLAYER
	ENDIF

	DO_FADE 500 FADE_IN
ENDIF
}
RETURN 

warp4:
{
IF LOCATE_PLAYER_ANY_MEANS_3D player1 -811.7 1354.2 66.4 2.5 2.5 2.5 FALSE
	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT
	WHILE GET_FADING_STATUS
		WAIT 0
	ENDWHILE

	IF IS_PLAYER_PLAYING player1
		SET_PLAYER_COORDINATES player1 -829.6 1308.8 10.5 
		SET_PLAYER_HEADING player1 200.0
		SET_CAMERA_IN_FRONT_OF_PLAYER
	ENDIF

	DO_FADE 500 FADE_IN
ENDIF
}
RETURN 

warp5:
{
IF LOCATE_PLAYER_ANY_MEANS_3D player1 -410.5 1120.9 10.1 2.5 2.5 2.5 FALSE
	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT
	WHILE GET_FADING_STATUS
		WAIT 0
	ENDWHILE

	IF IS_PLAYER_PLAYING player1
		SET_PLAYER_COORDINATES player1 -446.9 1128.3 55.6 
		SET_PLAYER_HEADING player1 282.0
		SET_CAMERA_IN_FRONT_OF_PLAYER
	ENDIF

	DO_FADE 500 FADE_IN
ENDIF
}
RETURN 

warp6:
{
IF LOCATE_PLAYER_ANY_MEANS_3D player1 -451.1 1128.1 55.6 2.5 2.5 2.5 FALSE
	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT
	WHILE GET_FADING_STATUS
		WAIT 0
	ENDWHILE

	IF IS_PLAYER_PLAYING player1
		SET_PLAYER_COORDINATES player1 -410.5 1117.7 10.0 
		SET_PLAYER_HEADING player1 179.6
		SET_CAMERA_IN_FRONT_OF_PLAYER
	ENDIF

	DO_FADE 500 FADE_IN
ENDIF
}
RETURN 




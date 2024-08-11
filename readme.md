# SCFIX-Miami

SCFIX-Miami aims to provide bugfixes and quality of life improvements to the original scripts. It also restores some of the cut content, but only the type that was cut unintentionally (due to code bug) or something that developers likely forgot to add due to tight deadlines and that doesn't break the plot, characters or game's lore. There's no intent to reuse every bit of unused content for the sake of it, or to recreate cut/rumored missions. Based off of [UndefinifiedMiami](https://github.com/Sergeanur/UndefinifiedMiami).

All changes to the scripts were marked with `SCFIX` comment. Code that is related to the Japanese support had been commented to be compatible with 1.0 version of the game. It's labeled with `SCFIX-JAP` in the code and can be easily restored if you need it.

Currently in beta status.

## Download SCM

Get latest release here: https://github.com/Sergeanur/SCFIX-Miami/releases

## Installation

Replace main.scm inside data directory, but read save files compatibility note below first.

## List of changes

<details><summary>Click here to expand</summary>

Intro:
- Fixed SSU related things in the script
- Added ability to skip the cutscene at lawyer's office (press cross or a sprint key)
- Placed player model in the back seat of the Admiral
- Fixed game crash if the intro Admiral somehow exploded

An Old Friend:
- Fixed SSU related things in the script
- Fix hotel's extra colors resetting after the cutscene

The Party:
- Player's skin would reset to the default one only if wearing Soiree when starting the mission
- Mercedes' line "Do you mind me resting my hand…" would play only if she sits at the front seat
- Increased delay after first "Maybe" from 500 ms to 1000 ms (like the second time)

Back Alley Brawl:
- Fixed "This way" line ending abruptly
- Fix vehicle that you arrived in at Malibu becoming a mission vehicle
- Restored unused Lance's lines about player driving carelessly

Riot:
- Player's skin would reset to the default one only if wearing Coveralls when starting the mission

Treacherous Swine:
- Fix player's ability to move after the cutscene during the black screen
- Fix noticeable model changes for doors
- Fix cutscene skips not working due to not reset variable
- Moved player equipping chainsaw only when the cutscene at Gonzales begins instead of as soon as the player entered the marker
- Mission doesn't require you to be in a vehicle in order to pass it after dropping a wanted level

Mall Shootout:
- Attached mission audio to the French guy

Guardian Angels:
- Fixed Lance asking for help if you shoot him with Tec-9
- Restored unused Lance's line commenting about player shooting at him
- Remove Lance's ped as soon as the outro cutscene starts to avoid his sudden disappearance
- Diaz' Admiral is deleted at the end of the mission
- Diaz' Admiral no longer remains indestructible if the mission is failed

Sir, Yes Sir!:
- Line "Someone's in the tank…" will no longer play if there's no alive soldiers near the tank

All Hands On Deck!:
- Speeder's colors after the mission will now match the colors of the one on the yacht

The Chase:
- Fixed the guy becoming stuck if he falls off the roof. Now he'll find another way to get to the buggy

Phnom Penh '86:
- Fixed "Quentin Vance" line ending abruptly
- Fixed some subtitles being stuck on the screen after the audio is done
- Fixed heli being stuck at the third wave after you killed all the enemies you could
- Fixed possibility of heli being stuck when Tommy should leave the chopper

The Fastest Boat:
- It's not possible to steal the boat before it's lowered anymore
- The boat's colors are saved to be used in the next mission

Supply & Demand:
- Lance can now be seen inside the boat in the beginning of the mission
- Boat's colors will now match the colors from the previous mission
- Fixed "We've got some competition" line not playing at rare occasions
- The area where the Cuban boats spawn is now cleared form other boats
- Restored unused line "Take 'em out" after "We've got some competition"
- Fixed Cuban boats driving themselves if their drivers are dead
- Fixed line "It's time for the Lance Vance dance." overlapping with "I like your style man. Real fresh."
- Restored unused line "We made it! Those other boats ain't VIP class." when you arrive to the boat
- Fixed Cuban boats driving at the same location endlessly if the mission was failed
- Restored the cutscene at the coke deal
- At the drive back to the mansion the Cuban boats will certainly have alive drivers now

Death Row:
- Leave the Malibu doors open when starting this mission
- Utilize unused beat-up Lance model for this mission

Rub Out:
- Fixed use of WAIT command after deatharrest execution as deatharrest might be executed the second time and break the mission cleanup routine

Four Iron:
- Player's skin would reset to the default one only if wearing Country Club when starting the mission
- Disable player controls during Avery's limo arriving cutscene
- Fix HUD showing during Avery's limo arriving cutscene
- Fix 3D coordinates for "Nice ass, baby" not being set properly
- Fix sudden weather switch when the mission ends

Demolition Man:
- Disable player controls during Avery's limo arriving cutscene
- Attach builder's mission audio properly
- Fix HUD turning on in the end of outro cutscene

Two Bit Hit:
- Disable player controls during Avery's limo arriving cutscene

Shakedown:
- Fix mansion extra timecyc colors not turning off after the cutscene
- Add the area name print after the cutscene akin to other places where player is teleported outside of the interior after the cutscene

Bar Brawl:
- Fix mansion extra timecyc colors not turning off after the cutscene
- Add the area name print after the cutscene akin to other places where player is teleported outside of the interior after the cutscene
- Fix cutscene skips not working due to not reset variable

Cop Land:
- Fix noticeable swaps of building models
- Fix location for Cuban clothes pickup after the mission is over
- Make Lance respond to cop threats if player has a wanted level
- Player's skin would reset to the default one only if wearing Cop uniform when starting the mission
- Fix second army guy's accuracy being unset

No Escape?:
- Player's skin will not reset to the default one when starting the mission
- Player's wanted level is cleared when the mission starts
- Cop peds are now created as PEDTYPE_COP and can arrest you
- The alarm will go off at VCPD if the player entered while being wanted
- Cam Jones will respond to cop threats and always run when getting into the vehicle
- Fix location for Cuban clothes pickup after the mission is over

The Shootist:
- Fix double marker when entering the shooting range
- Use the same model for the second shooter as the one in the cutscene
- Fix player retrieving pistol ammo back due to attach logic
- Tidy up bloated tutorial code
- Disable player controls during tutorial
- Fix doubling player ammo after the mission is over

The Driver:
- Fix marker appearing for a split second as the race begins
- Restore unused outro for when the player loses the race

The Job:
- Tidied up a lot of code to fit the new script into 35k bytes limit
- Player's clothes will be reset to default ones if player starts the mission in the Robbery outfit
- Companions won't leave the getaway taxi after entering it on the way to the bank
- Getaway taxi in the beginning of the mission is made fire proof so that companions wouldn't leave the car
- Companions won't die from being hit by the traffic anymore
- Restored unused Hilary line "Yeah, you'll put somebody's eye out" after "For god sake's, Phil. Stop waving that thing around"
- The Securicar at the bank entrance will be removed while the mission is ongoing
- The destination blip at the bank won't be created before the line "I'll drive" anymore at the beginning of the mission
- The robbery cannot be initiated if the player's got a wanted level
- Restored unused lines for when the player became wanted on the way to the bank
- Fixed destination sphere flickering during conversations
- Fix interrupted conversations not being restored properly
- Fix stuck player walking animation in the cutscene after getting out of the taxi
- Fix game softlocking at the cutscene when leaving the taxi because Tommy went a little bit off
- Set Cam's and Phil's health to 200 when the robbery is initiated
- Fix some hostages at the bank not raising their hands up
- Cam will shoot back at the security now
- The alarm will go off if the hostages were provoked
- Dead security guy at the vault will be despawned after going up for the manager to avoid manager being blocked by his body
- "Phil, things still sweet?" dialogue won't initiate if the hostages were provoked before
- "I said nobody move" line wouldn't play if the hostages were provoked already
- Fixed mission sphere disappearing while "I said nobody move" line is playing
- The "I told you not to touch that alarm" sequence wouldn't trigger if the alarm was set off before by provoking the hostages. Instead, it goes straight to "The SWAT will be here any minute"
- Ped that Phil will shoot now spawns before "I told you not to touch that alarm"
- Fixed mission softlock in case the ped whom Phil has to shoot escapes
- Provoked peds won't try to go after Cam if he's down at the vault
- Fix Phil sometimes appearing at random places in a cutscene
- You can't start "Vice City SWAT…" sequence while the hostages are onto you
- The hostages will now start running around when the SWAT storms the building
- Phil will say "Hot damn, here they come" when the SWAT guys enter the building
- Made model swap for bank windows less noticeable
- Phil will say "That's a last of them, GO GO GO" only after all six SWAT members are killed instead of 4 
- "That's a last of them, GO GO GO" line will play only once now
- If after "That's a last of them, GO GO GO" line Cam failed to get downstairs for whatever reason, Tommy will say "Where's Cam? We better go find him"
- Fixed Phil and Cam not crouching after exiting the bank
- Made sure no other cars will interfere in a cutscene after exiting the bank
- SWAT members outside the bank now created as actual cops who could arrest you and won't attack you after you drop your wanted level
- Phil and Cam now always run when you have a wanted level
- Player will be teleported outside Cam's garage if he killed Phil while being inside
- Fixed Player & co. not exiting the vehicle if they didn't arrive in a getaway taxi
- The bank entrance area will be cleared after the mission is passed
- Remove WAIT on cleanup to avoid cleanup not working if you failed the mission+died/got arrested

Boomshine Saigon:
- Made Phil's Patriot fire proof so that he wouldn't leave the car

Spilling the Beans:
- Restored a cutscene of player walking into the Malibu club

Hit the Courier:
- Fixed "You destroyed the plates" mission fail if you kill the courier in the car

Martha's Mug Shot:
- Rewritten bugged camera audio

G-Spotlight:
- Fixed widescreen not working at the "Asset complete" cutscene
- Fixed widescreen not working at the spotlight cutscene if you already stood on the marker when the ladder cutscene played

V.I.P.:
- Fix rival taxi arrow being static due to being recreated every frame
- Fixed mission fail if you drove the VIP on the rival taxi

Sunshine Autos:
- Fix car rewards not being created if the player died before the cutscene could play

Distribution:
- Mission passed music now plays during the asset completed cutscene instead of after
- Player now has to deal 50 deals total instead of in a single go

Stunt Boat Challenge:
- Fixed player being seen in the air after the cutscene
- Rico will always be facing to the front of the boat now
- Changed color of the final blip
- Fixed "You have three minutes to get round the course." message appearing even if you failed the mission already
- Fixed boat randomly driving off in the outro cutscene while the line plays
- Rico and boat are now being deleted right after the outro cutscene instead of becoming stuck
- Gates to the Haitian base will be open after this mission is passed (but closed after passing Cannon Fodder)

Cannon Fodder:
- Made the cutscene of Cubans getting in the car play for 5 seconds instead of 2 seconds
- Fixed ghosts of Cubans coming out of the car after the cutscene ends
- Fixed mission not being failed if you killed more than 1 Cuban during audio playing
- Changed sniper's anim group to a two-handed weapon
- Removed sniper's threat search so that he wouldn't jump off the roof
- Fixed Cubans being able to escape from the sniper in a cutscene by running too far
- Sniper now looks at the targets that he shoots
- Improved pathfinding for the reinforcement Cubans when they are running towards the sides of the gate
- The crate inside a van now placed correctly
- Lines "Tommy, we have proved our manful bravery!" and "Let us steal that van full of drugs and make good our escape!" now have subtitles show as soon as audio plays and are cleared as soon as the playback is finished
- Haitian gates won't be closed if you fail the mission (but will close after the mission is passed)

Juju Scramble:
- Moved interior change for the cutscene before LOAD_SCENE to hide noticeable interior swap
- Fixed mission SWAT attacking the player if he has no wanted level
- Improved SWAT pathfinding for the second briefcase
- Fixed SWAT being unable to pick up the third briefcase
- Fixed "Don't move a muscle, chump!" audio not stopping after the cutscene skip
- Fixed "Don't move a muscle, chump!" cutscene autoskipping if you had cross (or a sprint key) pressed when it started

Dirty Lickin's:
- Re-enabled for German version
- Moved interior change for the cutscene before LOAD_SCENE to hide noticeable interior swap

Trojan Voodoo:
- Fixed cutscene ending after the character animation is over
- Pepe is now created as a Cuban initially and then recreated as a fake golfer later
- Voodoo cars no longer remain fire proof after the mission
- Eternal Haitian hatred towards the player will be removed if the mission is failed
- Haitians at the plant will now shoot back at invading Cubans
- Fake golfer Cubans are now removed after mission
- Made the model swap during the factory explosion more seamless
- The Voodoo that player used to enter the plant can also explode now in the end of the mission
- Voodoo's will only explode in the end of the mission if they remained near the exploding building
- Fixed some prints still showing after the mission is failed
- After passing the mission Cuban population values are restored to those pre-gang war
- Cuban and Haitian don't stop hating each other anymore after this mission is over

Alloy Wheels of Steel:
- Player's skin will be reset to a default one if wearing cop uniform

Messing with the Man:
- Re-enabled for German version

Hog Tied:
- Moved biker's creation in the outro a bit to avoid spawning on screen

Cap the Collector:
- Most of the mission has been rewritten to improve the collectors' AI
- Collectors choose the closest asset as their destination
- Tommy remains angry for the duration of the mission
- Tommy's lines towards the collectors now used more often

Keep Your Friends Close...:
- Fix V blip being doubled with the asset revenue pickup for this mission
- Fix Tommy's gang spawning upon exiting and re-entering the interior (by design no one should spawn)
- Fixed spawn position of Sonny's goons behind the mansion door so that they don't get stuck
- Fixed Tommy gang receiving Tec-9 is the mission is failed
- Fixed half of Tommy gang becoming unarmed after this mission
- Fixed coordinates of V blip for the asset revenue pickup after the mission is passed

Autocide:
- Fix doubled PLAYER_MADE_PROGRESS after mission completion

Loose Ends:
- Replace SLIDE_OBJECT on mission fail to get rid of WAIT after deatharrest

Phone calls:
- Added ability to skip phone calls like in SA
- Fixed player being stuck in a two-handed weapon animation
- Restored a phone call from Kent Paul about the SWAT retirement fund after purchasing the Malibu club
- Restored a phone call from Rosenberg about the asset revenue
- Fixed Steve calling after beating the last mission even if you don't own a film studio
- Restored a phone call from Mercedes after killing Ricardo Diaz
- Fix triple call delay after the phone call from Earnest Kelly
- Fix interior doors closing during phone calls when being inside the interior

Misc:
- Fixed side activity title being shown for a split second for Paramedic, Vigilante, Firefighter or Taxi Driver
- Changed patients' behavior to only run towards stopped ambulance instead of while it's still moving in Paramedic
- Disabled patients spawn at a Hyman Memorial Stadium and a G-Spotlight office for Paramedic
- Capped "Test Track" to $400 max
- Changed "Cone Crazy" rewards to get rid of a huge money abuse. Now the player is rewarded with $400 for every new best time, and $200 for just beating the mission
- Fixed cutscene cleanup for the Cherry Popper Ice Cream Factory purchase cutscene (it keeps going when you skip it)
- Fixed Admiral and Stretch car generators conflicting near Diaz' Mansion
- Fixed Freeway car generator at Mercedes' place
- Fixed Infernus car generator at Starfish Island being spawned inside a locked garage
- Fixed Pizzaboy car generator at Diaz' Mansion
- Added colonel's Speeder car generator near the mansion
- Added unused lines to the strippers in The Pole Position Club
- Implemented a bunch of fixes to address extra colors resetting inside the interiors
- Fixed Malibu club doors visibility in the interior
- Fixed food vendors restoring only up to 100 HP
- Fixed random range for voice lines when buying food
- Fixed Cuban clothes pickup coordinates
- Pizza Boy Mission is now considered complete as soon as you deliver the last pizza on level 10
- Redone Pizza Boy Mission audio to not stall the player
- Synced areas to restrict customer spawn with Paramedic Mission
- Pizza Boy car generator near mansion would activate only after beating Rub Out
- Fixed rampage always selecting Cubans
- Diaz gang won't be chosen for a rampage after beating Rub Out
- Tidy up bloated tutorial code at the shooting range
- Fix colt/pistol model loading at the shooting range
- Fix shop clerk at one of the North Point Mall shops being rotated 180 deg
- Fixed weapons duping at metal detectors when you run out of ammo
- Fixed weapons switching automatically when you pass through a metal detector
- Fixed weapon pickups being created behind the wall at a golf club metal detector
- Restored unused audio at a golf club metal detector when security takes your weapons (due to technical limitations works only when off mission and during the mission Four Iron)
- Improved road traffic at Leaf Links bridge
- Fixed player gaining wanted level when leaving the police department interior
- Fixed taxi driver being able to become your passenger in a Taxi Driver side activity
- Cutscene Kaufman Cab is now being deleted after the Kaufman Cabs purchase cutscene
- Disabled "To enter Ocean View hotel..." message when on mission and after "An Old Friend"
- Improved the position of a bonus Hunter at a south beach
- Health bonus gained from hooker will no longer reset when saving
- Fixed hotel intro marker being invisible after saving in the hotel
- Haitians now hate the player if he wears Cuban outfit
- Fixed Quadruple Insane Stunt
- Fixed being able to see the void behind Robina Cafe when you start any Cuban mission from inside the cafe
- 'Stop in the pink marker' message near hotel wouldn't show anymore if there is no pink marker
- Cubans and Haitians no longer hate each other since the beginning. They start hating each other only after Two Bit Hit
- Fixed SSU for property purchase cutscenes
- Fixed many male peds created as CIVFEMALE
- Fixed cutscene skip not working after certain missions set button_pressed = 2
- Fixed On Mission flag (flag_player_on_mission) sets to prevent any abuse of this flag
- Removed On Mission flag checks in some mission that were meant to bypass compiler errors
- Refactored code bloat created by the Japanese support
</details>

## Save files compatibility

At this point it's incompatible with old save files made with original scm. In future it's possible to come up with a save file converter once a stable release will be decided upon.

## How to compile

You need to get miss2.exe from 3master and then patch the 3master plague out of it.
To patch miss2.exe, put it in `patch` directory and launch **xdelta3.bat**. Now you can use miss2.exe that would produce correct compiled binaries (and is also compatible with Japanese commands).

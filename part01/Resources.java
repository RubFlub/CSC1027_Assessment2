package part01;

public class Resources {
	/**
	 * The maximum amount of months that can be within the system.
	 */
	public static final int MAX_MONTHS = 12;
	
	/**
	 * Menu options.
	 */
	public static final String MAIN_OPTIONS[] = {"Manage Artifacts", "Manage Exhibits", "Manage Annual Schedule", "Exit"};
	public static final String ARTIFACT_OPTIONS[] = {"View All Artifacts", "Search Artifacts", "Add Artifact", "Back to Main Menu"};
	public static final String ARTIFACT_SEARCH_OPTIONS[] = {"Search by ID", "Search by Name", "Search by Type", "Exit"};
	public static final String SELECTED_ARTIFACT_OPTIONS[] = {"Edit Artifact", "Delete Artifact", "Back"};
	public static final String EDIT_ARTIFACT_OPTIONS[] = {"Edit Name", "Edit Type", "Edit Engagement Time", "Edit Sign Text", "Back"};
	public static final String EXHIBIT_OPTIONS[] = {"View All Exhibits", "Search Exhibits", "Add Exhibit", "Back to Main Menu"};
	public static final String EXHIBIT_SEARCH_OPTIONS[] = {"Search by ID", "Search by Name", "Exit"};
	public static final String SELECTED_EXHIBIT_OPTIONS[] = {"Edit Exhibit Name", "View & Modify Route", "Delete Exhibit", "Back"};
	public static final String MODIFY_ROUTE_OPTIONS[] = {"Add Artifact to Route", "Modify Artifact in Route", "Back"};
	public static final String SELECTED_ROUTE_ARTIFACT_OPTIONS[] = {"Edit Artifact", "Change Position of Artifact", "Unassign Artifact", "Back"};
	public static final String SELECTED_SCHEDULE_OPTIONS[] = {"Modify Exhibit Hall 1", "Modify Exhibit Hall 2", "Modify Exhibit Hall 3", "Back"};
	public static final String SELECTED_SCHEDULE_EXHIBIT_OPTIONS[] = {"Set Exhibit", "Unassign Exhibit", "Back"};
	public static final String CONFIRM_OPTIONS[] = {"Yes", "No"};
	
	/**
	 * The names of the initial default exhibits.
	 */
	public static final String INITIAL_EXHIBIT_NAMES[] = {
			"Ancient Egyptian Burial Rituals",
			"The Age of Dinosaurs",
			"The Silk Road",
			"The Art of the Renaissance",
			"Viking Exploration",
			"The Wonders of Ancient Greece",
			"Ancient Rome: Power and Society",
			"Egyptian Temples and Gods",
			"The Medieval Knight",
			"Samurai and Bushido",
			"The American Revolution",
			"The Ancient Maya",
			"The Industrial Revolution",
			"The Impressionist Movement",
			"The Inca Empire",
			"The French Revolution",
			"The Titanic Disaster",
			"The Space Race",
			"The Egyptian Goddess Isis",
			"The Ancient Chinese Empire",
			"Native American Culture and Art",
			"The Golden Age of Piracy",
			"Prehistoric Human Evolution",
			"The Great Wall of China",
			"The Art of Ancient India",
			"The Exploration of Antarctica",
			"The African Kingdoms",
			"The Age of Discovery",
			"The Russian Tsars",
			"The Forbidden City",
			"The World's Great Inventions",
			"The Lost Civilisations",
			"The Evolution of Writing Systems",
			"The Birth of Photography",
			"The History of the Circus",
			"The Art of Puppetry"
	};
	
	/**
	 * Data for the initial default artifacts.
	 */
	public static final Object INITIAL_ARTIFACTS[][] = {
			{"Sarcophagus of a High Priest", ArtifactType.SCULPTURE, 9, "A large stone sarcophagus, intricately carved with Egyptian hieroglyphs and symbols, used to house the remains of a high-ranking priest."},
			{"Mummified Cat", ArtifactType.FOSSIL, 4, "A preserved ancient cat, mummified for religious or ritualistic purposes by the Egyptians."},
			{"Canopic Jars", ArtifactType.SCULPTURE, 8, "Jars used by ancient Egyptians to store and preserve the organs of the deceased during mummification."},
			{"Scroll of the Dead: Book of the Dead Papyrus", ArtifactType.MANUSCRIPT, 7, "An ancient Egyptian text used to guide the soul through the afterlife, often buried with the deceased."},
			{"Golden Amulet of Anubis", ArtifactType.CLOTHING, 8, "A golden charm depicting Anubis, the Egyptian god of the dead, worn as a protective amulet."},
			{"Tyrannosaurus Rex Fossil Skull", ArtifactType.FOSSIL, 10, "The fossilized skull of a T. rex, one of the largest carnivorous dinosaurs from the Late Cretaceous period."},
			{"Triceratops Horn", ArtifactType.FOSSIL, 8, "A fossilized horn from a Triceratops, a herbivorous dinosaur with three distinctive facial horns."},
			{"Fossilized Dinosaur Eggs", ArtifactType.FOSSIL, 4, "Fossilized eggs from prehistoric dinosaurs, offering insights into their reproductive habits."},
			{"Reconstruction of a Brachiosaurus Skeleton", ArtifactType.FOSSIL, 7, "A full-scale model of the Brachiosaurus skeleton, showcasing the long-necked herbivore of the Jurassic period."},
			{"Dinosaur Track Prints", ArtifactType.FOSSIL, 3, "Fossilized footprints left by dinosaurs, providing evidence of their behavior and movement."},
			{"Ancient Silk Textiles", ArtifactType.MATERIAL, 4, "Rare and fragile textiles made from silk, often associated with ancient China and the Silk Road."},
			{"Ceramic Figurines from Central Asia", ArtifactType.SCULPTURE, 10, "Handcrafted ceramic statues from Central Asia, often depicting deities or daily life from ancient cultures."},
			{"A Bronze Scimitar from Persia", ArtifactType.WEAPON, 8, "A finely crafted Persian scimitar made from bronze, designed for both cutting and slashing in combat."},
			{"Carved Jade Pendant from China", ArtifactType.CLOTHING, 4, "A beautifully carved jade pendant, often worn as a symbol of status or spiritual significance in ancient China."},
			{"Maps of the Silk Road Trade Routes", ArtifactType.MANUSCRIPT, 8, "Detailed maps documenting the trade routes of the ancient Silk Road, connecting East and West."},
			{"Leonardo da Vinci’s Sketchbook", ArtifactType.MANUSCRIPT, 8, "The sketchbook of the Renaissance genius, containing drawings, inventions, and artistic concepts."},
			{"Michelangelo’s Marble Sculpture of David (Replica)", ArtifactType.SCULPTURE, 9, "A replica of Michelangelo’s iconic marble sculpture of the biblical hero David, symbolizing Renaissance art."},
			{"Raphael’s Painting, 'The School of Athens'", ArtifactType.PAINTING, 5, "A famous fresco by Raphael, depicting ancient Greek philosophers in a harmonious intellectual gathering."},
			{"Medici Family Portrait", ArtifactType.PAINTING, 7, "A portrait of the influential Medici family, patrons of the arts during the Italian Renaissance."},
			{"Fresco Fragments from the Sistine Chapel", ArtifactType.PAINTING, 6, "Fragments of the frescoes painted by Michelangelo in the Sistine Chapel, depicting biblical scenes."},
			{"Viking Longship Model", ArtifactType.SCULPTURE, 5, "A detailed model of a Viking longship, showcasing the advanced shipbuilding skills of the Norse."},
			{"Sword with Ornate Hilt", ArtifactType.WEAPON, 9, "An intricately designed sword with an ornate hilt, often used by nobility or high-ranking military officers."},
			{"Thor’s Hammer Amulet", ArtifactType.CLOTHING, 8, "A pendant shaped like Mjölnir, the hammer of the Norse god Thor, worn for protection or as a symbol of strength."},
			{"Runestone Inscription", ArtifactType.MANUSCRIPT, 4, "A stone inscribed with runic characters, often used by Vikings for commemoration or to mark territory."},
			{"Viking Helmet with Norse Designs", ArtifactType.CLOTHING, 9, "A helmet adorned with traditional Norse designs, providing both protection and cultural significance."},
			{"Marble Statue of Zeus", ArtifactType.SCULPTURE, 6, "A marble statue representing Zeus, the king of the gods in ancient Greek mythology."},
			{"Athenian Pottery", ArtifactType.SCULPTURE, 8, "Ancient Greek pottery, often decorated with scenes of daily life or mythological figures, from Athens."},
			{"Bronze Helmet from the Battle of Marathon", ArtifactType.CLOTHING, 7, "A bronze helmet worn by a Greek soldier during the Battle of Marathon, a key conflict in the Persian Wars."},
			{"Fragments of the Parthenon Frieze", ArtifactType.SCULPTURE, 5, "Fragments of the Parthenon frieze, depicting scenes from the ancient Greek religious festival Panathenaia."},
			{"Golden Laurel Wreath", ArtifactType.CLOTHING, 3, "A golden wreath shaped like laurel leaves, a symbol of victory and honor in ancient Greece."},
			{"Roman Gladius Sword", ArtifactType.WEAPON, 7, "A short Roman sword used by soldiers, designed for close combat and quick strikes."},
			{"Bust of Julius Caesar", ArtifactType.SCULPTURE, 9, "A marble bust of Julius Caesar, the Roman dictator, symbolizing his power and influence."},
			{"Mosaic Floor from a Roman Villa", ArtifactType.SCULPTURE, 10, "A colorful mosaic floor from a Roman villa, depicting scenes of nature, mythology, or daily life."},
			{"Roman Imperial Coin Collection", ArtifactType.OTHER, 4, "A collection of coins from the Roman Empire, showcasing its vast reach and economic power."},
			{"Amphorae for Olive Oil", ArtifactType.SCULPTURE, 6, "Large ceramic containers used in ancient Rome for storing olive oil, an essential commodity."},
			{"Stone Carving of Ra", ArtifactType.SCULPTURE, 8, "A stone carving of Ra, the ancient Egyptian sun god, often depicted with a falcon's head."},
			{"Wooden Statue of Horus", ArtifactType.SCULPTURE, 9, "A wooden statue of Horus, the Egyptian god of the sky, typically depicted as a falcon or a man with a falcon head."},
			{"Offering Table with Incense Burners", ArtifactType.SCULPTURE, 10, "A table used for offering gifts to the gods, often accompanied by incense burners in ancient Egyptian rituals."},
			{"Hieroglyphic Inscription on Stone", ArtifactType.MANUSCRIPT, 5, "A stone inscribed with hieroglyphic characters, used for recording events, rituals, or royal decrees in ancient Egypt."},
			{"Small Obelisk", ArtifactType.SCULPTURE, 7, "A miniature obelisk, a common architectural feature in ancient Egypt, symbolizing the sun god Ra."},
			{"Chainmail Armor", ArtifactType.CLOTHING, 6, "A type of armor made of interlocking rings, offering flexibility and protection for medieval soldiers."},
			{"Heraldic Shield of a Noble House", ArtifactType.WEAPON, 8, "A shield adorned with the coat of arms of a noble house, symbolizing lineage and nobility."},
			{"Knight’s Sword and Scabbard", ArtifactType.WEAPON, 4, "A sword and its accompanying scabbard, commonly carried by knights during the Middle Ages."},
			{"Tapestry Depicting the Battle of Hastings", ArtifactType.MATERIAL, 9, "A woven tapestry that depicts the Battle of Hastings, a key event in the Norman Conquest of England."},
			{"Wooden Crossbow", ArtifactType.WEAPON, 6, "An early model of a crossbow, a weapon used during the medieval period for long-range combat."},
			{"Katana Sword with Signed Blade", ArtifactType.WEAPON, 8, "A finely crafted Japanese katana, known for its sharpness and balance, with a signed blade indicating the maker."},
			{"Samurai Armor", ArtifactType.CLOTHING, 7, "Armor worn by samurai warriors in feudal Japan, designed for both protection and mobility in battle."},
			{"Shuriken (Throwing Star)", ArtifactType.WEAPON, 5, "A small, star-shaped weapon used by ninjas in feudal Japan, designed for distraction or injury."},
			{"Scroll of the Bushido Code", ArtifactType.MANUSCRIPT, 8, "A manuscript detailing the Bushido Code, the moral and ethical code followed by samurai warriors."},
			{"Japanese War Helmet", ArtifactType.CLOTHING, 9, "A helmet worn by Japanese samurai or warriors, often decorated with intricate designs to signify rank."},
			{"George Washington's Military Uniform", ArtifactType.CLOTHING, 6, "The military uniform worn by George Washington during the American Revolutionary War, symbolizing his leadership."},
			{"Continental Army Musket", ArtifactType.WEAPON, 7, "A musket used by soldiers of the Continental Army during the American Revolution."},
			{"Revolutionary War-era Flag", ArtifactType.FLAG, 9, "A flag from the American Revolutionary War, symbolizing the struggle for independence from Great Britain."},
			{"Declaration of Independence (Replica)", ArtifactType.MANUSCRIPT, 5, "A reproduction of the historic document declaring the independence of the United States from Great Britain."},
			{"The Writing Desk of Thomas Jefferson", ArtifactType.SCULPTURE, 7, "The desk used by Thomas Jefferson, one of the Founding Fathers of the United States, known for drafting the Declaration of Independence."},
			{"Maya Stelae (Stone Monument)", ArtifactType.SCULPTURE, 6, "A stone monument created by the ancient Maya civilization, typically inscribed with hieroglyphic text and historical records."},
			{"Maya Calendar Stone", ArtifactType.SCULPTURE, 8, "A large stone monument from the Maya civilization, featuring their intricate calendar system."},
			{"Ceremonial Mask of the Jaguar God", ArtifactType.CLOTHING, 3, "A ceremonial mask representing the Jaguar God, a key figure in Mesoamerican mythology."},
			{"Maya Codex (Book)", ArtifactType.MANUSCRIPT, 7, "An ancient book from the Maya civilization, often made of bark paper, detailing their knowledge and beliefs."},
			{"Jade Jewelry", ArtifactType.CLOTHING, 6, "Ornate jewelry made from jade, a precious stone highly valued in Mesoamerican cultures."},
			{"Steam Engine Model", ArtifactType.MACHINE, 9, "A model of an early steam engine, demonstrating the technological breakthrough that powered the Industrial Revolution."},
			{"Textile Spinning Wheel", ArtifactType.MATERIAL, 5, "A device used to spin fibers into thread, an essential tool in textile production during the pre-industrial era."},
			{"Coal Mining Tools", ArtifactType.OTHER, 8, "A set of tools used in the coal mining industry, integral to the Industrial Revolution's energy production."},
			{"Early Industrial Factory Model", ArtifactType.SCULPTURE, 7, "A model representing the early factories that sparked the Industrial Revolution, marking the shift to mechanized production."},
			{"Victorian Era Engineer’s Hat", ArtifactType.CLOTHING, 6, "A hat worn by engineers during the Victorian era, symbolizing the rise of engineering professions in the 19th century."},
			{"Claude Monet’s 'Water Lilies' (Replica)", ArtifactType.PAINTING, 8, "A replica of Claude Monet’s famous impressionist painting series, capturing the beauty of his garden’s water lilies."},
			{"Edgar Degas’ Ballet Dancer Sculpture", ArtifactType.SCULPTURE, 7, "A sculpture by Edgar Degas, portraying the grace and movement of a ballet dancer, a hallmark of his artistic style."},
			{"Vincent van Gogh’s 'Sunflowers' (Replica)", ArtifactType.PAINTING, 9, "A replica of Vincent van Gogh’s iconic 'Sunflowers' series, a vivid display of the artist’s expressive brushwork."},
			{"Pierre-Auguste Renoir's 'Luncheon of the Boating Party' (Replica)", ArtifactType.PAINTING, 5, "A replica of Renoir’s famous painting capturing a joyful gathering of friends enjoying a meal by the river."},
			{"Sketches by Mary Cassatt", ArtifactType.PAINTING, 8, "A collection of sketches by Mary Cassatt, showcasing her unique perspective on domestic life and women's roles in the 19th century."},
			{"Golden Sun Mask", ArtifactType.CLOTHING, 7, "A ceremonial mask representing the sun, made of gold, often used in rituals to honor solar deities in ancient Mesoamerican cultures."},
			{"Inca Pottery and Storage Vessels", ArtifactType.SCULPTURE, 6, "Handcrafted pottery and vessels used by the Inca for storage and ritual purposes, often adorned with intricate designs."},
			{"Stone Work from Machu Picchu", ArtifactType.SCULPTURE, 10, "Stonework from the ancient Inca city of Machu Picchu, showcasing the advanced architectural and engineering skills of the Inca civilization."},
			{"Quipu (Knotted Record-Keeping Device)", ArtifactType.OTHER, 4, "A knotted string device used by the Incas for record-keeping, functioning as a form of written communication."},
			{"Inca Bronze Knife", ArtifactType.WEAPON, 5, "A bronze knife used by the Incas for ceremonial and everyday purposes, often finely crafted with intricate designs."},
			{"Guillotine Blade", ArtifactType.WEAPON, 7, "The blade of the infamous guillotine, used during the French Revolution for executions, symbolizing the radical shift in political power."},
			{"Marie Antoinette’s Court Dress", ArtifactType.CLOTHING, 9, "The extravagant court dress worn by Marie Antoinette, reflecting the opulence and fashion of 18th-century French royalty."},
			{"Revolutionary Era Tricolor Flag", ArtifactType.FLAG, 6, "The flag of revolutionary France, known for its blue, white, and red stripes symbolizing liberty, equality, and fraternity."},
			{"Napoleon’s Bicorne Hat", ArtifactType.CLOTHING, 8, "The iconic bicorne hat worn by Napoleon Bonaparte, a symbol of his military leadership and status as Emperor of France."},
			{"Letter Written by Robespierre", ArtifactType.MANUSCRIPT, 4, "A letter written by Maximilien Robespierre, a key figure during the French Revolution, advocating for revolutionary ideals."},
			{"Captain Edward Smith’s Pocket Watch", ArtifactType.CLOTHING, 7, "The pocket watch worn by Captain Edward Smith, the captain of the RMS Titanic, symbolizing the personal belongings of the ship's officers."},
			{"First-Class Passenger Ticket", ArtifactType.OTHER, 3, "A first-class passenger ticket for the RMS Titanic, a piece of history linked to one of the most famous maritime disasters."},
			{"Fragment of the Ship’s Stern", ArtifactType.OTHER, 6, "A fragment of the Titanic's stern, a remnant of the ill-fated ship that sank in 1912 after hitting an iceberg."},
			{"Lifeboat Oar from the Titanic", ArtifactType.OTHER, 9, "An oar from a lifeboat on the Titanic, symbolizing the tragic loss of life and the desperate efforts to survive."},
			{"Dinner Plate from the Ship’s Dining Room", ArtifactType.OTHER, 5, "A dinner plate from the Titanic’s dining room, offering a glimpse into the luxury aboard the ill-fated ship."},
			{"Apollo 11 Moon Landing Flag", ArtifactType.FLAG, 7, "The flag planted on the moon during the Apollo 11 mission, marking the first human landing on the lunar surface in 1969."},
			{"Wernher von Braun’s Rocket Design Plans", ArtifactType.MANUSCRIPT, 8, "Design plans for the rockets that enabled space exploration, created by Wernher von Braun, a leading figure in the U.S. space program."},
			{"Cosmonaut's Space Suit (Replica)", ArtifactType.CLOTHING, 9, "A replica of the space suit worn by Soviet cosmonauts, representing humanity’s venture into space during the Cold War era."},
			{"Original Sputnik Satellite", ArtifactType.MACHINE, 6, "The original Sputnik satellite, launched by the Soviet Union in 1957, marking the beginning of the space race."},
			{"Apollo Lunar Module Fragment", ArtifactType.MATERIAL, 7, "A fragment of the Apollo lunar module, the spacecraft that carried astronauts to the moon during the Apollo missions."},
			{"Bronze Statue of Isis Nursing Horus", ArtifactType.SCULPTURE, 8, "A bronze statue depicting the Egyptian goddess Isis nursing her son Horus, a symbol of motherhood and divine protection in ancient Egypt."},
			{"Isis-Style Amulet", ArtifactType.CLOTHING, 5, "An amulet depicting the goddess Isis, often worn for protection and as a symbol of fertility and rebirth in ancient Egyptian culture."},
			{"Ptolemaic Period Ceremonial Mask", ArtifactType.CLOTHING, 3, "A ceremonial mask from the Ptolemaic period of ancient Egypt, often used in religious rituals and funerary practices."},
			{"Isis Temple Relic", ArtifactType.SCULPTURE, 9, "A relic from the ancient Egyptian temple dedicated to the goddess Isis, representing her role in religion and culture."},
			{"Ancient Egyptian Spells for Protection", ArtifactType.MANUSCRIPT, 7, "A manuscript containing ancient Egyptian spells intended for protection in the afterlife, demonstrating their rich spiritual traditions."},
			{"Terracotta Warrior Figurine", ArtifactType.SCULPTURE, 8, "A figurine of a Terracotta Warrior from the tomb of China's first emperor, Qin Shi Huang, designed to guard the emperor in the afterlife."},
			{"Dragon-Shaped Jade Pendant", ArtifactType.CLOTHING, 9, "A pendant carved from jade, shaped like a dragon, a symbol of power and auspiciousness in ancient Chinese culture."},
			{"Silk Road Map and Trade Artifacts", ArtifactType.MANUSCRIPT, 6, "A map of the Silk Road, accompanied by artifacts from the trade routes that connected East Asia, Central Asia, and the Mediterranean."},
			{"Imperial Ceremonial Robes", ArtifactType.CLOTHING, 7, "Ceremonial robes worn by emperors, symbolizing the authority and divine mandate of rulers in ancient China."},
			{"Han Dynasty Bronze Mirror", ArtifactType.SCULPTURE, 8, "A finely crafted bronze mirror from the Han Dynasty, often decorated with intricate designs and used for both practical and ritual purposes."},
			{"Painted War Shield", ArtifactType.WEAPON, 5, "A painted war shield, often used by ancient civilizations to display status and as protection in battle."},
			{"Navajo Woven Blanket", ArtifactType.MATERIAL, 7, "A beautifully woven blanket from the Navajo people, known for its intricate patterns and cultural significance."},
			{"Hopi Kachina Doll", ArtifactType.SCULPTURE, 9, "A Kachina doll from the Hopi tribe, used in religious ceremonies to represent spirit beings who guide and protect the community."},
			{"Beaded Pouch", ArtifactType.OTHER, 3, "A small pouch adorned with intricate beadwork, often used by indigenous peoples for carrying small personal items."},
			{"Feathered Headdress", ArtifactType.CLOTHING, 4, "A headdress adorned with feathers, typically worn in ceremonial contexts by various indigenous cultures of the Americas."},
			{"Pirate’s Cutlass Sword", ArtifactType.WEAPON, 8, "A cutlass sword, often associated with pirates, featuring a curved blade designed for close combat and boarding actions."},
			{"Treasure Chest with Gold Doubloons (Replica)", ArtifactType.SCULPTURE, 6, "A replica of a pirate's treasure chest filled with gold doubloons, symbolizing the legendary pirate treasures of the Caribbean."},
			{"Blackbeard's Flag (Replica)", ArtifactType.FLAG, 7, "A replica of Blackbeard’s infamous flag, featuring a skull and crossbones, representing the fearsome pirate’s reign over the seas."},
			{"Map of the Caribbean Sea", ArtifactType.MANUSCRIPT, 5, "A historical map of the Caribbean Sea, often used by pirates and explorers to navigate the treacherous waters of the region."},
			{"Pirate’s Compass", ArtifactType.OTHER, 4, "A compass used by pirates for navigation, an essential tool for finding their way across the open seas."},
			{"Fossilized Hominid Skull (Australopithecus)", ArtifactType.FOSSIL, 9, "A fossilized skull of Australopithecus, an early hominid species, providing valuable insights into human evolution."},
			{"Early Stone Tools", ArtifactType.OTHER, 8, "A collection of early stone tools used by prehistoric humans for hunting, gathering, and survival."},
			{"Cave Paintings from Lascaux", ArtifactType.PAINTING, 7, "Ancient cave paintings from Lascaux, France, depicting animals and symbolic motifs, created by early humans around 17,000 years ago."},
			{"Fossilized Footprints of Homo Habilis", ArtifactType.FOSSIL, 6, "Fossilized footprints left by Homo habilis, an early ancestor of modern humans, offering a glimpse into prehistoric life."},
			{"Neanderthal Bone Flute", ArtifactType.OTHER, 5, "A bone flute, crafted by Neanderthals, one of the earliest known musical instruments made by humans."},
			{"Arrowhead from the Ming Dynasty", ArtifactType.WEAPON, 7, "An arrowhead dating from the Ming Dynasty, used in combat and as a symbol of the period's advanced metallurgy."},
			{"Stone Tablet with Wall Construction Records", ArtifactType.MANUSCRIPT, 6, "A stone tablet inscribed with records related to the construction of ancient city walls, reflecting the administrative systems of early civilizations."},
			{"Wall-Mounted Soldier’s Armor", ArtifactType.CLOTHING, 4, "A piece of wall-mounted soldier’s armor, designed to display the protective gear worn by warriors in ancient battles."},
			{"Silk Banner from the Wall Guard", ArtifactType.MATERIAL, 9, "A silk banner used by ancient wall guards, representing authority and providing a visual signal of their presence and vigilance."},
			{"Chinese Dragon Figurine", ArtifactType.SCULPTURE, 7, "A figurine of a Chinese dragon, a mythical creature symbolizing strength, prosperity, and protection in Chinese culture."},
			{"Bronze Dancing Shiva Statue", ArtifactType.SCULPTURE, 8, "A bronze statue of the Hindu god Shiva in his Nataraja form, depicting his cosmic dance and the cycle of creation and destruction."},
			{"Buddha’s Relic Container", ArtifactType.SCULPTURE, 6, "A container holding sacred relics of the Buddha, often used in Buddhist ceremonies and worship."},
			{"Carved Stone from Ajanta Caves", ArtifactType.SCULPTURE, 5, "A carved stone from the Ajanta Caves, known for their intricate Buddhist art and architecture from ancient India."},
			{"Mughal Miniature Painting", ArtifactType.PAINTING, 8, "A miniature painting from the Mughal Empire, renowned for its detailed depiction of historical events, court life, and landscapes."},
			{"Early Hindu Ritual Vessel", ArtifactType.OTHER, 9, "A vessel used in early Hindu rituals, often crafted with symbolic designs and used in religious ceremonies."},
			{"Shackleton's Expedition Jacket", ArtifactType.CLOTHING, 7, "The jacket worn by Sir Ernest Shackleton during his Antarctic expedition, symbolizing the harsh conditions of early 20th-century polar exploration."},
			{"Ice Core Sample", ArtifactType.MATERIAL, 5, "A sample taken from an ice core, used to study past climates and environmental conditions on Earth."},
			{"Map of Antarctica from the 19th Century", ArtifactType.MANUSCRIPT, 6, "A 19th-century map of Antarctica, representing the early explorations and geographic understanding of the frozen continent."},
			{"Early Snowshoes", ArtifactType.CLOTHING, 7, "A pair of early snowshoes, designed to help travelers navigate deep snow in cold, northern climates."},
			{"Photos from the First Antarctic Expedition", ArtifactType.PHOTOGRAPH, 8, "Historical photographs documenting the first Antarctic expedition, offering a glimpse into the challenges and triumphs of early polar explorers."},
			{"Benin Bronze Plaques", ArtifactType.OTHER, 9, "Bronze plaques from the Kingdom of Benin, depicting the royal court and the rich history of this West African civilization."},
			{"Mali Empire Gold Nugget", ArtifactType.MATERIAL, 5, "A gold nugget from the Mali Empire, a symbol of the empire's immense wealth derived from its gold mines."},
			{"Senufo Mask", ArtifactType.CLOTHING, 7, "A ceremonial mask used by the Senufo people of West Africa, often worn in dances and rituals to represent spirits and deities."},
			{"Zulu Warrior Shield", ArtifactType.WEAPON, 6, "A shield used by Zulu warriors, often made from animal hide and decorated with intricate patterns, symbolizing strength and protection."},
			{"Ashanti Royal Regalia", ArtifactType.OTHER, 9, "Regalia worn by the Ashanti kings, symbolizing their royal status and the cultural significance of the Ashanti Empire in West Africa."},
			{"Map by Christopher Columbus", ArtifactType.MANUSCRIPT, 7, "A map created by Christopher Columbus during his voyages, representing one of the first European attempts to chart the New World."},
			{"Compass used by Vasco da Gama", ArtifactType.OTHER, 8, "A compass used by the Portuguese explorer Vasco da Gama during his voyages, symbolizing European exploration during the Age of Discovery."},
			{"Astronomical Instruments for Navigation", ArtifactType.OTHER, 9, "Astronomical instruments used in navigation, essential tools for sailors during the Age of Exploration, helping them to chart their course by the stars."},
			{"Shipwrecked Cannon", ArtifactType.OTHER, 7, "A cannon recovered from a shipwreck, providing insights into the naval warfare and maritime history of the period."},
			{"Early European Navigational Charts", ArtifactType.MANUSCRIPT, 6, "Early European navigational charts used by explorers to guide their journeys across the seas during the Age of Discovery."},
			{"Coronation Robe of Tsar Nicholas II", ArtifactType.CLOTHING, 7, "The ceremonial robe worn by Tsar Nicholas II during his coronation, symbolizing the grandeur and opulence of the Russian imperial court."},
			{"Fabergé Egg", ArtifactType.OTHER, 8, "A jeweled egg created by the Russian Fabergé company, famous for its intricate design and its association with the Russian imperial family."},
			{"Imperial Russian Crown", ArtifactType.CLOTHING, 5, "The crown worn by the tsars of Russia, symbolizing their divine right to rule and their imperial power."},
			{"Personal Diary of Catherine the Great", ArtifactType.MANUSCRIPT, 6, "A personal diary of Catherine the Great, offering a glimpse into the thoughts and daily life of one of Russia’s most renowned empresses."},
			{"Tsarist Throne", ArtifactType.SCULPTURE, 8, "The throne of the Russian tsars, an ornate seat of power symbolizing the authority and grandeur of the Russian monarchy."},
			{"Imperial Dragon Throne", ArtifactType.SCULPTURE, 9, "A throne adorned with intricate dragon motifs, representing the imperial power and divine rule of Chinese emperors."},
			{"Emperor's Ceremonial Sword", ArtifactType.WEAPON, 7, "The ceremonial sword of an emperor, often used in royal rites and as a symbol of the emperor's power and authority."},
			{"Ming Dynasty Cloisonné Vase", ArtifactType.SCULPTURE, 6, "A decorative vase from the Ming Dynasty, crafted using the cloisonné technique and adorned with intricate designs."},
			{"Jade Emperor’s Seal", ArtifactType.OTHER, 8, "A jade seal used by the emperor of China to authenticate documents, a symbol of imperial authority and governance."},
			{"Old Chinese Imperial Scrolls", ArtifactType.MANUSCRIPT, 7, "Ancient Chinese scrolls used by the imperial court for documentation and ceremonial purposes."},
			{"Model of Leonardo da Vinci’s Flying Machine", ArtifactType.MACHINE, 9, "A scale model of Leonardo da Vinci’s concept for a human-powered flying device."},
			{"The Wright Brothers’ First Flight Engine", ArtifactType.MACHINE, 7, "The engine used in the Wright Brothers' first successful powered flight in 1903."},
			{"Edison’s Original Light Bulb", ArtifactType.MACHINE, 6, "The first commercially successful electric light bulb, invented by Thomas Edison."},
			{"Gutenberg Printing Press Replica", ArtifactType.MACHINE, 7, "A working replica of Johannes Gutenberg’s groundbreaking printing press from the 15th century."},
			{"Early Telephone Prototype", ArtifactType.MACHINE, 9, "An early version of the telephone invented by Alexander Graham Bell, revolutionizing communication."},
			{"Stone Tablet from the Indus Valley Civilization", ArtifactType.MANUSCRIPT, 8, "A stone tablet featuring an undeciphered script from the ancient Indus Valley Civilization."},
			{"Mayan Jade Mask", ArtifactType.CLOTHING, 7, "A ceremonial mask made of jade, crafted by the ancient Maya civilization for ritual use."},
			{"Minoan Fresco Fragment", ArtifactType.MATERIAL, 9, "A fragment of a vibrant fresco from the ancient Minoan civilization, depicting scenes of daily life."},
			{"Uruk Cylinder Seal (Sumerian)", ArtifactType.OTHER, 6, "A small, cylindrical seal from ancient Uruk, used to imprint the Sumerian script on clay tablets."},
			{"Ancient Olmec Colossal Head (Replica)", ArtifactType.SCULPTURE, 8, "A replica of the massive stone heads created by the Olmec civilization in ancient Mesoamerica."},
			{"Cuneiform Tablet from Mesopotamia", ArtifactType.MANUSCRIPT, 7, "A clay tablet inscribed with cuneiform writing, one of the earliest forms of writing in ancient Mesopotamia."},
			{"Ancient Egyptian Papyrus Scroll", ArtifactType.MANUSCRIPT, 9, "A scroll made from papyrus, used by ancient Egyptians to record texts, prayers, and literature."},
			{"Chinese Oracle Bone Script", ArtifactType.MANUSCRIPT, 5, "A fragment of bone or shell inscribed with ancient Chinese characters, used in divination practices."},
			{"The Rosetta Stone (Replica)", ArtifactType.MANUSCRIPT, 6, "A replica of the famous stone that helped scholars decipher ancient Egyptian hieroglyphs."},
			{"Medieval Illuminated Manuscript", ArtifactType.MANUSCRIPT, 8, "A hand-written manuscript from the medieval period, richly decorated with elaborate illustrations and gold leaf."},
			{"Daguerreotype Camera", ArtifactType.MACHINE, 7, "The first commercially successful photographic camera, which used the daguerreotype process."},
			{"First Photograph by Joseph Nicéphore Niépce", ArtifactType.PHOTOGRAPH, 9, "The world’s first permanent photograph, captured by Joseph Nicéphore Niépce in the early 19th century."},
			{"Tintype Portrait of a Civil War Soldier", ArtifactType.PAINTING, 5, "A tintype photograph of a Civil War soldier, a popular medium during the mid-19th century."},
			{"Early Kodak Box Camera", ArtifactType.MACHINE, 6, "The Kodak box camera, one of the first easy-to-use cameras that popularized photography for the masses."},
			{"A Collection of 19th-Century Photographic Portraits", ArtifactType.PAINTING, 9, "A collection of photographic portraits from the 19th century, capturing historical figures and everyday people."},
			{"P.T. Barnum’s Top Hat", ArtifactType.CLOTHING, 8, "The iconic top hat worn by P.T. Barnum, the famous circus impresario and showman."},
			{"Vintage Circus Poster for The Greatest Show on Earth", ArtifactType.MANUSCRIPT, 7, "A colorful vintage poster advertising P.T. Barnum’s famous circus, 'The Greatest Show on Earth'."},
			{"Clown Costume from the Early 20th Century", ArtifactType.CLOTHING, 4, "A costume worn by clowns in early 20th-century circuses, featuring bold colors and exaggerated features."},
			{"Circus Performer’s Trapeze", ArtifactType.OTHER, 6, "A trapeze used by circus performers for acrobatic aerial stunts, symbolizing circus acrobatics."},
			{"Ringmaster’s Whip and Costume", ArtifactType.CLOTHING, 5, "The whip and costume traditionally worn by the ringmaster, the leader of a circus performance."},
			{"Traditional Marionette from Italy", ArtifactType.OTHER, 9, "A handcrafted wooden puppet from Italy, part of the rich tradition of Italian marionette theater."},
			{"Shadow Puppets from Indonesia", ArtifactType.OTHER, 7, "Intricately carved shadow puppets from Indonesia, used in traditional wayang kulit performances."},
			{"Puppeteer’s Handcrafted Wooden Puppet", ArtifactType.SCULPTURE, 8, "A wooden puppet, meticulously crafted by a puppeteer for use in live puppet shows."},
			{"Henson's Original Kermit the Frog Puppet", ArtifactType.OTHER, 6, "The original puppet of Kermit the Frog, created by Jim Henson for 'Sesame Street' and 'The Muppet Show'."},
			{"Hand-painted Puppet Theater Stage", ArtifactType.SCULPTURE, 7, "A hand-painted wooden stage used for puppetry, designed to create the illusion of a theatrical performance."}

	};
	
	/**
	 * Checks if a string is null or empty.
	 * @param str - string to check.
	 * @return true if it is null or empty, false otherwise.
	 */
	public static boolean isStringNullOrEmpty(String str) {
		if (str == null) {
			return true;
		}
		
		if (str.trim().length() == 0) {
			return true;
		}
		
		return false;
	}
}
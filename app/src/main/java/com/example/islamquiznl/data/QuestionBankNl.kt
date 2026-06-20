package com.example.islamquiznl.data

// Nederlandse islamitische vragenbank - starterbestand.
// Controleer de vragen inhoudelijk met betrouwbare bronnen/geleerden voordat je publiceert.

enum class QuizCategory {
    AKHLAAQ, GENERAL, HADITH, PRAYER_WUDU, PROPHETS, QURAN, RAMADAN, SAHABA, SEERAH
}

enum class Difficulty {
    EASY, MEDIUM, HARD
}

data class Question(
    val id: Int,
    val category: QuizCategory,
    val difficulty: Difficulty,
    val question: String,
    val answers: List<String>,
    val correctAnswerIndex: Int,
    val explanation: String,
    val hint: String,
    val extraHint: String,
    val sourceCategory: String,
    val sourceText: String? = null
)

object QuestionBankNl {

    val questions: List<Question> = listOf(

        Question(
            id = 1,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.EASY,
            question = "Wat is de eerste surah van de Qur'an?",
            answers = listOf("Al-Baqarah", "Al-Fātiḥah", "Al-Ikhlāṣ", "Yāsīn"),
            correctAnswerIndex = 1,
            explanation = "Al-Fātiḥah staat aan het begin van de Qur'an en betekent 'De Opening'.",
            hint = "Denk aan de surah waarmee het gebed begint.",
            extraHint = "Deze surah wordt in elke rakʿah gereciteerd.",
            sourceCategory = "Qur'an"
        ),

        Question(
            id = 2,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.EASY,
            question = "Hoeveel juz' heeft de Qur'an?",
            answers = listOf("20", "25", "30", "40"),
            correctAnswerIndex = 2,
            explanation = "De Qur'an is verdeeld in 30 juz', wat handig is voor recitatie en studie.",
            hint = "Veel mensen lezen één juz' per dag in Ramadan.",
            extraHint = "Het aantal is gelijk aan het aantal dagen van een gewone maand.",
            sourceCategory = "Qur'an"
        ),

        Question(
            id = 3,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.EASY,
            question = "Welke surah is de langste surah van de Qur'an?",
            answers = listOf("Al-Baqarah", "Āl ʿImrān", "An-Nisā'", "Al-Mā'idah"),
            correctAnswerIndex = 0,
            explanation = "Surah Al-Baqarah is de langste surah van de Qur'an.",
            hint = "De naam betekent 'De Koe'.",
            extraHint = "Deze surah staat direct na Al-Fātiḥah.",
            sourceCategory = "Qur'an"
        ),

        Question(
            id = 4,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.EASY,
            question = "Welke surah is de kortste surah van de Qur'an?",
            answers = listOf("Al-Falaq", "An-Nās", "Al-Kawthar", "Al-Ikhlāṣ"),
            correctAnswerIndex = 2,
            explanation = "Surah Al-Kawthar is de kortste surah van de Qur'an.",
            hint = "Deze surah bestaat uit drie korte verzen.",
            extraHint = "De naam verwijst naar een grote gunst die Allah aan de Profeet ﷺ gaf.",
            sourceCategory = "Qur'an"
        ),

        Question(
            id = 5,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.EASY,
            question = "Welke surah wordt vaak gereciteerd op vrijdag?",
            answers = listOf("Al-Kahf", "Yūsuf", "Maryam", "Ṭāhā"),
            correctAnswerIndex = 0,
            explanation = "Surah Al-Kahf wordt vaak op vrijdag gereciteerd vanwege bekende overleveringen over haar deugd.",
            hint = "Denk aan de surah met het verhaal van de mensen van de grot.",
            extraHint = "De naam betekent 'De Grot'.",
            sourceCategory = "Hadith/Qur'an"
        ),

        Question(
            id = 6,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.EASY,
            question = "In welke taal is de Qur'an geopenbaard?",
            answers = listOf("Perzisch", "Arabisch", "Hebreeuws", "Aramees"),
            correctAnswerIndex = 1,
            explanation = "De Qur'an is in duidelijke Arabische taal geopenbaard.",
            hint = "De taal van de Qur'an is ook de taal van de recitatie in het gebed.",
            extraHint = "Het is de taal waarin veel islamitische termen bekend zijn.",
            sourceCategory = "Qur'an"
        ),

        Question(
            id = 7,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.EASY,
            question = "Welke surah beschrijft kort en krachtig de eenheid van Allah?",
            answers = listOf("Al-Ikhlāṣ", "Al-Falaq", "An-Nās", "Al-Masad"),
            correctAnswerIndex = 0,
            explanation = "Surah Al-Ikhlāṣ beschrijft de eenheid van Allah op een korte en krachtige manier.",
            hint = "Deze surah begint met 'Qul huwa Allahu ahad'.",
            extraHint = "Veel moslims kennen deze korte surah uit het hoofd.",
            sourceCategory = "Qur'an"
        ),

        Question(
            id = 8,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.EASY,
            question = "Welke twee surahs worden vaak de 'beschermende surahs' genoemd?",
            answers = listOf("Al-Fīl en Quraysh", "Al-Falaq en An-Nās", "Yāsīn en Al-Mulk", "Al-Kahf en Maryam"),
            correctAnswerIndex = 1,
            explanation = "Al-Falaq en An-Nās worden vaak samen gereciteerd als bescherming.",
            hint = "Ze staan helemaal aan het einde van de Qur'an.",
            extraHint = "Ze beginnen allebei met 'Qul aʿūdhu'.",
            sourceCategory = "Qur'an/Sunnah"
        ),

        Question(
            id = 9,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.EASY,
            question = "Welke surah bevat het verhaal van Maryam عليها السلام en de geboorte van ʿĪsā عليه السلام?",
            answers = listOf("Maryam", "An-Nūr", "Al-Mujādilah", "Al-Ḥadīd"),
            correctAnswerIndex = 0,
            explanation = "Surah Maryam bevat het verhaal van Maryam عليها السلام en de geboorte van ʿĪsā عليه السلام. Het gaat dus niet over de geboorte van Maryam zelf.",
            hint = "De surah draagt de naam van Maryam عليها السلام.",
            extraHint = "Denk aan de moeder van ʿĪsā عليه السلام.",
            sourceCategory = "Qur'an"
        ),

        Question(
            id = 10,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.EASY,
            question = "Wat betekent 'āyah' meestal in de context van de Qur'an?",
            answers = listOf("Hoofdstuk", "Vers/teken", "Gebedstijd", "Overlevering"),
            correctAnswerIndex = 1,
            explanation = "Een āyah is een vers of teken in de Qur'an.",
            hint = "Een surah bestaat uit meerdere āyāt.",
            extraHint = "Het woord betekent ook 'teken'.",
            sourceCategory = "Qur'an"
        ),

        Question(
            id = 11,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.MEDIUM,
            question = "Welke surah bevat Āyat al-Kursī?",
            answers = listOf("Al-Fātiḥah", "Al-Baqarah", "Āl ʿImrān", "An-Nisā'"),
            correctAnswerIndex = 1,
            explanation = "Āyat al-Kursī staat in Surah Al-Baqarah, vers 255.",
            hint = "Het is in de langste surah van de Qur'an.",
            extraHint = "Deze surah staat na Al-Fātiḥah.",
            sourceCategory = "Qur'an 2:255"
        ),

        Question(
            id = 12,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.MEDIUM,
            question = "Hoeveel surahs heeft de Qur'an?",
            answers = listOf("100", "114", "120", "99"),
            correctAnswerIndex = 1,
            explanation = "De Qur'an heeft 114 surahs.",
            hint = "Het is een veelvoud van 6.",
            extraHint = "De eerste is Al-Fātiḥah, de laatste is An-Nās.",
            sourceCategory = "Qur'an"
        ),

        Question(
            id = 13,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.MEDIUM,
            question = "Welke engel bracht de Qur'an aan de Profeet ﷺ?",
            answers = listOf("Mīkā'īl", "Jibrīl", "Isrāfīl", "ʿIzrā'īl"),
            correctAnswerIndex = 1,
            explanation = "Jibrīl عليه السلام bracht de openbaringen van de Qur'an aan de Profeet ﷺ.",
            hint = "Hij is ook bekend als de engel van de openbaring.",
            extraHint = "Hij daalde af in de grot van Hirā'.",
            sourceCategory = "Qur'an/Seerah"
        ),

        Question(
            id = 14,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.MEDIUM,
            question = "Welke surah wordt 'het hart van de Qur'an' genoemd?",
            answers = listOf("Al-Baqarah", "Āl ʿImrān", "Yāsīn", "Al-Kahf"),
            correctAnswerIndex = 2,
            explanation = "Yāsīn wordt in sommige overleveringen 'het hart van de Qur'an' genoemd.",
            hint = "Het is een bekende surah die vaak bij gelegenheden wordt gereciteerd.",
            extraHint = "De naam bestaat uit twee Arabische letters.",
            sourceCategory = "Hadith"
        ),

        Question(
            id = 15,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.MEDIUM,
            question = "In welke maand werd de Qur'an geopenbaard?",
            answers = listOf("Rajab", "Dhul-Hijjah", "Ramadan", "Muharram"),
            correctAnswerIndex = 2,
            explanation = "De Qur'an begon geopenbaard te worden in de maand Ramadan.",
            hint = "Het is de heiligste maand van het islamitische jaar.",
            extraHint = "Layla al-Qadr valt ook in deze maand.",
            sourceCategory = "Qur'an 2:185"
        ),

        Question(
            id = 16,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.HARD,
            question = "Welke surah bevat de langste āyah van de Qur'an?",
            answers = listOf("Yāsīn", "Al-Baqarah", "An-Nisā'", "Al-Mā'idah"),
            correctAnswerIndex = 1,
            explanation = "De langste āyah is Āyat al-mudāyanah (2:282) in Surah Al-Baqarah.",
            hint = "Het is de langste surah van de Qur'an.",
            extraHint = "Deze āyah gaat over schulden.",
            sourceCategory = "Qur'an 2:282"
        ),

        Question(
            id = 17,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.HARD,
            question = "Hoeveel muqaṭṭaʿāt (losse letters) openers heeft de Qur'an?",
            answers = listOf("14", "29", "7", "19"),
            correctAnswerIndex = 1,
            explanation = "Er zijn 29 surahs die beginnen met muqaṭṭaʿāt, losse letters waarvan de exacte betekenis alleen Allah kent.",
            hint = "Denk aan surahs die beginnen met 'Alif Lam Mim'.",
            extraHint = "Ze worden ook wel Ḥurūf al-muqaṭṭaʿāt genoemd.",
            sourceCategory = "Qur'an"
        ),

        Question(
            id = 18,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.HARD,
            question = "Welke surah heeft geen Basmallah aan het begin?",
            answers = listOf("Al-Fātiḥah", "Al-Baqarah", "At-Tawbah", "Al-Ikhlāṣ"),
            correctAnswerIndex = 2,
            explanation = "Surah At-Tawbah is de enige surah zonder Basmallah aan het begin.",
            hint = "Het is een van de laatste surahs die geopenbaard werd.",
            extraHint = "De naam betekent 'Berouw'.",
            sourceCategory = "Qur'an"
        ),

        Question(
            id = 19,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.HARD,
            question = "Welke surah bevat twee keer de Basmallah?",
            answers = listOf("Al-Fātiḥah", "An-Naml", "Al-Baqarah", "Al-Kahf"),
            correctAnswerIndex = 1,
            explanation = "Surah An-Naml bevat de Basmallah tweemaal: aan het begin en in vers 30.",
            hint = "De naam betekent 'De Mieren'.",
            extraHint = "De tweede Basmallah staat in de brief van Sulaymān عليه السلام.",
            sourceCategory = "Qur'an 27:30"
        ),

        Question(
            id = 20,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.HARD,
            question = "Hoeveel sajdahs (prostratietekens) staan er in de Qur'an?",
            answers = listOf("10", "14", "15", "12"),
            correctAnswerIndex = 2,
            explanation = "Er zijn 15 sajdah-plaatsen in de Qur'an waar een prostratieteken staat.",
            hint = "Het zijn verzen waarbij men sujud kan doen.",
            extraHint = "De meeste geleerden tellen er 15.",
            sourceCategory = "Qur'an"
        ),

        Question(
            id = 21,
            category = QuizCategory.PRAYER_WUDU,
            difficulty = Difficulty.EASY,
            question = "Hoeveel keer per dag bidt een moslim?",
            answers = listOf("3", "4", "5", "7"),
            correctAnswerIndex = 2,
            explanation = "Een moslim bidt vijf keer per dag: Fajr, Dhuhr, ʿAṣr, Maghrib en ʿIshā'.",
            hint = "Het is een van de vijf zuilen van de islam.",
            extraHint = "De gebedstijden zijn verbonden aan de stand van de zon.",
            sourceCategory = "Fiqh/ʿIbādah"
        ),

        Question(
            id = 22,
            category = QuizCategory.PRAYER_WUDU,
            difficulty = Difficulty.EASY,
            question = "Wat is de eerste stap van de wuḍū'?",
            answers = listOf("Wassen van het gezicht", "Niyyah (intentie)", "Wassen van de handen", "Wassen van de voeten"),
            correctAnswerIndex = 1,
            explanation = "De intentie (niyyah) is de eerste stap van de wuḍū', hoewel het wassen van de handen ook tot de handelingen behoort.",
            hint = "Het begint in het hart.",
            extraHint = "Zonder intentie is de wuḍū' niet geldig.",
            sourceCategory = "Fiqh"
        ),

        Question(
            id = 23,
            category = QuizCategory.PRAYER_WUDU,
            difficulty = Difficulty.EASY,
            question = "Hoe heet de algemene oproep die het begin van de gebedstijd aankondigt?",
            answers = listOf("Iqāmah", "Adhān", "Dhikr", "Tasbīḥ"),
            correctAnswerIndex = 1,
            explanation = "De adhān kondigt aan dat de gebedstijd is binnengekomen. De iqāmah is de aankondiging vlak vóór het gezamenlijke gebed begint.",
            hint = "Je hoort dit uitroepen van de minaret.",
            extraHint = "De eerste adhān werd uitgesproken door Bilāl ibn Rabāḥ رضي الله عنه.",
            sourceCategory = "Fiqh/Seerah"
        ),

        Question(
            id = 24,
            category = QuizCategory.PRAYER_WUDU,
            difficulty = Difficulty.EASY,
            question = "Hoe heet het vrijdaggebed?",
            answers = listOf("ʿĪd-gebed", "Jumuʿah-gebed", "Tarāwīḥ-gebed", "Tahajjud-gebed"),
            correctAnswerIndex = 1,
            explanation = "Het vrijdaggebed heet het Jumuʿah-gebed.",
            hint = "Vrijdag heet in het Arabisch Yawm al-Jumuʿah.",
            extraHint = "Het vervangt het Dhuhr-gebed op vrijdag.",
            sourceCategory = "Fiqh"
        ),

        Question(
            id = 25,
            category = QuizCategory.PRAYER_WUDU,
            difficulty = Difficulty.EASY,
            question = "Wat is de richting waarin moslims bidden?",
            answers = listOf("Jeruzalem", "Makkah", "Madinah", "Cairo"),
            correctAnswerIndex = 1,
            explanation = "Moslims bidden in de richting van de Kaʿbah in Makkah, de qiblah.",
            hint = "Hier staat de Kaʿbah.",
            extraHint = "De richting heet 'qiblah'.",
            sourceCategory = "Fiqh"
        ),

        Question(
            id = 26,
            category = QuizCategory.PRAYER_WUDU,
            difficulty = Difficulty.MEDIUM,
            question = "Hoeveel rakaʿāt heeft het Fajr-gebed?",
            answers = listOf("2", "3", "4", "5"),
            correctAnswerIndex = 0,
            explanation = "Het Fajr-gebed bestaat uit 2 verplichte rakaʿāt (farḍ).",
            hint = "Het is het kortste verplichte gebed.",
            extraHint = "De sunnah voor Fajr telt ook 2 rakaʿāt.",
            sourceCategory = "Fiqh"
        ),

        Question(
            id = 27,
            category = QuizCategory.PRAYER_WUDU,
            difficulty = Difficulty.MEDIUM,
            question = "Welke van de volgende dingen verbreekt de wuḍū'?",
            answers = listOf("Lachen", "Urineren of ontlasting", "Eten", "Slapen zittend rechtop"),
            correctAnswerIndex = 1,
            explanation = "Urineren of ontlasting verbreekt de wuḍū'. Over sommige andere punten zijn er meningsverschillen.",
            hint = "Denk aan iets dat vuil of onrein is.",
            extraHint = "Dit is een van de duidelijkste gevallen.",
            sourceCategory = "Fiqh"
        ),

        Question(
            id = 28,
            category = QuizCategory.PRAYER_WUDU,
            difficulty = Difficulty.MEDIUM,
            question = "Wat is tayammum?",
            answers = listOf("Een speciaal nachtgebed", "Een rituele reiniging met aarde of natuurlijke ondergrond wanneer water niet gebruikt kan worden", "Een vorm van dhikr", "De gebedsniche in de moskee"),
            correctAnswerIndex = 1,
            explanation = "Tayammum is een rituele reiniging zonder water. Men gebruikt schone aarde of een natuurlijke ondergrond en veegt daarmee over gezicht en handen. In bepaalde situaties vervangt het wuḍū' of zelfs ghusl.",
            hint = "Het is een verlichte regeling voor bijzondere omstandigheden.",
            extraHint = "Het is toegestaan bij ziekte, reizen of gebrek aan water.",
            sourceCategory = "Fiqh"
        ),

        Question(
            id = 29,
            category = QuizCategory.PRAYER_WUDU,
            difficulty = Difficulty.MEDIUM,
            question = "Hoe heet het nachtgebed dat vrijwillig is?",
            answers = listOf("Dhuhr", "Tahajjud", "ʿAṣr", "Witr"),
            correctAnswerIndex = 1,
            explanation = "Tahajjud is een vrijwillig nachtgebed dat na het slapen wordt verricht.",
            hint = "De Profeet ﷺ verrichtte dit gebed regelmatig.",
            extraHint = "Het is bijzonder gewaardeerd in de nacht.",
            sourceCategory = "Fiqh/Sunnah"
        ),

        Question(
            id = 30,
            category = QuizCategory.PRAYER_WUDU,
            difficulty = Difficulty.HARD,
            question = "Hoeveel rakaʿāt heeft het ʿIshā'-gebed?",
            answers = listOf("2 farḍ", "3 farḍ", "4 farḍ", "5 farḍ"),
            correctAnswerIndex = 2,
            explanation = "Het ʿIshā'-gebed heeft 4 verplichte rakaʿāt.",
            hint = "Het is een van de langere verplichte gebeden.",
            extraHint = "Er worden ook sunnah-rakaʿāt bij verricht.",
            sourceCategory = "Fiqh"
        ),

        Question(
            id = 31,
            category = QuizCategory.PROPHETS,
            difficulty = Difficulty.EASY,
            question = "Wie is de laatste profeet in de islam?",
            answers = listOf("ʿĪsā عليه السلام", "Mūsā عليه السلام", "Muḥammad ﷺ", "Ibrāhīm عليه السلام"),
            correctAnswerIndex = 2,
            explanation = "Muḥammad ﷺ is de laatste en afsluiter van de profeten.",
            hint = "Hij werd gezonden naar de gehele mensheid.",
            extraHint = "Hij wordt Khātam al-Anbiyā' genoemd.",
            sourceCategory = "Aqeedah"
        ),

        Question(
            id = 32,
            category = QuizCategory.PROPHETS,
            difficulty = Difficulty.EASY,
            question = "Wie is de vader van de profeten?",
            answers = listOf("Nūḥ عليه السلام", "Ibrāhīm عليه السلام", "Ādam عليه السلام", "Yūsuf عليه السلام"),
            correctAnswerIndex = 1,
            explanation = "Ibrāhīm عليه السلام wordt 'Khalīl Allāh' (vriend van Allah) en de vader van de profeten genoemd.",
            hint = "Hij bouwde de Kaʿbah samen met zijn zoon.",
            extraHint = "Zijn zoon Ismāʿīl عليه السلام is de voorvader van de Arabieren.",
            sourceCategory = "Qur'an/Seerah"
        ),

        Question(
            id = 33,
            category = QuizCategory.PROPHETS,
            difficulty = Difficulty.EASY,
            question = "Welke profeet bouwde de ark?",
            answers = listOf("Ibrāhīm عليه السلام", "Nūḥ عليه السلام", "Mūsā عليه السلام", "Dāwūd عليه السلام"),
            correctAnswerIndex = 1,
            explanation = "Nūḥ عليه السلام bouwde de ark op bevel van Allah om zichzelf en de gelovigen te redden van de vloed.",
            hint = "Hij bouwde een enorm houten schip.",
            extraHint = "Hij predikte 950 jaar.",
            sourceCategory = "Qur'an"
        ),

        Question(
            id = 34,
            category = QuizCategory.PROPHETS,
            difficulty = Difficulty.EASY,
            question = "Welke profeet werd in het vuur gegooid maar bleef ongedeerd?",
            answers = listOf("Mūsā عليه السلام", "Yūsuf عليه السلام", "Ibrāhīm عليه السلام", "Dāwūd عليه السلام"),
            correctAnswerIndex = 2,
            explanation = "Ibrāhīm عليه السلام werd in het vuur gegooid door Nimrod, maar Allah maakte het vuur koel en veilig voor hem.",
            hint = "Allah bevool het vuur koel te zijn.",
            extraHint = "Dit staat vermeld in Surah Al-Anbiyā'.",
            sourceCategory = "Qur'an 21:69"
        ),

        Question(
            id = 35,
            category = QuizCategory.PROPHETS,
            difficulty = Difficulty.EASY,
            question = "Welke profeet werd in de buik van een vis geplaatst?",
            answers = listOf("Nūḥ عليه السلام", "Yūnus عليه السلام", "Ayyūb عليه السلام", "Ilyās عليه السلام"),
            correctAnswerIndex = 1,
            explanation = "Yūnus عليه السلام werd in de buik van een grote vis geplaatst nadat hij zijn volk verliet.",
            hint = "Hij bad in het donker.",
            extraHint = "Hij wordt ook Dhū al-Nūn (de man van de vis) genoemd.",
            sourceCategory = "Qur'an"
        ),

        Question(
            id = 36,
            category = QuizCategory.PROPHETS,
            difficulty = Difficulty.MEDIUM,
            question = "Welke profeet werd bekend om zijn geduld bij ziekte?",
            answers = listOf("Yūnus عليه السلام", "Ayyūb عليه السلام", "Ibrāhīm عليه السلام", "Yaʿqūb عليه السلام"),
            correctAnswerIndex = 1,
            explanation = "Ayyūb عليه السلام staat bekend om zijn geduld (ṣabr) gedurende zijn zware beproevingen.",
            hint = "Hij leed lang aan een ziekte.",
            extraHint = "Allah herstelde hem en gaf hem meer dan voorheen.",
            sourceCategory = "Qur'an"
        ),

        Question(
            id = 37,
            category = QuizCategory.PROPHETS,
            difficulty = Difficulty.MEDIUM,
            question = "Welke profeet is de vader van Ibrāhīm عليه السلام?",
            answers = listOf("Āzar", "Nūḥ عليه السلام", "Sālih عليه السلام", "Lūṭ عليه السلام"),
            correctAnswerIndex = 0,
            explanation = "Āzar was de vader (of oom, volgens sommige geleerden) van Ibrāhīm عليه السلام.",
            hint = "Hij maakte en aanbad afgodsbeelden.",
            extraHint = "Ibrāhīm confronteerde zijn vader over de afgoderij.",
            sourceCategory = "Qur'an"
        ),

        Question(
            id = 38,
            category = QuizCategory.PROPHETS,
            difficulty = Difficulty.MEDIUM,
            question = "Welke profeet had de gave om dieren en mensen te begrijpen?",
            answers = listOf("Dāwūd عليه السلام", "Sulaymān عليه السلام", "Yūsuf عليه السلام", "Mūsā عليه السلام"),
            correctAnswerIndex = 1,
            explanation = "Sulaymān عليه السلام had de gave om de taal van dieren en mensen te begrijpen.",
            hint = "Hij had ook macht over de wind en de djinn.",
            extraHint = "Het verhaal van de mieren staat in Surah An-Naml.",
            sourceCategory = "Qur'an"
        ),



        Question(
            id = 40,
            category = QuizCategory.PROPHETS,
            difficulty = Difficulty.HARD,
            question = "Welke profeet sprak als baby in de wieg?",
            answers = listOf("Yaḥyā عليه السلام", "ʿĪsā عليه السلام", "Mūsā عليه السلام", "Ibrāhīm عليه السلام"),
            correctAnswerIndex = 1,
            explanation = "ʿĪsā عليه السلام sprak als baby in de wieg om zijn moeder Maryam te verdedigen.",
            hint = "Dit is een van de wonderen van deze profeet.",
            extraHint = "Dit staat in Surah Maryam en Surah Āl ʿImrān.",
            sourceCategory = "Qur'an"
        ),

        Question(
            id = 41,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.EASY,
            question = "In welke stad werd de Profeet Muḥammad ﷺ geboren?",
            answers = listOf("Madinah", "Jeruzalem", "Makkah", "Tā'if"),
            correctAnswerIndex = 2,
            explanation = "De Profeet Muḥammad ﷺ werd geboren in Makkah.",
            hint = "Het is de heiligste stad in de islam.",
            extraHint = "Hier staat de Kaʿbah.",
            sourceCategory = "Seerah"
        ),

        Question(
            id = 42,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.EASY,
            question = "Naar welke stad migreerde de Profeet ﷺ bij de Hijrah?",
            answers = listOf("Jeruzalem", "Tā'if", "Madinah", "Makkah"),
            correctAnswerIndex = 2,
            explanation = "De Profeet ﷺ migreerde naar Madinah, toen bekend als Yathrib.",
            hint = "Dit werd het beginpunt van de islamitische kalender.",
            extraHint = "De stad werd daarna 'Stad van de Profeet' (Madīnat al-Nabī) genoemd.",
            sourceCategory = "Seerah"
        ),

        Question(
            id = 43,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.EASY,
            question = "Hoe oud was de Profeet ﷺ toen hij de eerste openbaring ontving?",
            answers = listOf("25 jaar", "35 jaar", "40 jaar", "45 jaar"),
            correctAnswerIndex = 2,
            explanation = "De Profeet ﷺ was 40 jaar oud toen hij de eerste openbaring ontving in de grot van Hirā'.",
            hint = "Het was een volwassen leeftijd.",
            extraHint = "De eerste geopenbaarde woorden waren 'Iqra' (Lees!).",
            sourceCategory = "Seerah"
        ),

        Question(
            id = 44,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.EASY,
            question = "Wie was de eerste vrouw die de islam omarmde?",
            answers = listOf("Fāṭimah رضي الله عنها", "ʿĀ'ishah رضي الله عنها", "Khadījah رضي الله عنها", "Zaynab رضي الله عنها"),
            correctAnswerIndex = 2,
            explanation = "Khadījah رضي الله عنها was de eerste persoon die de islam omarmde.",
            hint = "Zij was de eerste echtgenote van de Profeet ﷺ.",
            extraHint = "Zij was een rijke en gerespecteerde zakenvrouw.",
            sourceCategory = "Seerah"
        ),

        Question(
            id = 45,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.EASY,
            question = "In welk jaar vond de Isrā' wal-Miʿrāj plaats?",
            answers = listOf("Vóór de Hijrah, circa jaar 10 van het profeetschap", "Na de Hijrah, jaar 2", "Na de Hijrah, jaar 5", "Vóór de Hijrah, jaar 1"),
            correctAnswerIndex = 0,
            explanation = "De Isrā' wal-Miʿrāj vond plaats circa het 10e jaar van het profeetschap, vóór de Hijrah.",
            hint = "Het was een moeilijke periode voor de Profeet ﷺ.",
            extraHint = "De vijf gebeden werden tijdens deze nachtreis verplicht.",
            sourceCategory = "Seerah"
        ),

        Question(
            id = 46,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Hoe heet de stam van de Profeet ﷺ?",
            answers = listOf("Al-Aws", "Quraysh", "Al-Khazraj", "Banū Hāshim"),
            correctAnswerIndex = 1,
            explanation = "De Profeet ﷺ behoorde tot de stam Quraysh, en meer specifiek tot de clan Banū Hāshim.",
            hint = "Dit is een bekende Arabische stam.",
            extraHint = "Zijn clan Banū Hāshim behoorde tot de Quraysh.",
            sourceCategory = "Seerah"
        ),

        Question(
            id = 47,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Wie was de oom van de Profeet ﷺ die hem beschermde maar niet moslim werd?",
            answers = listOf("Ḥamzah رضي الله عنه", "Abū Ṭālib", "ʿAbbās رضي الله عنه", "Abū Lahab"),
            correctAnswerIndex = 1,
            explanation = "Abū Ṭālib beschermde de Profeet ﷺ zijn hele leven maar stierf zonder de shahādah uit te spreken.",
            hint = "Hij was de vader van ʿAlī رضي الله عنه.",
            extraHint = "Zijn dood was een groot verdriet voor de Profeet ﷺ.",
            sourceCategory = "Seerah"
        ),

        Question(
            id = 48,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Hoe heet de eerste slag in de islamitische geschiedenis?",
            answers = listOf("Slag van Uḥud", "Slag van Badr", "Slag van Khandaq", "Slag van Ḥunayn"),
            correctAnswerIndex = 1,
            explanation = "De Slag van Badr was de eerste grote slag in de islamitische geschiedenis, in het jaar 2 na de Hijrah.",
            hint = "Het was een overwinning voor de moslims.",
            extraHint = "De moslims waren sterk in de minderheid.",
            sourceCategory = "Seerah"
        ),

        Question(
            id = 49,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.HARD,
            question = "Hoeveel jaar duurde de profetische missie van de Profeet ﷺ?",
            answers = listOf("10 jaar", "15 jaar", "23 jaar", "30 jaar"),
            correctAnswerIndex = 2,
            explanation = "De profetische missie duurde 23 jaar: 13 jaar in Makkah en 10 jaar in Madinah.",
            hint = "Het begon op zijn 40e en eindigde op zijn 63e.",
            extraHint = "13 jaar Makkah + 10 jaar Madinah.",
            sourceCategory = "Seerah"
        ),

        Question(
            id = 50,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.HARD,
            question = "Hoe heet de verdrag dat de Profeet ﷺ sloot bij Ḥudaybiyyah?",
            answers = listOf("Verdrag van Aqabah", "Verdrag van Ḥudaybiyyah", "Verdrag van Madinah", "Verdrag van Tā'if"),
            correctAnswerIndex = 1,
            explanation = "Het Verdrag van Ḥudaybiyyah was een tijdelijk vredesakkoord tussen de moslims en Quraysh.",
            hint = "Het leek aanvankelijk een verlies maar was een grote overwinning.",
            extraHint = "Allah noemde het een 'duidelijke overwinning' in de Qur'an.",
            sourceCategory = "Seerah/Qur'an 48:1"
        ),

        Question(
            id = 51,
            category = QuizCategory.SAHABA,
            difficulty = Difficulty.EASY,
            question = "Wie was de eerste kalief na de Profeet ﷺ?",
            answers = listOf("ʿUmar ibn al-Khaṭṭāb رضي الله عنه", "Abū Bakr al-Ṣiddīq رضي الله عنه", "ʿUthmān ibn ʿAffān رضي الله عنه", "ʿAlī ibn Abī Ṭālib رضي الله عنه"),
            correctAnswerIndex = 1,
            explanation = "Abū Bakr al-Ṣiddīq رضي الله عنه was de eerste kalief na het overlijden van de Profeet ﷺ.",
            hint = "Hij was de beste vriend van de Profeet ﷺ.",
            extraHint = "Hij wordt al-Ṣiddīq (de oprechte) genoemd.",
            sourceCategory = "Seerah/Sahaba"
        ),

        Question(
            id = 52,
            category = QuizCategory.SAHABA,
            difficulty = Difficulty.EASY,
            question = "Wie wordt 'Sayf Allah' (Zwaard van Allah) genoemd?",
            answers = listOf("Khālid ibn al-Walīd رضي الله عنه", "ʿAlī ibn Abī Ṭālib رضي الله عنه", "ʿUmar رضي الله عنه", "Muʿādh ibn Jabal رضي الله عنه"),
            correctAnswerIndex = 0,
            explanation = "Khālid ibn al-Walīd رضي الله عنه werd door de Profeet ﷺ 'Sayf Allāh' (Zwaard van Allah) genoemd.",
            hint = "Hij was een groot militaire strateeg.",
            extraHint = "Hij verloor nooit een slag.",
            sourceCategory = "Sahaba"
        ),

        Question(
            id = 53,
            category = QuizCategory.SAHABA,
            difficulty = Difficulty.EASY,
            question = "Wie was de muezzin van de Profeet ﷺ?",
            answers = listOf("Salmān al-Fārisī رضي الله عنه", "Bilāl ibn Rabāḥ رضي الله عنه", "Abū Hurayrah رضي الله عنه", "ʿAbdullāh ibn Masʿūd رضي الله عنه"),
            correctAnswerIndex = 1,
            explanation = "Bilāl ibn Rabāḥ رضي الله عنه was de eerste en meest bekende muezzin van de Profeet ﷺ.",
            hint = "Hij was een bevrijde slaaf.",
            extraHint = "Hij stond bekend om zijn krachtige stem.",
            sourceCategory = "Sahaba/Seerah"
        ),

        Question(
            id = 54,
            category = QuizCategory.SAHABA,
            difficulty = Difficulty.MEDIUM,
            question = "Wie wordt beschouwd als de grootste overdrager van ḥadīths?",
            answers = listOf("ʿĀ'ishah رضي الله عنها", "Abū Bakr رضي الله عنه", "Abū Hurayrah رضي الله عنه", "ʿAbdullāh ibn ʿUmar رضي الله عنه"),
            correctAnswerIndex = 2,
            explanation = "Abū Hurayrah رضي الله عنه is de grootste overdrager van ḥadīths met meer dan 5.000 overleveringen.",
            hint = "Hij staat bekend om zijn sterke geheugen.",
            extraHint = "Hij kwam pas laat tot de islam maar was daarna altijd bij de Profeet ﷺ.",
            sourceCategory = "Hadith/Sahaba"
        ),

        Question(
            id = 55,
            category = QuizCategory.SAHABA,
            difficulty = Difficulty.MEDIUM,
            question = "Welke sahābi verzamelde de Qur'an in één mushaf?",
            answers = listOf("Abū Bakr رضي الله عنه (initiatiefnemer)", "ʿUmar رضي الله عنه", "ʿUthmān رضي الله عنه (standaardisatie)", "Zayd ibn Thābit رضي الله عنه (schrijver)"),
            correctAnswerIndex = 3,
            explanation = "Zayd ibn Thābit رضي الله عنه was de hoofdschrijver die de Qur'an bij elkaar verzamelde onder leiding van Abū Bakr رضي الله عنه.",
            hint = "Hij was de persoonlijke schrijver van de Profeet ﷺ.",
            extraHint = "Later standaardiseerde ʿUthmān رضي الله عنه de mushaf.",
            sourceCategory = "Sahaba/Seerah"
        ),

        Question(
            id = 56,
            category = QuizCategory.SAHABA,
            difficulty = Difficulty.HARD,
            question = "Wie is de sahābi die bekend staat als 'Amīn al-Ummah' (vertrouwensman van de gemeenschap)?",
            answers = listOf("Abū Bakr رضي الله عنه", "Abū ʿUbaydah ibn al-Jarrāḥ رضي الله عنه", "Ṭalḥah رضي الله عنه", "Al-Zubayr رضي الله عنه"),
            correctAnswerIndex = 1,
            explanation = "Abū ʿUbaydah ibn al-Jarrāḥ رضي الله عنه werd door de Profeet ﷺ 'Amīn al-Ummah' (vertrouwensman van deze gemeenschap) genoemd.",
            hint = "Hij is een van de tien die beloofd zijn met het paradijs.",
            extraHint = "Hij is niet de bekendste van de vier kaliefen.",
            sourceCategory = "Sahaba"
        ),

        Question(
            id = 57,
            category = QuizCategory.SAHABA,
            difficulty = Difficulty.HARD,
            question = "Wie schreef de Qur'an-verzen op voor de Profeet ﷺ?",
            answers = listOf("Alleen Zayd ibn Thābit", "Meerdere schrijvers, waaronder Zayd, Muʿāwiyah en anderen", "Alleen ʿAlī رضي الله عنه", "Alleen Abū Bakr رضي الله عنه"),
            correctAnswerIndex = 1,
            explanation = "Er waren meerdere schrijvers van de openbaring (kuttāb al-waḥy), waaronder Zayd ibn Thābit, Muʿāwiyah ibn Abī Sufyān, Ubayy ibn Kaʿb en anderen.",
            hint = "Er waren meerdere sahābah die voor de Profeet ﷺ schreven.",
            extraHint = "Zayd ibn Thābit was de meest prominente.",
            sourceCategory = "Seerah/Sahaba"
        ),

        Question(
            id = 58,
            category = QuizCategory.SAHABA,
            difficulty = Difficulty.HARD,
            question = "Wie zijn de 'Tien die beloofden met het paradijs' (Al-ʿAsharah al-Mubashsharūn)?",
            answers = listOf("Alleen de vier kaliefen", "De vier kaliefen plus zes anderen", "De tien beste generaals", "De tien eerste moslims"),
            correctAnswerIndex = 1,
            explanation = "De tien met paradijsbelofte zijn de vier kaliefen plus: Ṭalḥah, Al-Zubayr, ʿAbd al-Raḥmān ibn ʿAwf, Saʿd ibn Abī Waqqāṣ, Saʿīd ibn Zayd en Abū ʿUbaydah.",
            hint = "Ze worden samen vermeld in een bekende ḥadīth.",
            extraHint = "De vier kaliefen zijn er ook bij inbegrepen.",
            sourceCategory = "Sahaba/Hadith"
        ),

        Question(
            id = 59,
            category = QuizCategory.RAMADAN,
            difficulty = Difficulty.EASY,
            question = "In welke maand vasten moslims?",
            answers = listOf("Shawwāl", "Rajab", "Ramadan", "Dhul-Hijjah"),
            correctAnswerIndex = 2,
            explanation = "Moslims vasten in de heilige maand Ramadan.",
            hint = "Het is de negende maand van de islamitische kalender.",
            extraHint = "In deze maand werd de Qur'an geopenbaard.",
            sourceCategory = "Fiqh/Qur'an"
        ),

        Question(
            id = 60,
            category = QuizCategory.RAMADAN,
            difficulty = Difficulty.EASY,
            question = "Wat is de naam van de maaltijd vóór de dageraad in Ramadan?",
            answers = listOf("Iftār", "Saḥūr", "Tarāwīḥ", "Qiyām"),
            correctAnswerIndex = 1,
            explanation = "De Saḥūr is de maaltijd vóór de dageraad (Fajr) waarmee het vasten begint.",
            hint = "Het is aanbevolen te doen.",
            extraHint = "De Profeet ﷺ raadde aan dit niet te vergeten.",
            sourceCategory = "Fiqh/Ramadan"
        ),

        Question(
            id = 61,
            category = QuizCategory.RAMADAN,
            difficulty = Difficulty.EASY,
            question = "Wat is de naam van het verbreken van het vasten?",
            answers = listOf("Saḥūr", "Tarāwīḥ", "Iftār", "Witr"),
            correctAnswerIndex = 2,
            explanation = "Het verbreken van het vasten bij zonsondergang heet iftār.",
            hint = "Je doet het als de zon ondergaat.",
            extraHint = "Het wordt aanbevolen met dadels te beginnen.",
            sourceCategory = "Fiqh/Ramadan"
        ),

        Question(
            id = 62,
            category = QuizCategory.RAMADAN,
            difficulty = Difficulty.EASY,
            question = "Welke nacht in Ramadan is beter dan duizend maanden?",
            answers = listOf("De eerste nacht", "De vijftiende nacht", "Laylat al-Qadr", "De laatste vrijdagnacht"),
            correctAnswerIndex = 2,
            explanation = "Laylat al-Qadr is beter dan duizend maanden, zoals de Qur'an vermeldt.",
            hint = "Het wordt in de laatste tien nachten gezocht.",
            extraHint = "Surah Al-Qadr beschrijft deze nacht.",
            sourceCategory = "Qur'an 97"
        ),

        Question(
            id = 63,
            category = QuizCategory.RAMADAN,
            difficulty = Difficulty.EASY,
            question = "Hoe worden de nachtgebeden genoemd die in Ramadan meestal direct na ʿIshā' gezamenlijk in de moskee worden gebeden?",
            answers = listOf("Tahajjud", "Witr", "Tarāwīḥ", "Qiyām al-Layl"),
            correctAnswerIndex = 2,
            explanation = "Tarāwīḥ is de bekende benaming voor de extra nachtgebeden na ʿIshā' in Ramadan. Qiyām al-Layl is een bredere term voor nachtgebed, en tahajjud wordt vaak gebruikt voor nachtgebed later in de nacht.",
            hint = "Deze gebeden worden vaak direct na ʿIshā' in Ramadan gebeden.",
            extraHint = "Het gaat hier niet om algemene qiyām al-layl of tahajjud later in de nacht, maar om de bekende Ramadan-gebeden na ʿIshā'.",
            sourceCategory = "Fiqh/Ramadan"
        ),

        Question(
            id = 64,
            category = QuizCategory.RAMADAN,
            difficulty = Difficulty.MEDIUM,
            question = "Wat is Iʿtikāf?",
            answers = listOf("Een bijzonder gebed op vrijdag", "Terugtrekken in de moskee voor aanbidding", "Een vorm van vasten", "De zakāt van Ramadan"),
            correctAnswerIndex = 1,
            explanation = "Iʿtikāf is het terugtrekken in de moskee voor aanbidding, met name in de laatste tien nachten van Ramadan.",
            hint = "Het wordt aanbevolen in de laatste tien nachten.",
            extraHint = "De Profeet ﷺ deed dit elke Ramadan.",
            sourceCategory = "Fiqh/Ramadan"
        ),

        Question(
            id = 65,
            category = QuizCategory.RAMADAN,
            difficulty = Difficulty.MEDIUM,
            question = "Wat is zakāt al-fiṭr?",
            answers = listOf("De zakāt die altijd verplicht is", "Een verplichte liefdadigheid aan het einde van Ramadan", "Een feestmaaltijd", "Een extra gebed"),
            correctAnswerIndex = 1,
            explanation = "Zakāt al-fiṭr is de verplichte liefdadigheid die aan het einde van Ramadan, vóór het ʿĪd-gebed, gegeven moet worden.",
            hint = "Het wordt vóór het ʿĪd al-Fiṭr-gebed gegeven.",
            extraHint = "Het zuivert het vasten van tekortkomingen.",
            sourceCategory = "Fiqh/Ramadan"
        ),

        Question(
            id = 66,
            category = QuizCategory.RAMADAN,
            difficulty = Difficulty.HARD,
            question = "In welke van de laatste tien nachten zoeken moslims Laylat al-Qadr?",
            answers = listOf("Alleen de 27e nacht", "De oneven nachten", "Alle tien nachten gelijk", "Alleen de eerste vijf"),
            correctAnswerIndex = 1,
            explanation = "Moslims zoeken Laylat al-Qadr in de oneven nachten van de laatste tien nachten van Ramadan (21, 23, 25, 27, 29).",
            hint = "De Profeet ﷺ raadde aan in oneven nachten te zoeken.",
            extraHint = "De 27e nacht is bijzonder populair maar niet zeker.",
            sourceCategory = "Hadith/Ramadan"
        ),

        Question(
            id = 67,
            category = QuizCategory.HADITH,
            difficulty = Difficulty.EASY,
            question = "Welke beroemde hadithverzameling heeft de bijnaam 'Al-Ṣaḥīḥayn' (de twee authentieke)?",
            answers = listOf("Abū Dāwūd en Tirmidhī", "Ṣaḥīḥ al-Bukhārī en Ṣaḥīḥ Muslim", "Ibn Mājah en Nasā'ī", "Mālik en Aḥmad"),
            correctAnswerIndex = 1,
            explanation = "Al-Ṣaḥīḥayn verwijst naar Ṣaḥīḥ al-Bukhārī en Ṣaḥīḥ Muslim, de twee meest gezaghebbende hadithverzamelingen.",
            hint = "Ze worden samen als de meest betrouwbare beschouwd.",
            extraHint = "De auteurs zijn al-Bukhārī en Muslim.",
            sourceCategory = "Hadith"
        ),

        Question(
            id = 68,
            category = QuizCategory.HADITH,
            difficulty = Difficulty.EASY,
            question = "Wat is de bekende hadith die zegt dat acties beoordeeld worden op basis van intenties?",
            answers = listOf("Hadith Jibrīl", "Hadith al-Niyyah", "Hadith al-Arbaʿīn", "Hadith Muʿādh"),
            correctAnswerIndex = 1,
            explanation = "De hadith 'Innamā al-aʿmāl bil-niyyāt' (Acties worden beoordeeld op basis van intenties) staat bekend als Hadith al-Niyyah.",
            hint = "Het begint met 'Innamā al-aʿmāl...'.",
            extraHint = "Het is de eerste hadith in Ṣaḥīḥ al-Bukhārī.",
            sourceCategory = "Hadith"
        ),

        Question(
            id = 69,
            category = QuizCategory.HADITH,
            difficulty = Difficulty.MEDIUM,
            question = "Hoeveel hadiths bevat de bekende volledige versie van Al-Arbaʿīn an-Nawawiyyah?",
            answers = listOf("40", "41", "42", "50"),
            correctAnswerIndex = 2,
            explanation = "De titel Al-Arbaʿīn betekent 'de veertig', maar de bekende volledige versie van deze verzameling bevat 42 hadiths.",
            hint = "Al-Arbaʿīn betekent 'de veertig'.",
            extraHint = "Imām al-Nawawī schreef dit werk.",
            sourceCategory = "Hadith"
        ),

        Question(
            id = 70,
            category = QuizCategory.HADITH,
            difficulty = Difficulty.MEDIUM,
            question = "Wat zijn de Kutub al-Sittah?",
            answers = listOf("De zes gezaghebbende hadithverzamelingen", "De zes zuilen van het geloof", "De zes boeken van fiqh", "De zes meest bekende surahs"),
            correctAnswerIndex = 0,
            explanation = "Kutub al-Sittah zijn de zes gezaghebbende hadithverzamelingen: Bukhārī, Muslim, Abū Dāwūd, Tirmidhī, Nasā'ī en Ibn Mājah.",
            hint = "Sittah betekent zes.",
            extraHint = "Bukhārī en Muslim zijn de meest gezaghebbende van de zes.",
            sourceCategory = "Hadith"
        ),

        Question(
            id = 71,
            category = QuizCategory.HADITH,
            difficulty = Difficulty.HARD,
            question = "Wat is een ḥadīth qudsī?",
            answers = listOf("Een ḥadīth met een zwakke keten", "Een ḥadīth waarbij Allah spreekt via de Profeet ﷺ maar het geen Qur'an is", "Een ḥadīth over de Kaʿbah", "Een ḥadīth uit Ṣaḥīḥ al-Bukhārī"),
            correctAnswerIndex = 1,
            explanation = "Een ḥadīth qudsī is een overlevering waarbij de Profeet ﷺ de woorden van Allah overbrengt, maar het is geen deel van de Qur'an.",
            hint = "De inhoud is van Allah, de woorden zijn van de Profeet ﷺ.",
            extraHint = "Het is anders dan de Qur'an qua openbaring.",
            sourceCategory = "Hadith/Ulum al-Hadith"
        ),

        Question(
            id = 72,
            category = QuizCategory.HADITH,
            difficulty = Difficulty.HARD,
            question = "Wat is de isnad van een ḥadīth?",
            answers = listOf("De tekst van de ḥadīth", "De keten van overleveraars", "De verklaring van de ḥadīth", "De categorie van de ḥadīth"),
            correctAnswerIndex = 1,
            explanation = "De isnad is de keten van overleveraars die een ḥadīth terugvoert tot de Profeet ﷺ.",
            hint = "Het is de schakelketen van mensen.",
            extraHint = "De tekst zelf heet matn.",
            sourceCategory = "Hadith/Ulum al-Hadith"
        ),

        Question(
            id = 73,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.EASY,
            question = "Wat zijn de vijf zuilen van de islam?",
            answers = listOf("Shahādah, ṣalāh, zakāh, ṣawm, ḥajj", "Shahādah, zakāh, ṣawm, ḥajj, jiḥād", "Ṣalāh, ṣawm, ḥajj, zakāh, dhikr", "Shahādah, ṣalāh, ḥajj, ṣawm, ṣadaqah"),
            correctAnswerIndex = 0,
            explanation = "De vijf zuilen van de islam zijn: shahādah (getuigenis), ṣalāh (gebed), zakāh (armenbelasting), ṣawm (vasten) en ḥajj (pelgrimstocht).",
            hint = "Denk aan de fundament van het islamitisch geloof en handelen.",
            extraHint = "Ze worden vermeld in de bekende ḥadīth over de zuilen.",
            sourceCategory = "Aqeedah/Fiqh"
        ),

        Question(
            id = 74,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.EASY,
            question = "Wat zijn de zes zuilen van het geloof (īmān)?",
            answers = listOf("Allah, engelen, boeken, profeten, Dag des Oordeels, Goddelijke Beschikking", "Allah, Qur'an, gebeden, vasten, ḥajj, zakāh", "Engelen, djinn, mensen, dieren, planten, stenen", "Qur'an, Sunnah, ijmāʿ, qiyās, istiḥsān, ʿurf"),
            correctAnswerIndex = 0,
            explanation = "De zes zuilen van het geloof zijn: geloof in Allah, Zijn engelen, Zijn boeken, Zijn profeten, de Dag des Oordeels en de Goddelijke Beschikking.",
            hint = "Ze zijn vermeld in de hadith van Jibrīl.",
            extraHint = "De zesde zuil is al-qadar.",
            sourceCategory = "Aqeedah"
        ),

        Question(
            id = 75,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.EASY,
            question = "Wat is de kaʿbah?",
            answers = listOf("De heilige moskee in Madinah", "Een kubusvormig gebouw in Makkah dat de qiblah is", "De tombe van de Profeet ﷺ", "De moskee in Jeruzalem"),
            correctAnswerIndex = 1,
            explanation = "De Kaʿbah is een kubusvormig gebouw in Makkah, de Masjid al-Ḥarām, dat de qiblah is voor moslims wereldwijd.",
            hint = "Het is de richting van het gebed.",
            extraHint = "Ibrāhīm en Ismāʿīl bouwden het.",
            sourceCategory = "Fiqh/Seerah"
        ),

        Question(
            id = 76,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.EASY,
            question = "Wat is de shahādah?",
            answers = listOf("Het islamitische vasten", "Het islamitische geloofsbelijdenis", "Het islamitische gebed", "De pelgrimstocht"),
            correctAnswerIndex = 1,
            explanation = "De shahādah is de islamitische geloofsbelijdenis: 'Ik getuig dat er geen god is behalve Allah, en dat Muḥammad Zijn boodschapper is.'",
            hint = "Het is de eerste zuil van de islam.",
            extraHint = "Het uitspreken ervan met overtuiging maakt iemand moslim.",
            sourceCategory = "Aqeedah"
        ),

        Question(
            id = 77,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.MEDIUM,
            question = "Wat is de ḥajj?",
            answers = listOf("Het islamitische vasten in Ramadan", "De jaarlijkse pelgrimstocht naar Makkah", "De islamitische armenbelasting", "Het vrijdaggebed"),
            correctAnswerIndex = 1,
            explanation = "De ḥajj is de jaarlijkse pelgrimstocht naar Makkah, die eenmalig verplicht is voor elke moslim die daartoe in staat is.",
            hint = "Het vindt plaats in de maand Dhul-Hijjah.",
            extraHint = "Het is de vijfde zuil van de islam.",
            sourceCategory = "Fiqh"
        ),

        Question(
            id = 78,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.MEDIUM,
            question = "Wat is zakāh?",
            answers = listOf("Vrijwillige liefdadigheid", "Verplichte liefdadigheid voor wie aan de voorwaarden voldoet", "Het islamitische gebed", "Het vasten in Ramadan"),
            correctAnswerIndex = 1,
            explanation = "Zakāh is een verplichte vorm van geven aan rechthebbenden voor moslims die aan bepaalde voorwaarden voldoen.",
            hint = "Het is één van de vijf zuilen van de islam.",
            extraHint = "Het gaat niet om vrijwillige liefdadigheid, maar om een verplichte vorm van geven onder voorwaarden.",
            sourceCategory = "Fiqh"
        ),

        Question(
            id = 79,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.MEDIUM,
            question = "Wat is tawḥīd?",
            answers = listOf("Het islamitische gebed", "De eenheid van Allah", "De ḥajj", "De islamitische wet"),
            correctAnswerIndex = 1,
            explanation = "Tawḥīd betekent de eenheid en uniciteit van Allah, het fundament van het islamitische geloof.",
            hint = "Het is het fundament van het geloof.",
            extraHint = "Het tegendeel heet shirk.",
            sourceCategory = "Aqeedah"
        ),

        Question(
            id = 80,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.HARD,
            question = "Wat is shirk?",
            answers = listOf("Berouw", "Deelgenoten aan Allah toeschrijven", "Het islamitische gebed", "Liefdadigheid"),
            correctAnswerIndex = 1,
            explanation = "Shirk betekent deelgenoten of medegoden aan Allah toeschrijven, de grootste zonde in de islam.",
            hint = "Het is het tegendeel van tawḥīd.",
            extraHint = "Shirk is de enige zonde die Allah niet vergeeft als iemand ermee sterft.",
            sourceCategory = "Aqeedah"
        ),

        Question(
            id = 81,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.HARD,
            question = "Wat zijn de bronnen van de islamitische wet (uṣūl al-fiqh)?",
            answers = listOf("Qur'an en Sunnah alleen", "Qur'an, Sunnah, ijmāʿ en qiyās", "Meningen van alle geleerden samen", "Alleen de vier rechtsscholen"),
            correctAnswerIndex = 1,
            explanation = "De vier hoofdbronnen van de islamitische wet zijn: de Qur'an, de Sunnah, ijmāʿ (consensus) en qiyās (analogie).",
            hint = "De eerste twee zijn de primaire bronnen.",
            extraHint = "Sommige geleerden voegen extra bronnen toe.",
            sourceCategory = "Fiqh/Ulum"
        ),

        Question(
            id = 82,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.HARD,
            question = "Wat zijn de vier grote rechtsscholen (madhāhib) in de soennitische islam?",
            answers = listOf("Ḥanafī, Mālikī, Shāfiʿī, Ḥanbalī", "Ḥanafī, Shīʿī, Sufi, Wahhābī", "Bukhārī, Muslim, Tirmidhī, Nasā'ī", "Ḥanbalī, Zaydī, Ibāḍī, Ismāʿīlī"),
            correctAnswerIndex = 0,
            explanation = "De vier soennitische rechtsscholen zijn: Ḥanafī, Mālikī, Shāfiʿī en Ḥanbalī.",
            hint = "Ze zijn vernoemd naar de vier grote imams.",
            extraHint = "Alle vier zijn geldig en worden gevolgd door moslims wereldwijd.",
            sourceCategory = "Fiqh"
        ),

        Question(
            id = 83,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.MEDIUM,
            question = "Wat zijn de Asmāʾ al-Ḥusnā?",
            answers = listOf("De 99 namen van de Profeet ﷺ", "De 99 mooiste namen van Allah", "De 99 regels van de fiqh", "De 99 ḥadīths van Bukhārī"),
            correctAnswerIndex = 1,
            explanation = "De Asmāʾ al-Ḥusnā zijn de 99 mooiste namen van Allah.",
            hint = "Het zijn namen die Zijn eigenschappen beschrijven.",
            extraHint = "Allah is Al-Raḥmān, Al-Raḥīm, Al-Malik...",
            sourceCategory = "Aqeedah"
        ),

        Question(
            id = 84,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.EASY,
            question = "Wat betekent 'SubḥānAllāh'?",
            answers = listOf("Allah is groot", "Alle lof zij Allah", "Glorie zij Allah/Verheven is Allah", "Er is geen god dan Allah"),
            correctAnswerIndex = 2,
            explanation = "SubḥānAllāh betekent 'Verheven is Allah' of 'Glorie zij Allah'.",
            hint = "Het is een uitdrukking van bewondering en verheffing.",
            extraHint = "Het is een veelgebruikte dhikr.",
            sourceCategory = "Aqeedah/Dhikr"
        ),

        Question(
            id = 85,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.EASY,
            question = "Wat betekent 'AlḥamduliLlāh'?",
            answers = listOf("Alle lof zij Allah", "Er is geen god dan Allah", "Allah is groot", "Verheven is Allah"),
            correctAnswerIndex = 0,
            explanation = "AlḥamduliLlāh betekent 'Alle lof zij Allah'.",
            hint = "Het is een uitdrukking van dankbaarheid.",
            extraHint = "Al-Fātiḥah begint ermee.",
            sourceCategory = "Aqeedah/Dhikr"
        ),

        Question(
            id = 86,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.EASY,
            question = "Wat betekent 'Allāhu Akbar'?",
            answers = listOf("Glorie zij Allah", "Alle lof zij Allah", "Allah is de Grootste", "Er is geen god dan Allah"),
            correctAnswerIndex = 2,
            explanation = "Allāhu Akbar betekent 'Allah is de Grootste'.",
            hint = "Het wordt aan het begin van elk gebed gezegd.",
            extraHint = "Het is ook de openingswoord van de adhān.",
            sourceCategory = "Fiqh/Dhikr"
        ),

        Question(
            id = 87,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.MEDIUM,
            question = "Wat is iḥsān?",
            answers = listOf("Vasten", "Islamitisch recht", "Allah aanbidden alsof je Hem ziet", "Liefdadigheid geven"),
            correctAnswerIndex = 2,
            explanation = "Iḥsān is Allah aanbidden alsof je Hem ziet; en als je Hem niet ziet, weet dat Hij jou ziet.",
            hint = "Dit komt uit de bekende hadith van Jibrīl.",
            extraHint = "Het gaat om perfectie en bewustzijn in aanbidding.",
            sourceCategory = "Hadith"
        ),

        Question(
            id = 88,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.MEDIUM,
            question = "Wat betekent taqwā?",
            answers = listOf("Godsbewustzijn en bescherming tegen zonde", "Rijkdom", "Reizen", "Snel reciteren"),
            correctAnswerIndex = 0,
            explanation = "Taqwā betekent bewustzijn van Allah en jezelf beschermen tegen Zijn ontevredenheid door gehoorzaamheid.",
            hint = "Het wordt vaak vertaald als godsvrees/godsbewustzijn.",
            extraHint = "Het zit in hart en daden.",
            sourceCategory = "Akhlaaq/Aqeedah"
        ),

        Question(
            id = 89,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.HARD,
            question = "Wat zijn de drie niveaus die in de bekende hadith van Jibrīl worden genoemd?",
            answers = listOf("Islam, īmān en iḥsān", "Ṣalāh, zakat en hajj", "Qur'an, hadith en fiqh", "Makkah, Madinah en Quds"),
            correctAnswerIndex = 0,
            explanation = "De bekende hadith van Jibrīl noemt islam, īmān en iḥsān als belangrijke niveaus van de religie.",
            hint = "Deze hadith wordt vaak gezien als samenvatting van de religie.",
            extraHint = "Denk aan het gesprek waarin Jibrīl vragen stelde aan de Profeet ﷺ.",
            sourceCategory = "Hadith"
        ),

        Question(
            id = 90,
            category = QuizCategory.AKHLAAQ,
            difficulty = Difficulty.EASY,
            question = "Welke eigenschap wordt sterk benadrukt in de islam bij ouders?",
            answers = listOf("Goedheid en respect", "Alleen financiële hulp", "Discussie winnen", "Afstand houden"),
            correctAnswerIndex = 0,
            explanation = "Goedheid, respect en zorg voor ouders worden sterk benadrukt in de islam.",
            hint = "Birr al-wālidayn is een grote deugd.",
            extraHint = "De Qur'an noemt goedheid voor ouders vaak naast aanbidding van Allah.",
            sourceCategory = "Qur'an/Akhlaaq"
        ),

        Question(
            id = 91,
            category = QuizCategory.AKHLAAQ,
            difficulty = Difficulty.EASY,
            question = "Wat betekent ṣabr?",
            answers = listOf("Geduld en standvastigheid", "Liefdadigheid", "Gebedsrichting", "Recitatie"),
            correctAnswerIndex = 0,
            explanation = "Ṣabr betekent geduld, volharding en standvastigheid bij gehoorzaamheid, beproeving en het vermijden van zonde.",
            hint = "Het is een belangrijke islamitische eigenschap.",
            extraHint = "Allah prijst de geduldigen.",
            sourceCategory = "Qur'an/Akhlaaq"
        ),

        Question(
            id = 92,
            category = QuizCategory.AKHLAAQ,
            difficulty = Difficulty.EASY,
            question = "Wat betekent shukr?",
            answers = listOf("Dankbaarheid", "Vasten", "Reiniging", "Strijd"),
            correctAnswerIndex = 0,
            explanation = "Shukr betekent dankbaarheid tegenover Allah voor Zijn gunsten.",
            hint = "Dankbaarheid is met hart, tong en daden.",
            extraHint = "Het tegenovergestelde is ondankbaarheid.",
            sourceCategory = "Akhlaaq"
        ),

        Question(
            id = 93,
            category = QuizCategory.AKHLAAQ,
            difficulty = Difficulty.MEDIUM,
            question = "Welke eigenschap hoort bij een betrouwbare moslim?",
            answers = listOf("Amānah", "Hasad", "Kibr", "Ghaflah"),
            correctAnswerIndex = 0,
            explanation = "Amānah betekent betrouwbaarheid en verantwoordelijkheid.",
            hint = "De Profeet ﷺ stond bekend als al-Amīn.",
            extraHint = "Hasad is jaloezie, kibr is hoogmoed.",
            sourceCategory = "Akhlaaq"
        ),

        Question(
            id = 94,
            category = QuizCategory.AKHLAAQ,
            difficulty = Difficulty.MEDIUM,
            question = "Wat betekent ikhlāṣ?",
            answers = listOf("Oprechtheid voor Allah", "Veel geld geven zodat mensen het zien", "Snel bidden", "Alleen Arabisch spreken"),
            correctAnswerIndex = 0,
            explanation = "Ikhlāṣ betekent oprechtheid: daden verrichten omwille van Allah.",
            hint = "Het is een kernvoorwaarde voor aanvaarding van daden.",
            extraHint = "Het tegenovergestelde is riya' of schijnvertoon.",
            sourceCategory = "Akhlaaq/Aqeedah"
        ),

        Question(
            id = 95,
            category = QuizCategory.AKHLAAQ,
            difficulty = Difficulty.MEDIUM,
            question = "Wat betekent riya'?",
            answers = listOf("Schijnvertoon in aanbidding", "Dankbaarheid", "Nederigheid", "Vergeving vragen"),
            correctAnswerIndex = 0,
            explanation = "Riya' betekent goede daden doen om door mensen gezien of geprezen te worden.",
            hint = "Het tast oprechtheid aan.",
            extraHint = "Het is tegengesteld aan ikhlāṣ.",
            sourceCategory = "Akhlaaq"
        ),

        Question(
            id = 96,
            category = QuizCategory.AKHLAAQ,
            difficulty = Difficulty.MEDIUM,
            question = "Wat betekent tawbah?",
            answers = listOf("Berouw en terugkeer naar Allah", "Een feestdag", "Een recitatievorm", "Een gebedsoproep"),
            correctAnswerIndex = 0,
            explanation = "Tawbah betekent berouw tonen en terugkeren naar Allah.",
            hint = "Het omvat stoppen met de zonde, spijt en de intentie om niet terug te keren.",
            extraHint = "Allah houdt van degenen die berouw tonen.",
            sourceCategory = "Akhlaaq/Fiqh"
        ),

        Question(
            id = 97,
            category = QuizCategory.AKHLAAQ,
            difficulty = Difficulty.HARD,
            question = "Welke term verwijst naar hoogmoed?",
            answers = listOf("Kibr", "Ṣabr", "Shukr", "Ḥilm"),
            correctAnswerIndex = 0,
            explanation = "Kibr betekent hoogmoed of arrogantie.",
            hint = "Het is een gevaarlijke eigenschap voor het hart.",
            extraHint = "Ḥilm betekent juist verdraagzaamheid/zachtmoedigheid.",
            sourceCategory = "Akhlaaq"
        ),

        Question(
            id = 98,
            category = QuizCategory.AKHLAAQ,
            difficulty = Difficulty.HARD,
            question = "Wat betekent ḥilm?",
            answers = listOf("Zachtmoedigheid en beheersing", "Arrogantie", "Jaloezie", "Vergeetachtigheid"),
            correctAnswerIndex = 0,
            explanation = "Ḥilm betekent zachtmoedigheid, verdraagzaamheid en zelfbeheersing.",
            hint = "Het is een nobele karaktereigenschap.",
            extraHint = "Het helpt bij boosheid en conflicten.",
            sourceCategory = "Akhlaaq"
        ),

        Question(
            id = 99,
            category = QuizCategory.AKHLAAQ,
            difficulty = Difficulty.HARD,
            question = "Wat betekent hasad?",
            answers = listOf("Afgunst/jaloezie op iemands gunst", "Oprechtheid", "Geduld", "Liefdadigheid"),
            correctAnswerIndex = 0,
            explanation = "Hasad is afgunst: misgunnen dat iemand een gunst heeft.",
            hint = "Het is schadelijk voor het hart en de gemeenschap.",
            extraHint = "Het is niet hetzelfde als gezonde bewondering.",
            sourceCategory = "Akhlaaq"
        ),

        Question(
            id = 100,
            category = QuizCategory.AKHLAAQ,
            difficulty = Difficulty.HARD,
            question = "Wat betekent tawakkul?",
            answers = listOf("Vertrouwen op Allah met het nemen van middelen", "Niets doen en afwachten", "Alleen plannen maken", "Twijfelen aan Allah"),
            correctAnswerIndex = 0,
            explanation = "Tawakkul betekent vertrouwen op Allah terwijl je ook toegestane middelen neemt.",
            hint = "Het is geen luiheid.",
            extraHint = "Denk aan: vastbinden van de kameel en vertrouwen op Allah.",
            sourceCategory = "Aqeedah/Akhlaaq"
        ),

        Question(
            id = 101,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.EASY,
            question = "Welke surah wordt in elke rakʿah van het gebed gereciteerd?",
            answers = listOf("Al-Fātiḥah", "Yāsīn", "Al-Mulk", "Al-Kahf"),
            correctAnswerIndex = 0,
            explanation = "Surah Al-Fātiḥah wordt in elke rakʿah van het gebed gereciteerd.",
            hint = "Denk aan de opening van de Qur'an.",
            extraHint = "Deze surah begint met 'Al-ḥamdu lillāhi rabbil-ʿālamīn'.",
            sourceCategory = "Qur'an/Fiqh"
        ),
        Question(
            id = 102,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.EASY,
            question = "Welke surah begint met 'Qul huwa Allahu aḥad'?",
            answers = listOf("Al-Ikhlāṣ", "Al-Falaq", "An-Nās", "Al-Kawthar"),
            correctAnswerIndex = 0,
            explanation = "Surah Al-Ikhlāṣ begint met 'Qul huwa Allahu aḥad' en gaat over de eenheid van Allah.",
            hint = "Deze surah gaat kort en krachtig over tawḥīd.",
            extraHint = "De naam betekent oprechtheid/zuiverheid.",
            sourceCategory = "Qur'an"
        ),
        Question(
            id = 103,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.EASY,
            question = "Welke surah wordt vaak 'De Opening' genoemd?",
            answers = listOf("Al-Fātiḥah", "Al-Baqarah", "An-Nās", "Al-Falaq"),
            correctAnswerIndex = 0,
            explanation = "Al-Fātiḥah betekent 'De Opening' en staat aan het begin van de Qur'an.",
            hint = "Het is de eerste surah van de Qur'an.",
            extraHint = "Deze surah wordt ook in het gebed gereciteerd.",
            sourceCategory = "Qur'an"
        ),
        Question(
            id = 104,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.EASY,
            question = "Welke surah staat helemaal aan het einde van de Qur'an?",
            answers = listOf("An-Nās", "Al-Falaq", "Al-Ikhlāṣ", "Al-Masad"),
            correctAnswerIndex = 0,
            explanation = "Surah An-Nās is de laatste surah van de Qur'an.",
            hint = "De naam betekent 'De mensen'.",
            extraHint = "Deze surah wordt vaak samen met Al-Falaq gereciteerd.",
            sourceCategory = "Qur'an"
        ),
        Question(
            id = 105,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.MEDIUM,
            question = "Welke surah bevat het verhaal van de mensen van de grot?",
            answers = listOf("Al-Kahf", "Yūsuf", "Maryam", "Ṭāhā"),
            correctAnswerIndex = 0,
            explanation = "Het verhaal van de mensen van de grot staat in Surah Al-Kahf.",
            hint = "De naam van de surah betekent 'De Grot'.",
            extraHint = "Deze surah wordt vaak op vrijdag gereciteerd.",
            sourceCategory = "Qur'an"
        ),
        Question(
            id = 106,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.MEDIUM,
            question = "Welke surah bevat het verhaal van Yūsuf عليه السلام uitgebreid?",
            answers = listOf("Yūsuf", "Maryam", "Al-Anbiyā'", "Hūd"),
            correctAnswerIndex = 0,
            explanation = "Surah Yūsuf vertelt uitgebreid het verhaal van profeet Yūsuf عليه السلام.",
            hint = "De surah draagt de naam van de profeet zelf.",
            extraHint = "Het verhaal gaat onder andere over een droom, geduld en hereniging.",
            sourceCategory = "Qur'an"
        ),
        Question(
            id = 107,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.MEDIUM,
            question = "Welke surah begint met 'Tabāraka alladhī biyadihi al-mulk'?",
            answers = listOf("Al-Mulk", "Al-Wāqiʿah", "Yāsīn", "Ar-Raḥmān"),
            correctAnswerIndex = 0,
            explanation = "Surah Al-Mulk begint met 'Tabāraka alladhī biyadihi al-mulk'.",
            hint = "De naam betekent 'Het Koningschap'.",
            extraHint = "Deze surah is nummer 67 in de Qur'an.",
            sourceCategory = "Qur'an"
        ),
        Question(
            id = 108,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.MEDIUM,
            question = "Welke surah is genoemd naar een dier dat in het verhaal van Sulaymān عليه السلام voorkomt?",
            answers = listOf("An-Naml", "Al-Fīl", "Al-ʿAnkabūt", "Al-Baqarah"),
            correctAnswerIndex = 0,
            explanation = "Surah An-Naml betekent 'De Mieren' en bevat het verhaal waarin Sulaymān عليه السلام de mier hoort.",
            hint = "Denk aan een klein dier dat in groepen leeft.",
            extraHint = "De naam betekent 'De Mieren'.",
            sourceCategory = "Qur'an"
        ),
        Question(
            id = 109,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.HARD,
            question = "Wat betekent 'madani' bij een surah meestal?",
            answers = listOf("Geopenbaard na de hijrah", "Geopenbaard vóór de hijrah", "Alleen geopenbaard in Makkah", "Alleen over verhalen van profeten"),
            correctAnswerIndex = 0,
            explanation = "Een madani-surah is volgens de bekende indeling geopenbaard na de hijrah.",
            hint = "Het gaat om de periode na de migratie.",
            extraHint = "Het tegenovergestelde is makki.",
            sourceCategory = "Ulūm al-Qur'an"
        ),
        Question(
            id = 110,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.HARD,
            question = "Welke term verwijst naar de uitleg van de Qur'an?",
            answers = listOf("Tafsīr", "Tajwīd", "Isnād", "Fiqh"),
            correctAnswerIndex = 0,
            explanation = "Tafsīr is de uitleg en verklaring van de Qur'an.",
            hint = "Het gaat om betekenis en uitleg.",
            extraHint = "Ibn Kathīr is bekend om een beroemd werk in deze wetenschap.",
            sourceCategory = "Ulūm al-Qur'an"
        ),
        Question(
            id = 111,
            category = QuizCategory.PROPHETS,
            difficulty = Difficulty.EASY,
            question = "Welke profeet werd zonder vader geboren?",
            answers = listOf("ʿĪsā عليه السلام", "Mūsā عليه السلام", "Yūsuf عليه السلام", "Ibrāhīm عليه السلام"),
            correctAnswerIndex = 0,
            explanation = "ʿĪsā عليه السلام werd door Allah geschapen zonder vader.",
            hint = "Zijn moeder was Maryam عليها السلام.",
            extraHint = "Zijn geboorte wordt in de Qur'an bijzonder beschreven.",
            sourceCategory = "Qur'an"
        ),
        Question(
            id = 112,
            category = QuizCategory.PROPHETS,
            difficulty = Difficulty.EASY,
            question = "Welke profeet werd gered in een ark?",
            answers = listOf("Nūḥ عليه السلام", "Hūd عليه السلام", "Ṣāliḥ عليه السلام", "Lūṭ عليه السلام"),
            correctAnswerIndex = 0,
            explanation = "Nūḥ عليه السلام werd met de gelovigen gered in de ark.",
            hint = "Denk aan de grote vloed.",
            extraHint = "Zijn volk werd lang opgeroepen tot tawḥīd.",
            sourceCategory = "Qur'an"
        ),
        Question(
            id = 113,
            category = QuizCategory.PROPHETS,
            difficulty = Difficulty.EASY,
            question = "Welke profeet toonde groot geduld na het verlies van zijn zoon?",
            answers = listOf("Yaʿqūb عليه السلام", "Mūsā عليه السلام", "Hārūn عليه السلام", "Dāwūd عليه السلام"),
            correctAnswerIndex = 0,
            explanation = "Yaʿqūb عليه السلام toonde groot geduld toen hij Yūsuf عليه السلام verloor.",
            hint = "Hij was de vader van Yūsuf عليه السلام.",
            extraHint = "Zijn verhaal staat uitgebreid in Surah Yūsuf.",
            sourceCategory = "Qur'an"
        ),
        Question(
            id = 114,
            category = QuizCategory.PROPHETS,
            difficulty = Difficulty.MEDIUM,
            question = "Welke profeet werd naar Madyan gestuurd?",
            answers = listOf("Shuʿayb عليه السلام", "Hūd عليه السلام", "Ṣāliḥ عليه السلام", "Ilyās عليه السلام"),
            correctAnswerIndex = 0,
            explanation = "Shuʿayb عليه السلام werd naar het volk van Madyan gestuurd.",
            hint = "Zijn volk werd onder andere gewaarschuwd tegen oneerlijk handelen.",
            extraHint = "Hij wordt vaak genoemd in verband met eerlijke handel en maat.",
            sourceCategory = "Qur'an"
        ),
        Question(
            id = 115,
            category = QuizCategory.PROPHETS,
            difficulty = Difficulty.MEDIUM,
            question = "Welke profeet bouwde de Kaʿbah samen met zijn zoon?",
            answers = listOf("Ibrāhīm عليه السلام", "Yaʿqūb عليه السلام", "Isḥāq عليه السلام", "Mūsā عليه السلام"),
            correctAnswerIndex = 0,
            explanation = "Ibrāhīm عليه السلام bouwde samen met Ismāʿīl عليه السلام de Kaʿbah op.",
            hint = "Zijn zoon was Ismāʿīl عليه السلام.",
            extraHint = "Hij wordt gezien als een groot voorbeeld van tawḥīd.",
            sourceCategory = "Qur'an"
        ),
        Question(
            id = 116,
            category = QuizCategory.PROPHETS,
            difficulty = Difficulty.MEDIUM,
            question = "Welke profeet had een broer genaamd Hārūn عليه السلام?",
            answers = listOf("Mūsā عليه السلام", "Yūsuf عليه السلام", "Nūḥ عليه السلام", "Dāwūd عليه السلام"),
            correctAnswerIndex = 0,
            explanation = "Hārūn عليه السلام was de broer van Mūsā عليه السلام en hielp hem in zijn missie.",
            hint = "Deze profeet werd naar Firʿawn gestuurd.",
            extraHint = "Hij sprak met Allah op een bijzondere manier.",
            sourceCategory = "Qur'an"
        ),
        Question(
            id = 117,
            category = QuizCategory.PROPHETS,
            difficulty = Difficulty.HARD,
            question = "Welke profeet werd in de Qur'an genoemd als vader van Yaḥyā عليه السلام?",
            answers = listOf("Zakariyyā عليه السلام", "ʿĪsā عليه السلام", "Ilyās عليه السلام", "Idrīs عليه السلام"),
            correctAnswerIndex = 0,
            explanation = "Zakariyyā عليه السلام was de vader van Yaḥyā عليه السلام.",
            hint = "Hij deed duʿā' voor een kind op hoge leeftijd.",
            extraHint = "Zijn verhaal wordt onder andere genoemd in Surah Maryam.",
            sourceCategory = "Qur'an"
        ),
        Question(
            id = 118,
            category = QuizCategory.PROPHETS,
            difficulty = Difficulty.HARD,
            question = "Welke profeet wordt in de Qur'an genoemd met de titel Dhun-Nūn?",
            answers = listOf("Yūnus عليه السلام", "Ayyūb عليه السلام", "Nūḥ عليه السلام", "Lūṭ عليه السلام"),
            correctAnswerIndex = 0,
            explanation = "Yūnus عليه السلام wordt Dhun-Nūn genoemd, wat verwijst naar zijn verhaal met de grote vis.",
            hint = "Denk aan de profeet in de buik van de vis.",
            extraHint = "Zijn bekende duʿā' begint met 'Lā ilāha illā anta…'.",
            sourceCategory = "Qur'an"
        ),
        Question(
            id = 119,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.EASY,
            question = "Wie was de vader van de Profeet Muḥammad ﷺ?",
            answers = listOf("ʿAbdullāh", "Abū Ṭālib", "ʿAbd al-Muṭṭalib", "Ḥamzah"),
            correctAnswerIndex = 0,
            explanation = "De vader van de Profeet ﷺ heette ʿAbdullāh.",
            hint = "Hij overleed vóór de geboorte van de Profeet ﷺ.",
            extraHint = "Zijn volledige naam was ʿAbdullāh ibn ʿAbd al-Muṭṭalib.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 120,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.EASY,
            question = "Wie was de grootvader van de Profeet ﷺ?",
            answers = listOf("ʿAbd al-Muṭṭalib", "Abū Ṭālib", "Abū Lahab", "Ḥamzah"),
            correctAnswerIndex = 0,
            explanation = "De grootvader van de Profeet ﷺ was ʿAbd al-Muṭṭalib.",
            hint = "Hij zorgde voor de Profeet ﷺ na het overlijden van zijn moeder.",
            extraHint = "Daarna kwam de Profeet ﷺ onder de zorg van Abū Ṭālib.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 121,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Hoe heet de migratie van Makkah naar Madinah?",
            answers = listOf("Hijrah", "Isrā'", "Miʿrāj", "Ḥajj"),
            correctAnswerIndex = 0,
            explanation = "De migratie van Makkah naar Madinah heet de Hijrah.",
            hint = "De islamitische jaartelling is eraan gekoppeld.",
            extraHint = "Het betekent migratie/verlating omwille van Allah.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 122,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Welke stad heette vóór de hijrah Yathrib?",
            answers = listOf("Madinah", "Makkah", "Ṭā'if", "Khaybar"),
            correctAnswerIndex = 0,
            explanation = "Yathrib werd later bekend als Madinah.",
            hint = "De Profeet ﷺ migreerde naar deze stad.",
            extraHint = "Daar werd de eerste moslimgemeenschap opgebouwd.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 123,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Welke vrouw steunde de Profeet ﷺ als eerste na de eerste openbaring?",
            answers = listOf("Khadījah رضي الله عنها", "ʿĀ'ishah رضي الله عنها", "Ḥafṣah رضي الله عنها", "Umm Salamah رضي الله عنها"),
            correctAnswerIndex = 0,
            explanation = "Khadījah رضي الله عنها steunde en troostte de Profeet ﷺ na de eerste openbaring.",
            hint = "Zij was zijn eerste vrouw.",
            extraHint = "Zij was ook de eerste die in hem geloofde.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 124,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Welke grot werd gebruikt tijdens de hijrah om zich tijdelijk te verbergen?",
            answers = listOf("Thawr", "Ḥirā'", "Uḥud", "Ṣafā"),
            correctAnswerIndex = 0,
            explanation = "Tijdens de hijrah verbleven de Profeet ﷺ en Abū Bakr رضي الله عنه tijdelijk in de grot Thawr.",
            hint = "Niet de grot van de eerste openbaring.",
            extraHint = "Ḥirā' hoort bij de eerste openbaring; Thawr bij de hijrah.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 125,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.HARD,
            question = "Welke slag wordt ook de slag van de greppel genoemd?",
            answers = listOf("Al-Khandaq", "Badr", "Uḥud", "Ḥunayn"),
            correctAnswerIndex = 0,
            explanation = "Al-Khandaq betekent de greppel en verwijst naar de verdediging rond Madinah.",
            hint = "Salmān al-Fārisī رضي الله عنه gaf het advies voor de greppel.",
            extraHint = "Deze slag vond plaats na Uḥud.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 126,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.HARD,
            question = "Welke gebeurtenis maakte de vreedzame terugkeer naar Makkah mogelijk?",
            answers = listOf("De opening van Makkah", "De slag bij Badr", "De emigratie naar Abessinië", "De geboorte van de Profeet ﷺ"),
            correctAnswerIndex = 0,
            explanation = "De opening van Makkah was de gebeurtenis waarbij de moslims Makkah binnengingen en de Kaʿbah reinigden van afgoden.",
            hint = "Het gebeurde later in de Madinese periode.",
            extraHint = "Het was een grote overwinning zonder brede wraakactie.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 127,
            category = QuizCategory.SAHABA,
            difficulty = Difficulty.EASY,
            question = "Welke metgezel vergezelde de Profeet ﷺ in de grot tijdens de hijrah?",
            answers = listOf("Abū Bakr رضي الله عنه", "ʿUmar رضي الله عنه", "ʿUthmān رضي الله عنه", "ʿAlī رضي الله عنه"),
            correctAnswerIndex = 0,
            explanation = "Abū Bakr رضي الله عنه vergezelde de Profeet ﷺ tijdens de hijrah en in de grot.",
            hint = "Hij was de eerste khalief.",
            extraHint = "Hij wordt aṣ-Ṣiddīq genoemd.",
            sourceCategory = "Seerah/Sahaba"
        ),
        Question(
            id = 128,
            category = QuizCategory.SAHABA,
            difficulty = Difficulty.EASY,
            question = "Welke sahabi stond bekend om zijn prachtige adhān?",
            answers = listOf("Bilāl رضي الله عنه", "Anas رضي الله عنه", "Zayd رضي الله عنه", "Muʿādh رضي الله عنه"),
            correctAnswerIndex = 0,
            explanation = "Bilāl رضي الله عنه stond bekend als de eerste mu'adhdhin.",
            hint = "Hij werd zwaar beproefd in Makkah.",
            extraHint = "Zijn naam wordt vaak verbonden met de oproep tot gebed.",
            sourceCategory = "Seerah/Sahaba"
        ),
        Question(
            id = 129,
            category = QuizCategory.SAHABA,
            difficulty = Difficulty.MEDIUM,
            question = "Welke sahabi was bekend als schrijver van openbaring?",
            answers = listOf("Zayd ibn Thābit رضي الله عنه", "Bilāl رضي الله عنه", "Khālid رضي الله عنه", "Abū Dharr رضي الله عنه"),
            correctAnswerIndex = 0,
            explanation = "Zayd ibn Thābit رضي الله عنه was een schrijver van openbaring en speelde later een rol bij het verzamelen van de Qur'an.",
            hint = "Hij was bekend om kennis en nauwkeurigheid.",
            extraHint = "Zijn naam wordt vaak genoemd bij de verzameling van de Qur'an.",
            sourceCategory = "Sahaba/Qur'an"
        ),
        Question(
            id = 130,
            category = QuizCategory.SAHABA,
            difficulty = Difficulty.MEDIUM,
            question = "Welke sahabi stond bekend als een grote uitlegger van de Qur'an?",
            answers = listOf("Ibn ʿAbbās رضي الله عنهما", "Bilāl رضي الله عنه", "Khālid رضي الله عنه", "Abū ʿUbaydah رضي الله عنه"),
            correctAnswerIndex = 0,
            explanation = "Ibn ʿAbbās رضي الله عنهما stond bekend om zijn kennis van tafsīr.",
            hint = "De Profeet ﷺ deed duʿā' voor zijn begrip van de religie.",
            extraHint = "Hij was familie van de Profeet ﷺ en jong tijdens zijn leven.",
            sourceCategory = "Sahaba/Tafsīr"
        ),
        Question(
            id = 131,
            category = QuizCategory.SAHABA,
            difficulty = Difficulty.MEDIUM,
            question = "Welke sahabi stond bekend als 'het zwaard van Allah'?",
            answers = listOf("Khālid ibn al-Walīd رضي الله عنه", "ʿUmar رضي الله عنه", "Saʿd رضي الله عنه", "Zayd رضي الله عنه"),
            correctAnswerIndex = 0,
            explanation = "Khālid ibn al-Walīd رضي الله عنه werd bekend als Sayf Allāh, het zwaard van Allah.",
            hint = "Hij was een beroemde militaire leider.",
            extraHint = "Zijn bijnaam bevat het woord 'zwaard'.",
            sourceCategory = "Sahaba/Seerah"
        ),
        Question(
            id = 132,
            category = QuizCategory.SAHABA,
            difficulty = Difficulty.HARD,
            question = "Welke sahabi gaf het idee van een greppel bij de verdediging van Madinah?",
            answers = listOf("Salmān al-Fārisī رضي الله عنه", "Abū Hurayrah رضي الله عنه", "ʿUthmān رضي الله عنه", "Ṭalḥah رضي الله عنه"),
            correctAnswerIndex = 0,
            explanation = "Salmān al-Fārisī رضي الله عنه gaf het advies om een greppel te graven bij Al-Khandaq.",
            hint = "Hij kwam oorspronkelijk uit Perzië.",
            extraHint = "Zijn achtergrond hielp bij dit verdedigingsidee.",
            sourceCategory = "Sahaba/Seerah"
        ),
        Question(
            id = 133,
            category = QuizCategory.HADITH,
            difficulty = Difficulty.EASY,
            question = "Wat is de Sunnah?",
            answers = listOf("De leiding en praktijk van de Profeet ﷺ", "Alleen de Arabische taal", "Een stad in Arabia", "Een maand van de kalender"),
            correctAnswerIndex = 0,
            explanation = "De Sunnah verwijst naar de leiding, uitspraken, daden en goedkeuringen van de Profeet ﷺ.",
            hint = "Het heeft te maken met hoe de Profeet ﷺ leefde en onderwees.",
            extraHint = "Hadiths zijn een belangrijke bron om de Sunnah te kennen.",
            sourceCategory = "Hadith"
        ),
        Question(
            id = 134,
            category = QuizCategory.HADITH,
            difficulty = Difficulty.EASY,
            question = "Welke bekende hadithverzamelaar stelde Sahih al-Bukhari samen?",
            answers = listOf("Imam al-Bukhari", "Imam an-Nawawī", "Ibn Kathīr", "Imam Mālik"),
            correctAnswerIndex = 0,
            explanation = "Sahih al-Bukhari werd samengesteld door Imam al-Bukhari.",
            hint = "De naam van het boek bevat zijn naam.",
            extraHint = "Het is één van de bekendste hadithverzamelingen.",
            sourceCategory = "Hadith"
        ),
        Question(
            id = 135,
            category = QuizCategory.HADITH,
            difficulty = Difficulty.MEDIUM,
            question = "Wat betekent 'muttafaq ʿalayh' bij een hadith meestal?",
            answers = listOf("Overgeleverd door Bukhari en Muslim", "Alleen overgeleverd door één persoon", "Zonder keten", "Verzonnen"),
            correctAnswerIndex = 0,
            explanation = "Muttafaq ʿalayh betekent meestal dat de hadith is overgeleverd door zowel Bukhari als Muslim.",
            hint = "Het verwijst naar overeenstemming van de twee bekendste Sahih-verzamelingen.",
            extraHint = "Denk aan Sahih al-Bukhari en Sahih Muslim.",
            sourceCategory = "Hadithwetenschap"
        ),
        Question(
            id = 137,
            category = QuizCategory.HADITH,
            difficulty = Difficulty.HARD,
            question = "Wat onderzoekt ʿilm al-rijāl in hadithwetenschap?",
            answers = listOf("De betrouwbaarheid en biografie van overleveraars", "De gebedsrichting", "De volgorde van surahs", "De regels van vasten"),
            correctAnswerIndex = 0,
            explanation = "ʿIlm al-rijāl onderzoekt de overleveraars in hadithketens, zoals hun betrouwbaarheid en biografie.",
            hint = "Het woord rijāl betekent mannen/personen.",
            extraHint = "Het helpt bij het beoordelen van isnād.",
            sourceCategory = "Hadithwetenschap"
        ),
        Question(
            id = 138,
            category = QuizCategory.RAMADAN,
            difficulty = Difficulty.EASY,
            question = "Met welk gebed begint de nacht waarin Tarāwīḥ vaak wordt gebeden?",
            answers = listOf("ʿIshā'", "Fajr", "Dhuhr", "ʿAṣr"),
            correctAnswerIndex = 0,
            explanation = "Tarāwīḥ wordt na ʿIshā' gebeden in Ramadan.",
            hint = "Het is het nachtgebed na het laatste verplichte gebed.",
            extraHint = "Het wordt vaak gezamenlijk in de moskee gebeden.",
            sourceCategory = "Ramadan"
        ),
        Question(
            id = 139,
            category = QuizCategory.RAMADAN,
            difficulty = Difficulty.EASY,
            question = "Welke feestdag komt direct na Ramadan?",
            answers = listOf("Eid al-Fiṭr", "Eid al-Aḍḥā", "ʿĀshūrā'", "Jumuʿah"),
            correctAnswerIndex = 0,
            explanation = "Eid al-Fiṭr komt direct na de maand Ramadan.",
            hint = "Het is het feest van het verbreken van het vasten.",
            extraHint = "Het valt op de eerste dag van Shawwāl.",
            sourceCategory = "Ramadan"
        ),
        Question(
            id = 140,
            category = QuizCategory.RAMADAN,
            difficulty = Difficulty.MEDIUM,
            question = "In welke periode van Ramadan wordt Laylat al-Qadr vooral gezocht?",
            answers = listOf("De laatste tien nachten", "De eerste tien dagen", "Alleen de eerste nacht", "Na Eid"),
            correctAnswerIndex = 0,
            explanation = "Laylat al-Qadr wordt vooral gezocht in de laatste tien nachten van Ramadan.",
            hint = "Het is aan het einde van Ramadan.",
            extraHint = "Veel moslims verrichten dan extra aanbidding.",
            sourceCategory = "Ramadan"
        ),
        Question(
            id = 141,
            category = QuizCategory.RAMADAN,
            difficulty = Difficulty.MEDIUM,
            question = "Wat verbreekt het vasten bij zonsondergang?",
            answers = listOf("Iftar", "Suḥūr", "Iʿtikāf", "Zakāt"),
            correctAnswerIndex = 0,
            explanation = "Iftar is het verbreken van het vasten bij zonsondergang.",
            hint = "Dit gebeurt bij Maghrib.",
            extraHint = "Suḥūr is juist vóór Fajr.",
            sourceCategory = "Ramadan"
        ),
        Question(
            id = 142,
            category = QuizCategory.RAMADAN,
            difficulty = Difficulty.HARD,
            question = "Welke term verwijst naar afzondering in de moskee voor aanbidding in de laatste tien dagen van Ramadan?",
            answers = listOf("Iʿtikāf", "Tarāwīḥ", "Suḥūr", "Zakāt al-fiṭr"),
            correctAnswerIndex = 0,
            explanation = "Iʿtikāf is afzondering in de moskee voor aanbidding, vooral bekend in de laatste tien dagen van Ramadan.",
            hint = "Het draait om focus op aanbidding.",
            extraHint = "Het wordt vaak verbonden met het zoeken naar Laylat al-Qadr.",
            sourceCategory = "Ramadan"
        ),
        Question(
            id = 143,
            category = QuizCategory.AKHLAAQ,
            difficulty = Difficulty.EASY,
            question = "Welke eigenschap betekent dankbaarheid?",
            answers = listOf("Shukr", "Kibr", "Hasad", "Riyā'"),
            correctAnswerIndex = 0,
            explanation = "Shukr betekent dankbaarheid. In islamitische context gaat het vooral om dankbaarheid aan Allah voor Zijn gunsten.",
            hint = "Het tegenovergestelde is ondankbaarheid.",
            extraHint = "Shukr lillāh betekent dankbaarheid tegenover Allah.",
            sourceCategory = "Akhlaaq"
        ),
        Question(
            id = 144,
            category = QuizCategory.AKHLAAQ,
            difficulty = Difficulty.EASY,
            question = "Welke eigenschap betekent geduld en standvastigheid?",
            answers = listOf("Ṣabr", "Hasad", "Kibr", "Riyā'"),
            correctAnswerIndex = 0,
            explanation = "Ṣabr betekent geduld, volharding en standvastigheid.",
            hint = "Het is belangrijk bij beproevingen.",
            extraHint = "Allah prijst de geduldigen in de Qur'an.",
            sourceCategory = "Akhlaaq"
        ),
        Question(
            id = 145,
            category = QuizCategory.AKHLAAQ,
            difficulty = Difficulty.MEDIUM,
            question = "Wat betekent ikhlāṣ?",
            answers = listOf("Oprechtheid voor Allah", "Hoogmoed", "Afgunst", "Snelheid in gebed"),
            correctAnswerIndex = 0,
            explanation = "Ikhlāṣ betekent oprechtheid: een daad verrichten omwille van Allah.",
            hint = "Het gaat om de intentie achter een daad.",
            extraHint = "Het tegenovergestelde is schijnvertoon.",
            sourceCategory = "Akhlaaq"
        ),
        Question(
            id = 146,
            category = QuizCategory.AKHLAAQ,
            difficulty = Difficulty.MEDIUM,
            question = "Wat betekent amānah?",
            answers = listOf("Betrouwbaarheid en verantwoordelijkheid", "Afgunst", "Hoogmoed", "Haast"),
            correctAnswerIndex = 0,
            explanation = "Amānah betekent betrouwbaarheid, verantwoordelijkheid en het nakomen van toevertrouwde zaken.",
            hint = "De Profeet ﷺ stond bekend als al-Amīn.",
            extraHint = "Het heeft te maken met vertrouwen.",
            sourceCategory = "Akhlaaq"
        ),
        Question(
            id = 147,
            category = QuizCategory.AKHLAAQ,
            difficulty = Difficulty.HARD,
            question = "Welke eigenschap betekent schijnvertoon in aanbidding?",
            answers = listOf("Riyā'", "Ṣabr", "Shukr", "Ḥilm"),
            correctAnswerIndex = 0,
            explanation = "Riyā' betekent dat iemand goede daden doet om door mensen gezien of geprezen te worden.",
            hint = "Het tast oprechtheid aan.",
            extraHint = "Het is het tegenovergestelde van ikhlāṣ.",
            sourceCategory = "Akhlaaq"
        ),
        Question(
            id = 148,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.EASY,
            question = "Wat betekent 'Allāhu akbar'?",
            answers = listOf("Allah is de Grootste", "Alle lof is aan Allah", "Er is geen god behalve Allah", "Ik zoek vergeving bij Allah"),
            correctAnswerIndex = 0,
            explanation = "Allāhu akbar betekent: Allah is de Grootste.",
            hint = "Deze uitspraak hoor je onder andere in de adhān en het gebed.",
            extraHint = "Het wordt takbīr genoemd.",
            sourceCategory = "Algemene islamkennis"
        ),
        Question(
            id = 149,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.MEDIUM,
            question = "Wat betekent 'al-ḥamdu lillāh'?",
            answers = listOf("Alle lof is aan Allah", "Allah is de Grootste", "Ik zoek bescherming bij Allah", "Er is geen god behalve Allah"),
            correctAnswerIndex = 0,
            explanation = "Al-ḥamdu lillāh betekent: alle lof is aan Allah.",
            hint = "Deze uitspraak staat aan het begin van Al-Fātiḥah.",
            extraHint = "Het wordt vaak gezegd als dankbaarheid.",
            sourceCategory = "Algemene islamkennis"
        ),
        Question(
            id = 150,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.HARD,
            question = "Wat betekent tawakkul?",
            answers = listOf("Vertrouwen op Allah terwijl je toegestane middelen neemt", "Niets doen en afwachten", "Alleen hard werken zonder duʿā'", "Twijfelen aan het resultaat"),
            correctAnswerIndex = 0,
            explanation = "Tawakkul betekent vertrouwen op Allah, terwijl je ook de toegestane middelen neemt.",
            hint = "Het is vertrouwen én handelen.",
            extraHint = "Het betekent niet dat je lui afwacht.",
            sourceCategory = "Aqeedah/Akhlaaq"
        ),

        Question(
            id = 151,
            category = QuizCategory.SAHABA,
            difficulty = Difficulty.HARD,
            question = "Welke metgezel stond bekend als de bewaarder van het geheim van de Profeet ﷺ over de hypocrieten?",
            answers = listOf("Abū ʿUbaydah ibn al-Jarrāḥ رضي الله عنه", "Ḥudhayfah ibn al-Yamān رضي الله عنه", "Zayd ibn Thābit رضي الله عنه", "ʿAbdullāh ibn Masʿūd رضي الله عنه"),
            correctAnswerIndex = 1,
            explanation = "Ḥudhayfah ibn al-Yamān رضي الله عنه stond bekend als degene die vertrouwelijke kennis had over de hypocrieten en interne dreigingen.",
            hint = "ʿUmar رضي الله عنه lette later goed op of deze metgezel bij iemands begrafenis aanwezig was.",
            extraHint = "Hij werd vertrouwd met gevoelige informatie die de Profeet ﷺ hem gaf.",
            sourceCategory = "Sahaba/Seerah"
        ),
        Question(
            id = 152,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.HARD,
            question = "Wat betekent de term ʿĀmm makhṣūṣ in uṣūl al-fiqh?",
            answers = listOf("Een tekst waarvan de betekenis volledig is afgeschaft", "Een specifieke regel die zonder bewijs algemeen wordt toegepast", "Een algemene tekst waarvan de toepassing door ander bewijs wordt beperkt", "Een regel die alleen geldt voor de bewoners van Makkah"),
            correctAnswerIndex = 2,
            explanation = "ʿĀmm makhṣūṣ verwijst naar een algemene tekst waarvan de reikwijdte door een ander bewijs wordt ingeperkt.",
            hint = "ʿĀmm betekent algemeen en makhṣūṣ betekent gespecificeerd.",
            extraHint = "Het is een begrip uit de wetenschap van uṣūl al-fiqh.",
            sourceCategory = "Fiqh/Uṣūl"
        ),
        Question(
            id = 153,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.HARD,
            question = "Welke generaal leidde het islamitische leger bij de Slag bij Yamāmah?",
            answers = listOf("Abū ʿUbaydah ibn al-Jarrāḥ رضي الله عنه", "Ikrimah ibn Abī Jahl رضي الله عنه", "Khālid ibn al-Walīd رضي الله عنه", "Saʿd ibn Abī Waqqāṣ رضي الله عنه"),
            correctAnswerIndex = 2,
            explanation = "Khālid ibn al-Walīd رضي الله عنه leidde het leger bij Yamāmah tijdens de Ridda-oorlogen in de tijd van Abū Bakr رضي الله عنه.",
            hint = "Hij werd Sayf Allāh genoemd.",
            extraHint = "De slag vond plaats tijdens de Ridda-oorlogen.",
            sourceCategory = "Seerah/Islamitische Geschiedenis"
        ),
        Question(
            id = 154,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.HARD,
            question = "Welke imam staat aan de basis van de recitatie die wereldwijd bekend is als Ḥafṣ ʿan ʿĀṣim?",
            answers = listOf("Imām Nāfiʿ al-Madanī", "Imām ʿĀṣim al-Kūfī", "Imām Ibn Kathīr al-Makkī", "Imām Abū ʿAmr al-Baṣrī"),
            correctAnswerIndex = 1,
            explanation = "De veelgebruikte recitatie Ḥafṣ ʿan ʿĀṣim gaat terug op Imām ʿĀṣim al-Kūfī.",
            hint = "De bekende riwāyah is van Ḥafṣ via deze imam.",
            extraHint = "Dit is de meest verspreide recitatie ter wereld.",
            sourceCategory = "Qur'an/Qirāʾāt"
        ),
        Question(
            id = 155,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.HARD,
            question = "Welke eed legde de basis voor de bescherming van de Profeet ﷺ door de bewoners van Yathrib vóór de Hijrah?",
            answers = listOf("De Eerste Eed bij al-ʿAqabah", "De Tweede Eed bij al-ʿAqabah", "De Eed van Riḍwān", "Het Verdrag van Ḥudaybiyyah"),
            correctAnswerIndex = 1,
            explanation = "Bij de Tweede Eed bij al-ʿAqabah beloofden de bewoners van Yathrib de Profeet ﷺ te beschermen, wat de Hijrah mogelijk maakte.",
            hint = "Bij deze eed waren meer mensen uit Yathrib aanwezig dan bij de eerste.",
            extraHint = "Er waren ook vrouwen bij aanwezig.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 156,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.HARD,
            question = "Wat betekent de stelregel 'Al-ghunm bil-ghurm'?",
            answers = listOf("Zekerheid wordt niet opgeheven door twijfel", "Moeilijkheid brengt verlichting", "Winstrecht hangt samen met risico en verantwoordelijkheid", "Gewoonte kan juridisch meewegen"),
            correctAnswerIndex = 2,
            explanation = "Deze stelregel betekent dat recht op winst of voordeel verbonden is aan het dragen van risico of verantwoordelijkheid.",
            hint = "Het gaat om voordeel en verantwoordelijkheid samen.",
            extraHint = "Een bekende stelregel uit de islamitische rechtsleer.",
            sourceCategory = "Fiqh/Uṣūl"
        ),
        Question(
            id = 157,
            category = QuizCategory.SAHABA,
            difficulty = Difficulty.HARD,
            question = "Welke vrouwelijke geleerde uit de tābiʿīn stond bekend om haar kennis van de overleveringen van ʿĀʾishah رضي الله عنها?",
            answers = listOf("ʿAmrah bint ʿAbd al-Raḥmān", "Sayyidah Nafīsah", "Ḥafṣah bint Sīrīn", "Fāṭimah bint al-Mundhir"),
            correctAnswerIndex = 0,
            explanation = "ʿAmrah bint ʿAbd al-Raḥmān was een bekende geleerde uit Madinah en een belangrijke overleveraarster van kennis van ʿĀʾishah رضي الله عنها.",
            hint = "Zij wordt vaak genoemd als belangrijke overleveraarster uit Madinah.",
            extraHint = "Zij behoorde tot de generatie van de tābiʿīn.",
            sourceCategory = "Sahaba/Hadith"
        ),
        Question(
            id = 158,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.HARD,
            question = "Welke sahābi wordt als enige metgezel expliciet bij naam genoemd in de Qurʾān?",
            answers = listOf("Abū Bakr رضي الله عنه", "Zayd ibn Ḥārithah رضي الله عنه", "ʿUmar ibn al-Khaṭṭāb رضي الله عنه", "Bilāl ibn Rabāḥ رضي الله عنه"),
            correctAnswerIndex = 1,
            explanation = "Zayd ibn Ḥārithah رضي الله عنه is de enige sahābi die expliciet bij naam in de Qurʾān wordt genoemd.",
            hint = "Zijn naam komt voor in Surah al-Aḥzāb.",
            extraHint = "Hij was de vrijgelaten slaaf en adoptiezoon van de Profeet ﷺ.",
            sourceCategory = "Qur'an/Seerah"
        ),
        Question(
            id = 159,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.HARD,
            question = "In welke surah wordt Zayd ibn Ḥārithah رضي الله عنه bij naam genoemd?",
            answers = listOf("An-Nūr", "Al-Fatḥ", "Al-Aḥzāb", "At-Tawbah"),
            correctAnswerIndex = 2,
            explanation = "Zayd ibn Ḥārithah رضي الله عنه wordt genoemd in Surah al-Aḥzāb.",
            hint = "Deze surah bevat meerdere regels rond het huishouden van de Profeet ﷺ.",
            extraHint = "Het is de 33e surah van de Qur'an.",
            sourceCategory = "Qur'an"
        ),
        Question(
            id = 160,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.HARD,
            question = "Wat betekent 'asbāb an-nuzūl'?",
            answers = listOf("De regels van tajwīd", "De redenen of aanleidingen van openbaring", "De volgorde van de kaliefen", "De namen van de engelen"),
            correctAnswerIndex = 1,
            explanation = "Asbāb an-nuzūl verwijst naar de aanleidingen of omstandigheden waaronder Qurʾānverzen werden geopenbaard.",
            hint = "Het gaat om de context waarin bepaalde verzen werden geopenbaard.",
            extraHint = "Kennis hiervan helpt bij het begrijpen van verzen.",
            sourceCategory = "Ulūm al-Qur'an"
        ),
        Question(
            id = 161,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.HARD,
            question = "Wat betekent 'muḥkamāt' in de context van Qurʾānverzen?",
            answers = listOf("Verzen met duidelijke en grondleggende betekenis", "Verzen die alleen over oorlog gaan", "Verzen die niet gereciteerd worden", "Verzen die alleen in Madinah zijn geopenbaard"),
            correctAnswerIndex = 0,
            explanation = "Muḥkamāt zijn verzen waarvan de betekenis duidelijk en grondleggend is.",
            hint = "Het tegenovergestelde begrip is mutashābihāt.",
            extraHint = "Dit onderscheid staat in Surah Āl ʿImrān.",
            sourceCategory = "Ulūm al-Qur'an"
        ),
        Question(
            id = 162,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.HARD,
            question = "Wat betekent 'mutashābihāt' in de context van Qurʾānverzen?",
            answers = listOf("Verzen die exact hetzelfde klinken", "Verzen die alleen over eerdere volkeren gaan", "Verzen waarvan de precieze bedoeling niet voor iedereen direct duidelijk is", "Verzen die alleen in het gebed gereciteerd mogen worden"),
            correctAnswerIndex = 2,
            explanation = "Mutashābihāt zijn verzen waarvan de precieze betekenis of volledige werkelijkheid niet voor iedereen direct duidelijk is.",
            hint = "Het gaat om verzen waarvan de uitleg meer kennis vereist.",
            extraHint = "Geleerden benadrukken bescheidenheid bij deze verzen.",
            sourceCategory = "Ulūm al-Qur'an"
        ),
        Question(
            id = 163,
            category = QuizCategory.SAHABA,
            difficulty = Difficulty.HARD,
            question = "Welke sahābi stond bekend als 'Dhū an-Nūrayn'?",
            answers = listOf("ʿAlī ibn Abī Ṭālib رضي الله عنه", "ʿUthmān ibn ʿAffān رضي الله عنه", "Ṭalḥah ibn ʿUbaydillāh رضي الله عنه", "Saʿd ibn Abī Waqqāṣ رضي الله عنه"),
            correctAnswerIndex = 1,
            explanation = "ʿUthmān ibn ʿAffān رضي الله عنه kreeg deze bijnaam omdat hij met twee dochters van de Profeet ﷺ getrouwd was.",
            hint = "De bijnaam betekent 'bezitter van twee lichten'.",
            extraHint = "Hij was de derde khalief.",
            sourceCategory = "Sahaba"
        ),
        Question(
            id = 164,
            category = QuizCategory.SAHABA,
            difficulty = Difficulty.HARD,
            question = "Welke sahābi werd vaak 'Turjumān al-Qurʾān' genoemd?",
            answers = listOf("ʿAbdullāh ibn ʿAbbās رضي الله عنهما", "Khālid ibn al-Walīd رضي الله عنه", "Bilāl ibn Rabāḥ رضي الله عنه", "Abū Dharr رضي الله عنه"),
            correctAnswerIndex = 0,
            explanation = "ʿAbdullāh ibn ʿAbbās رضي الله عنهما stond bekend om zijn diepe kennis van de uitleg van de Qurʾān.",
            hint = "Hij stond bekend om zijn tafsīrkennis.",
            extraHint = "De Profeet ﷺ deed duʿā' voor zijn begrip van de religie.",
            sourceCategory = "Sahaba/Tafsīr"
        ),
        Question(
            id = 165,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.HARD,
            question = "Welke sahābi werd door de Profeet ﷺ naar Jemen gestuurd als leraar en rechter?",
            answers = listOf("Bilāl ibn Rabāḥ رضي الله عنه", "Muʿādh ibn Jabal رضي الله عنه", "Ḥamzah ibn ʿAbd al-Muṭṭalib رضي الله عنه", "ʿAbd al-Raḥmān ibn ʿAwf رضي الله عنه"),
            correctAnswerIndex = 1,
            explanation = "Muʿādh ibn Jabal رضي الله عنه werd naar Jemen gestuurd om mensen te onderwijzen en recht te spreken.",
            hint = "Hij stond bekend om zijn kennis.",
            extraHint = "De Profeet ﷺ onderwees hem hoe hij moest oordelen.",
            sourceCategory = "Seerah/Sahaba"
        ),
        Question(
            id = 166,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.HARD,
            question = "Welke vrouw kreeg de bijnaam 'Dhāt an-Niṭāqayn'?",
            answers = listOf("Asmāʾ bint Abī Bakr رضي الله عنها", "ʿĀʾishah رضي الله عنها", "Ḥafṣah bint ʿUmar رضي الله عنها", "Umm Salamah رضي الله عنها"),
            correctAnswerIndex = 0,
            explanation = "Asmāʾ bint Abī Bakr رضي الله عنها kreeg deze bijnaam omdat zij haar gordel gebruikte om proviand voor de Hijrah vast te binden.",
            hint = "Zij hielp bij de Hijrah.",
            extraHint = "De bijnaam betekent 'zij met de twee gordels'.",
            sourceCategory = "Seerah/Sahaba"
        ),
        Question(
            id = 167,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.HARD,
            question = "Welke vrouw bewaarde de mushaf die later werd gebruikt bij de standaardisatie onder ʿUthmān رضي الله عنه?",
            answers = listOf("ʿĀʾishah رضي الله عنها", "Ḥafṣah bint ʿUmar رضي الله عنها", "Fāṭimah رضي الله عنها", "Umm Ḥabībah رضي الله عنها"),
            correctAnswerIndex = 1,
            explanation = "De mushaf die bij Ḥafṣah رضي الله عنها werd bewaard, speelde een rol bij de latere standaardisatie van de Qurʾān.",
            hint = "Zij was een echtgenote van de Profeet ﷺ en dochter van ʿUmar رضي الله عنه.",
            extraHint = "De mushaf werd bij haar bewaard na het overlijden van Abū Bakr رضي الله عنه.",
            sourceCategory = "Seerah/Qur'an"
        ),
        Question(
            id = 168,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.HARD,
            question = "Wie zijn de Muhājirūn?",
            answers = listOf("De moslims uit Madinah die hielpen", "De moslims die van Makkah naar Madinah migreerden", "De schrijvers van de openbaring", "De latere generatie na de sahābah"),
            correctAnswerIndex = 1,
            explanation = "De Muhājirūn waren de moslims die omwille van Allah van Makkah naar Madinah migreerden.",
            hint = "Het woord komt van hijrah.",
            extraHint = "Zij worden in de Qur'an geprezen.",
            sourceCategory = "Seerah/Islamitische Kennis"
        ),
        Question(
            id = 169,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.HARD,
            question = "Wie zijn de Anṣār?",
            answers = listOf("De moslims van Madinah die de Muhājirūn hielpen", "De moslims die naar Abessinië migreerden", "De schrijvers van de Qur'an", "De tien beloofden met het paradijs"),
            correctAnswerIndex = 0,
            explanation = "De Anṣār waren de moslims van Madinah die de Profeet ﷺ en de Muhājirūn steunden.",
            hint = "De naam betekent helpers.",
            extraHint = "Zij ontvingen de Muhājirūn met open armen.",
            sourceCategory = "Seerah/Islamitische Kennis"
        ),
        Question(
            id = 170,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.HARD,
            question = "Wie zijn de Tābiʿūn?",
            answers = listOf("De generatie na de sahābah", "De vier rechtgeleide kaliefen", "De bewoners van Makkah vóór de Hijrah", "De mensen die bij Badr vochten"),
            correctAnswerIndex = 0,
            explanation = "De Tābiʿūn zijn de generatie moslims na de sahābah.",
            hint = "Zij ontmoetten sahābah, maar niet de Profeet ﷺ.",
            extraHint = "Na hen komen de Tābiʿ al-Tābiʿīn.",
            sourceCategory = "Islamitische Kennis"
        ),
        Question(
            id = 171,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.HARD,
            question = "Wat betekent Ahl al-Bayt?",
            answers = listOf("De mensen van Madinah", "De familie/het huishouden van de Profeet ﷺ", "De mensen van de grot", "De mensen van de markt"),
            correctAnswerIndex = 1,
            explanation = "Ahl al-Bayt verwijst naar het huishouden en de familie van de Profeet ﷺ.",
            hint = "Bayt betekent huis.",
            extraHint = "Zij worden in de Qur'an en Sunnah bijzonder vermeld.",
            sourceCategory = "Islamitische Kennis/Seerah"
        ),
        Question(
            id = 172,
            category = QuizCategory.SAHABA,
            difficulty = Difficulty.HARD,
            question = "Wie waren Ahl aṣ-Ṣuffah?",
            answers = listOf("Arme metgezellen die bij de moskee van de Profeet ﷺ verbleven", "De stamleiders van Quraysh", "De schrijvers van de openbaring", "De mensen van al-ʿAqabah"),
            correctAnswerIndex = 0,
            explanation = "Ahl aṣ-Ṣuffah waren arme metgezellen die zich toelegden op aanbidding en kennis, en bij de moskee verbleven.",
            hint = "Zij verbleven bij een deel van de moskee.",
            extraHint = "Abū Hurayrah رضي الله عنه behoorde tot hen.",
            sourceCategory = "Sahaba/Seerah"
        ),
        Question(
            id = 173,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.HARD,
            question = "Wie waren Kuttāb al-Waḥy?",
            answers = listOf("De schrijvers van de openbaring", "De bewakers van de Kaʿbah", "De strijders van Badr", "De bewoners van Madinah"),
            correctAnswerIndex = 0,
            explanation = "Kuttāb al-Waḥy waren de metgezellen die de openbaring voor de Profeet ﷺ opschreven.",
            hint = "Waḥy betekent openbaring.",
            extraHint = "Zayd ibn Thābit was een van de bekendsten.",
            sourceCategory = "Seerah/Qur'an"
        ),
        Question(
            id = 174,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.HARD,
            question = "Wat betekent 'al-Furqān' als beschrijving van de Qurʾān?",
            answers = listOf("Datgene wat onderscheid maakt tussen waarheid en valsheid", "Een boek met historische verhalen zonder regels", "Een naam voor de engel van de dood", "Een benaming voor het vrijdaggebed"),
            correctAnswerIndex = 0,
            explanation = "Al-Furqān betekent dat de Qurʾān onderscheid maakt tussen waarheid en valsheid.",
            hint = "Furqān komt van onderscheiden.",
            extraHint = "Het is ook een naam van Surah 25.",
            sourceCategory = "Ulūm al-Qur'an"
        ),
        Question(
            id = 175,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.HARD,
            question = "Welke surah vermeldt het verhaal van Aṣḥāb al-Ukhdūd, de mensen van de greppel?",
            answers = listOf("Al-Burūj", "Al-Fīl", "Al-Masad", "Al-Qāriʿah"),
            correctAnswerIndex = 0,
            explanation = "Surah al-Burūj vermeldt Aṣḥāb al-Ukhdūd, de mensen van de greppel.",
            hint = "Deze surah noemt de mensen van de greppel.",
            extraHint = "Het is een krachtige surah over beproeving en geloof.",
            sourceCategory = "Qur'an"
        ),
        Question(
            id = 176,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.HARD,
            question = "Welke Qurʾānische term verwijst naar de beschermde hemelse oorsprong van de openbaring?",
            answers = listOf("Al-Lawḥ al-Maḥfūẓ", "Al-Kawthar", "Al-Mīzān", "Al-Barzakh"),
            correctAnswerIndex = 0,
            explanation = "Al-Lawḥ al-Maḥfūẓ wordt genoemd als de beschermde plaat waarop Allahs kennis en bepalingen staan.",
            hint = "Maḥfūẓ betekent beschermd.",
            extraHint = "Het wordt vermeld in Surah al-Burūj.",
            sourceCategory = "Aqeedah/Qur'an"
        ),
        Question(
            id = 177,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.HARD,
            question = "Welke twee stammen uit Yathrib vormden het grootste deel van de Anṣār?",
            answers = listOf("Aws en Khazraj", "Quraysh en Kinānah", "Thaqīf en Hawāzin", "Banū Hāshim en Banū Umayyah"),
            correctAnswerIndex = 0,
            explanation = "De stammen Aws en Khazraj vormden de kern van de Anṣār.",
            hint = "Zij waren de bekende stammen van Madinah.",
            extraHint = "Zij hadden lang strijd gehad voor de komst van de islam.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 178,
            category = QuizCategory.QURAN,
            difficulty = Difficulty.HARD,
            question = "Wat betekent 'tartīl' bij Qurʾānrecitatie?",
            answers = listOf("Rustig en duidelijk reciteren", "Alleen vertaling lezen", "Heel snel reciteren zonder pauze", "De surahs op chronologische volgorde zetten"),
            correctAnswerIndex = 0,
            explanation = "Tartīl betekent rustig, duidelijk en zorgvuldig reciteren.",
            hint = "Het gaat om zorgvuldige recitatie.",
            extraHint = "Allah beveelt tartīl in de Qur'an.",
            sourceCategory = "Ulūm al-Qur'an"
        ),
        Question(
            id = 179,
            category = QuizCategory.AKHLAAQ,
            difficulty = Difficulty.HARD,
            question = "Wat betekent 'tawāḍuʿ'?",
            answers = listOf("Nederigheid", "Jaloezie", "Onachtzaamheid", "Woede"),
            correctAnswerIndex = 0,
            explanation = "Tawāḍuʿ betekent nederigheid en jezelf niet boven anderen verheffen.",
            hint = "Het tegenovergestelde lijkt op hoogmoed.",
            extraHint = "Het is een geliefde eigenschap bij Allah.",
            sourceCategory = "Akhlaaq"
        ),
        Question(
            id = 180,
            category = QuizCategory.AKHLAAQ,
            difficulty = Difficulty.HARD,
            question = "Wat betekent 'ḥayāʾ'?",
            answers = listOf("Gezonde schaamte en eerbaarheid", "Rijkdom verzamelen", "Discussie winnen", "Hard spreken"),
            correctAnswerIndex = 0,
            explanation = "Ḥayāʾ betekent gezonde schaamte, eerbaarheid en bescheidenheid.",
            hint = "Het is een geliefde eigenschap in de islam.",
            extraHint = "De Profeet ﷺ stond bekend om zijn grote ḥayāʾ.",
            sourceCategory = "Akhlaaq"
        ),
        Question(
            id = 181,
            category = QuizCategory.AKHLAAQ,
            difficulty = Difficulty.HARD,
            question = "Wat betekent 'sakīnah'?",
            answers = listOf("Rust en kalmte", "Hoogmoed", "Honger", "Strijdlust"),
            correctAnswerIndex = 0,
            explanation = "Sakīnah betekent rust, kalmte en geruststelling die Allah schenkt.",
            hint = "Het woord wordt verbonden met innerlijke rust.",
            extraHint = "Allah schenkt sakīnah aan de gelovigen in moeilijke tijden.",
            sourceCategory = "Akhlaaq/Aqeedah"
        ),
        Question(
            id = 182,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.HARD,
            question = "Wat betekent 'rubūbiyyah' in de uitleg van tawḥīd?",
            answers = listOf("Allah erkennen als Schepper, Onderhouder en Bestuurder", "Alleen Arabisch spreken", "Liefdadigheid geven", "De regels van handel kennen"),
            correctAnswerIndex = 0,
            explanation = "Rubūbiyyah verwijst naar Allahs alleenrecht als Schepper, Eigenaar, Onderhouder en Bestuurder van alles.",
            hint = "Het gaat om Allahs heerschappij en bestuur.",
            extraHint = "Het is een van de drie categorieën van tawḥīd.",
            sourceCategory = "Aqeedah"
        ),
        Question(
            id = 183,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.HARD,
            question = "Wat betekent 'ulūhiyyah' in de uitleg van tawḥīd?",
            answers = listOf("Dat aanbidding alleen aan Allah toekomt", "Dat engelen licht zijn", "Dat profeten mensen zijn", "Dat boeken geopenbaard zijn"),
            correctAnswerIndex = 0,
            explanation = "Ulūhiyyah betekent dat alle vormen van aanbidding alleen voor Allah zijn.",
            hint = "Het gaat om aanbidding.",
            extraHint = "Het is een van de drie categorieën van tawḥīd.",
            sourceCategory = "Aqeedah"
        ),
        Question(
            id = 184,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.HARD,
            question = "Wat betekent geloof in 'al-qadar'?",
            answers = listOf("Geloof in Allahs goddelijke beschikking", "Geloof in de richting van de qiblah", "Geloof in de Arabische taal", "Geloof in de bouw van de Kaʿbah"),
            correctAnswerIndex = 0,
            explanation = "Al-qadar betekent geloven in Allahs kennis, wil, schepping en beschikking over alles.",
            hint = "Het is een van de zes zuilen van īmān.",
            extraHint = "Het omvat vier niveaus: kennis, opschrijving, wil en schepping.",
            sourceCategory = "Aqeedah"
        ),
        Question(
            id = 185,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.HARD,
            question = "Wat betekent 'ijmāʿ' in islamitische rechtsleer?",
            answers = listOf("Consensus van geleerden", "Analogie", "Persoonlijke mening zonder bewijs", "Een vrijwillig gebed"),
            correctAnswerIndex = 0,
            explanation = "Ijmāʿ betekent consensus en wordt in uṣūl al-fiqh gezien als een belangrijke bron.",
            hint = "Het betekent overeenstemming.",
            extraHint = "Het is een van de vier hoofdbronnen van de islamitische wet.",
            sourceCategory = "Fiqh/Uṣūl"
        ),
        Question(
            id = 186,
            category = QuizCategory.GENERAL,
            difficulty = Difficulty.HARD,
            question = "Wat betekent 'qiyās' in islamitische rechtsleer?",
            answers = listOf("Analogie op basis van een gedeelde reden", "Een nachtgebed", "Een soort vasten", "Een naam van een engel"),
            correctAnswerIndex = 0,
            explanation = "Qiyās is juridische analogie waarbij een nieuwe zaak wordt vergeleken met een bestaande zaak vanwege een gedeelde effectieve oorzaak.",
            hint = "Het wordt gebruikt wanneer een nieuwe kwestie wordt vergeleken met een bekende kwestie.",
            extraHint = "Het is een van de vier hoofdbronnen van de islamitische wet.",
            sourceCategory = "Fiqh/Uṣūl"
        ),

        Question(
            id = 201,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.EASY,
            question = "Hoe heette de stam van de Profeet Muḥammad ﷺ?",
            answers = listOf("Quraysh", "Aws", "Khazraj", "Thaqīf"),
            correctAnswerIndex = 0,
            explanation = "De Profeet ﷺ kwam uit de stam Quraysh in Makkah.",
            hint = "Deze stam had een belangrijke positie rond de Kaʿbah.",
            extraHint = "Surah Quraysh draagt dezelfde naam.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 202,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.EASY,
            question = "Uit welke clan binnen Quraysh kwam de Profeet ﷺ?",
            answers = listOf("Banū Hāshim", "Banū Umayyah", "Banū Makhzūm", "Banū Tamīm"),
            correctAnswerIndex = 0,
            explanation = "De Profeet ﷺ kwam uit Banū Hāshim, een gerespecteerde clan binnen Quraysh.",
            hint = "Zijn overgrootvader heette Hāshim.",
            extraHint = "Deze familie stond bekend om haar band met de verzorging van pelgrims.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 203,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.EASY,
            question = "Welke bijnaam had de Profeet ﷺ vóór de openbaring vanwege zijn betrouwbaarheid?",
            answers = listOf("Al-Amīn", "Al-Fārūq", "Dhun-Nūrayn", "Sayf Allāh"),
            correctAnswerIndex = 0,
            explanation = "De Profeet ﷺ stond vóór de openbaring bekend als al-Amīn, de betrouwbare.",
            hint = "De bijnaam heeft te maken met vertrouwen.",
            extraHint = "Al-Fārūq is een bijnaam van ʿUmar رضي الله عنه.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 204,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.EASY,
            question = "Wie troostte de Profeet ﷺ direct na de eerste openbaring?",
            answers = listOf("Khadījah رضي الله عنها", "ʿĀʾishah رضي الله عنها", "Fāṭimah رضي الله عنها", "Ḥalīmah as-Saʿdiyyah"),
            correctAnswerIndex = 0,
            explanation = "Khadījah رضي الله عنها troostte en steunde de Profeet ﷺ na de eerste openbaring.",
            hint = "Zij was zijn eerste vrouw.",
            extraHint = "Zij geloofde vanaf het begin in hem.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 205,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Naar wie bracht Khadījah رضي الله عنها de Profeet ﷺ na de eerste openbaring voor uitleg?",
            answers = listOf("Waraqah ibn Nawfal", "Abū Ṭālib", "Abū Bakr", "ʿUmar ibn al-Khaṭṭāb"),
            correctAnswerIndex = 0,
            explanation = "Khadījah رضي الله عنها bracht de Profeet ﷺ naar Waraqah ibn Nawfal, die kennis had van eerdere geschriften.",
            hint = "Hij was familie van Khadījah رضي الله عنها.",
            extraHint = "Hij herkende dat het om openbaring ging.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 206,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.EASY,
            question = "Wie was een van de eerste jonge mensen die in de Profeet ﷺ geloofde?",
            answers = listOf("ʿAlī رضي الله عنه", "Khālid ibn al-Walīd رضي الله عنه", "Abū Sufyān رضي الله عنه", "Muʿāwiyah رضي الله عنه"),
            correctAnswerIndex = 0,
            explanation = "ʿAlī رضي الله عنه behoorde tot de eerste mensen die in de Profeet ﷺ geloofden.",
            hint = "Hij was de neef van de Profeet ﷺ.",
            extraHint = "Hij groeide op in het huis van de Profeet ﷺ.",
            sourceCategory = "Seerah/Sahaba"
        ),
        Question(
            id = 207,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Waar kwamen de vroege moslims in Makkah in het geheim samen om te leren?",
            answers = listOf("Dār al-Arqam", "Masjid Qubā'", "Masjid an-Nabawī", "Khaybar"),
            correctAnswerIndex = 0,
            explanation = "De vroege moslims kwamen in Dār al-Arqam samen om de islam te leren en te praktiseren.",
            hint = "Het was een huis in de vroege Makkaanse periode.",
            extraHint = "De naam bevat Arqam.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 208,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.EASY,
            question = "Naar welk land migreerden sommige vroege moslims voor bescherming?",
            answers = listOf("Abessinië", "Syrië", "Jemen", "Irak"),
            correctAnswerIndex = 0,
            explanation = "Een groep vroege moslims migreerde naar Abessinië om veiligheid en bescherming te zoeken.",
            hint = "Daar regeerde een rechtvaardige christelijke koning.",
            extraHint = "Het wordt ook Habasha genoemd.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 209,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Hoe werd de rechtvaardige koning van Abessinië vaak genoemd?",
            answers = listOf("An-Najāshī", "Al-Muqawqis", "Heraclius", "Kisrā"),
            correctAnswerIndex = 0,
            explanation = "De koning van Abessinië werd an-Najāshī genoemd. Hij bood bescherming aan de moslims.",
            hint = "Hij beschermde de vroege moslims.",
            extraHint = "Niet te verwarren met Heraclius of Kisrā.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 210,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Welke sahabi sprak namens de moslims bij de koning van Abessinië?",
            answers = listOf("Jaʿfar ibn Abī Ṭālib رضي الله عنه", "Bilāl رضي الله عنه", "Zayd ibn Thābit رضي الله عنه", "Khālid ibn al-Walīd رضي الله عنه"),
            correctAnswerIndex = 0,
            explanation = "Jaʿfar ibn Abī Ṭālib رضي الله عنه sprak krachtig namens de moslims bij an-Najāshī.",
            hint = "Hij was familie van de Profeet ﷺ.",
            extraHint = "Hij reciteerde verzen over Maryam en ʿĪsā عليه السلام.",
            sourceCategory = "Seerah/Sahaba"
        ),
        Question(
            id = 211,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.EASY,
            question = "Wie was een felle tegenstander die wordt genoemd in Surah Al-Masad?",
            answers = listOf("Abū Lahab", "Abū Bakr", "ʿUmar", "Bilāl"),
            correctAnswerIndex = 0,
            explanation = "Abū Lahab was een felle tegenstander van de Profeet ﷺ en wordt genoemd in Surah Al-Masad.",
            hint = "Hij was familie van de Profeet ﷺ, maar tegenstander.",
            extraHint = "Surah Al-Masad begint met Tabbat yadā Abī Lahab.",
            sourceCategory = "Seerah/Qur'an"
        ),
        Question(
            id = 212,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Hoe wordt het jaar genoemd waarin Khadījah رضي الله عنها en Abū Ṭālib stierven?",
            answers = listOf("Het jaar van verdriet", "Het jaar van Badr", "Het jaar van de delegaties", "Het jaar van de olifant"),
            correctAnswerIndex = 0,
            explanation = "Dat jaar staat bekend als het jaar van verdriet, omdat de Profeet ﷺ twee grote steunpilaren verloor.",
            hint = "De Profeet ﷺ verloor zijn vrouw en zijn beschermende oom.",
            extraHint = "Het gebeurde vóór de hijrah.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 213,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.EASY,
            question = "Hoe heette de jongste dochter van de Profeet ﷺ?",
            answers = listOf("Fāṭimah رضي الله عنها", "Zaynab رضي الله عنها", "Ruqayyah رضي الله عنها", "Umm Kulthūm رضي الله عنها"),
            correctAnswerIndex = 0,
            explanation = "Fāṭimah رضي الله عنها was de jongste dochter van de Profeet ﷺ.",
            hint = "Zij was getrouwd met ʿAlī رضي الله عنه.",
            extraHint = "Al-Ḥasan en al-Ḥusayn رضي الله عنهما waren haar zonen.",
            sourceCategory = "Seerah/Familie"
        ),
        Question(
            id = 214,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Welke twee kleinzonen van de Profeet ﷺ zijn zeer bekend?",
            answers = listOf("Al-Ḥasan en al-Ḥusayn رضي الله عنهما", "Qāsim en Ibrāhīm", "Zayd en Usāmah", "Jaʿfar en ʿAqīl"),
            correctAnswerIndex = 0,
            explanation = "Al-Ḥasan en al-Ḥusayn رضي الله عنهما waren de zonen van Fāṭimah en ʿAlī رضي الله عنهما.",
            hint = "Hun moeder was Fāṭimah رضي الله عنها.",
            extraHint = "Hun vader was ʿAlī رضي الله عنه.",
            sourceCategory = "Seerah/Familie"
        ),
        Question(
            id = 215,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Hoe heette een zoon van de Profeet ﷺ die op jonge leeftijd overleed?",
            answers = listOf("Ibrāhīm", "ʿUmar", "Muʿādh", "Bilāl"),
            correctAnswerIndex = 0,
            explanation = "Ibrāhīm was een zoon van de Profeet ﷺ en overleed op jonge leeftijd.",
            hint = "Hij had dezelfde naam als profeet Ibrāhīm عليه السلام.",
            extraHint = "De Profeet ﷺ toonde verdriet en geduld bij zijn overlijden.",
            sourceCategory = "Seerah/Familie"
        ),
        Question(
            id = 216,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Welke vrouw was de moeder van Ibrāhīm, de zoon van de Profeet ﷺ?",
            answers = listOf("Māriyah al-Qibṭiyyah", "Khadījah رضي الله عنها", "ʿĀʾishah رضي الله عنها", "Ṣafiyyah رضي الله عنها"),
            correctAnswerIndex = 0,
            explanation = "Māriyah al-Qibṭiyyah was de moeder van Ibrāhīm, de zoon van de Profeet ﷺ.",
            hint = "Zij kwam uit Egypte.",
            extraHint = "Niet te verwarren met Maryam عليها السلام.",
            sourceCategory = "Seerah/Familie"
        ),
        Question(
            id = 217,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.EASY,
            question = "Welke vrouw van de Profeet ﷺ was de dochter van Abū Bakr رضي الله عنه?",
            answers = listOf("ʿĀʾishah رضي الله عنها", "Ḥafṣah رضي الله عنها", "Zaynab رضي الله عنها", "Ṣafiyyah رضي الله عنها"),
            correctAnswerIndex = 0,
            explanation = "ʿĀʾishah رضي الله عنها was de dochter van Abū Bakr رضي الله عنه.",
            hint = "Haar vader was de eerste khalief.",
            extraHint = "Zij is bekend als een belangrijke geleerde onder de metgezellen.",
            sourceCategory = "Seerah/Sahaba"
        ),
        Question(
            id = 218,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Welke vrouw van de Profeet ﷺ was de dochter van ʿUmar رضي الله عنه?",
            answers = listOf("Ḥafṣah رضي الله عنها", "ʿĀʾishah رضي الله عنها", "Khadījah رضي الله عنها", "Umm Ḥabībah رضي الله عنها"),
            correctAnswerIndex = 0,
            explanation = "Ḥafṣah رضي الله عنها was de dochter van ʿUmar ibn al-Khaṭṭāb رضي الله عنه.",
            hint = "Haar vader was de tweede khalief.",
            extraHint = "Zij wordt gerekend tot de moeders van de gelovigen.",
            sourceCategory = "Seerah/Sahaba"
        ),
        Question(
            id = 219,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Welke titel kregen de vrouwen van de Profeet ﷺ?",
            answers = listOf("Moeders van de gelovigen", "Dochters van de Qur'an", "Vrouwen van Badr", "Zusters van Quraysh"),
            correctAnswerIndex = 0,
            explanation = "De vrouwen van de Profeet ﷺ worden de moeders van de gelovigen genoemd.",
            hint = "Deze titel toont hun bijzondere status.",
            extraHint = "In het Arabisch: Ummahāt al-Mu'minīn.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 220,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Welke vrouw van de Profeet ﷺ stond bekend om haar wijsheid bij Ḥudaybiyah?",
            answers = listOf("Umm Salamah رضي الله عنها", "ʿĀʾishah رضي الله عنها", "Ḥafṣah رضي الله عنها", "Maymūnah رضي الله عنها"),
            correctAnswerIndex = 0,
            explanation = "Umm Salamah رضي الله عنها gaf de Profeet ﷺ wijs advies na het Verdrag van Ḥudaybiyah.",
            hint = "Zij gaf praktisch advies op een moeilijk moment.",
            extraHint = "Haar naam begint met Umm.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 221,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Welke sahabi sliep in het bed van de Profeet ﷺ in de nacht van de hijrah?",
            answers = listOf("ʿAlī رضي الله عنه", "Abū Bakr رضي الله عنه", "ʿUmar رضي الله عنه", "Bilāl رضي الله عنه"),
            correctAnswerIndex = 0,
            explanation = "ʿAlī رضي الله عنه sliep in het bed van de Profeet ﷺ in de nacht van de hijrah.",
            hint = "Hij was de neef van de Profeet ﷺ.",
            extraHint = "Hij gaf later toevertrouwde bezittingen terug.",
            sourceCategory = "Seerah/Sahaba"
        ),
        Question(
            id = 222,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Welke metgezel wordt herinnerd als de leeuw van Allah bij Uḥud?",
            answers = listOf("Ḥamzah رضي الله عنه", "Bilāl رضي الله عنه", "Zayd رضي الله عنه", "Abū Hurayrah رضي الله عنه"),
            correctAnswerIndex = 0,
            explanation = "Ḥamzah رضي الله عنه, de oom van de Profeet ﷺ, wordt herinnerd als de leeuw van Allah.",
            hint = "Hij was een oom van de Profeet ﷺ.",
            extraHint = "Hij werd martelaar bij Uḥud.",
            sourceCategory = "Seerah/Sahaba"
        ),
        Question(
            id = 223,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Welke richting was de eerste qiblah vóór de Kaʿbah?",
            answers = listOf("Bayt al-Maqdis", "Ṭā'if", "Khaybar", "Jemen"),
            correctAnswerIndex = 0,
            explanation = "De eerste qiblah was richting Bayt al-Maqdis, waarna de qiblah naar de Kaʿbah werd veranderd.",
            hint = "Het is verbonden met Jeruzalem.",
            extraHint = "Later werd de qiblah richting Makkah.",
            sourceCategory = "Seerah/Gebed"
        ),
        Question(
            id = 224,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Wat deden de Anṣār voor de Muhājirūn na aankomst in Madinah?",
            answers = listOf("Zij hielpen en ondersteunden hen", "Zij vochten tegen hen", "Zij stuurden hen terug", "Zij weigerden hen onderdak"),
            correctAnswerIndex = 0,
            explanation = "De Anṣār hielpen de Muhājirūn na hun migratie naar Madinah.",
            hint = "Anṣār betekent helpers.",
            extraHint = "Muhājirūn zijn de migranten uit Makkah.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 225,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Welke sahabi diende de Profeet ﷺ jarenlang als zijn trouwe dienaar?",
            answers = listOf("Anas ibn Mālik رضي الله عنه", "Bilāl رضي الله عنه", "Khālid رضي الله عنه", "Abū Dharr رضي الله عنه"),
            correctAnswerIndex = 0,
            explanation = "Anas ibn Mālik رضي الله عنه diende de Profeet ﷺ jarenlang en leverde veel kennis over zijn karakter over.",
            hint = "Hij was jong toen hij de Profeet ﷺ begon te dienen.",
            extraHint = "Zijn naam is Anas.",
            sourceCategory = "Seerah/Sahaba"
        ),
        Question(
            id = 226,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.HARD,
            question = "Welke jonge sahabi werd door de Profeet ﷺ als legerleider aangesteld?",
            answers = listOf("Usāmah ibn Zayd رضي الله عنه", "Abū Bakr رضي الله عنه", "ʿUmar رضي الله عنه", "ʿUthmān رضي الله عنه"),
            correctAnswerIndex = 0,
            explanation = "Usāmah ibn Zayd رضي الله عنه werd als jonge legerleider aangesteld.",
            hint = "Zijn vader was Zayd ibn Ḥārithah رضي الله عنه.",
            extraHint = "Hij was geliefd bij de Profeet ﷺ.",
            sourceCategory = "Seerah/Sahaba"
        ),
        Question(
            id = 227,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.HARD,
            question = "Hoe wordt de laatste grote bedevaart van de Profeet ﷺ genoemd?",
            answers = listOf("Ḥijjat al-Wadāʿ", "Bayʿat al-ʿAqabah", "Ṣulḥ al-Ḥudaybiyah", "Fatḥ Makkah"),
            correctAnswerIndex = 0,
            explanation = "De laatste grote bedevaart heet Ḥijjat al-Wadāʿ, de afscheidsbedevaart.",
            hint = "Wadāʿ betekent afscheid.",
            extraHint = "Tijdens deze bedevaart gaf de Profeet ﷺ belangrijke adviezen.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 228,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Welke houding toonde de Profeet ﷺ bij de opening van Makkah?",
            answers = listOf("Vergeving en bescheidenheid", "Wraakzucht", "Hoogmoed", "Onverschilligheid"),
            correctAnswerIndex = 0,
            explanation = "Bij de opening van Makkah toonde de Profeet ﷺ vergeving en bescheidenheid.",
            hint = "Het was een moment van macht en barmhartigheid.",
            extraHint = "Dit laat zijn karakter en akhlāq zien.",
            sourceCategory = "Seerah/Akhlaaq"
        ),
        Question(
            id = 229,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Wat werd gedaan met de afgoden bij de Kaʿbah bij de opening van Makkah?",
            answers = listOf("Ze werden verwijderd", "Ze werden gelaten", "Ze werden verplaatst", "Ze werden verkocht"),
            correctAnswerIndex = 0,
            explanation = "Bij de opening van Makkah werden de afgoden verwijderd en de Kaʿbah gereinigd.",
            hint = "Dit had te maken met tawḥīd.",
            extraHint = "De Kaʿbah werd gereinigd van afgoderij.",
            sourceCategory = "Seerah/Tawḥīd"
        ),
        Question(
            id = 230,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.EASY,
            question = "Wie was de biologische moeder van de Profeet ﷺ?",
            answers = listOf("Āminah bint Wahb", "Ḥalīmah as-Saʿdiyyah", "Khadījah رضي الله عنها", "Umm Ayman"),
            correctAnswerIndex = 0,
            explanation = "Āminah bint Wahb was de biologische moeder van de Profeet Muḥammad ﷺ.",
            hint = "Zij overleed toen de Profeet ﷺ nog jong was.",
            extraHint = "Na haar overleed zijn grootvader ʿAbd al-Muṭṭalib.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 231,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.EASY,
            question = "Welke vrouw verzorgde de Profeet ﷺ als zijn zoogmoeder?",
            answers = listOf("Ḥalīmah as-Saʿdiyyah", "Āminah bint Wahb", "Umm Ayman", "Khadījah رضي الله عنها"),
            correctAnswerIndex = 0,
            explanation = "Ḥalīmah as-Saʿdiyyah was de zoogmoeder van de Profeet ﷺ bij de Banū Saʿd.",
            hint = "Zij was zijn zoogmoeder.",
            extraHint = "Het was gebruikelijk bij Quraysh om kinderen buiten de stad op te laten groeien.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 232,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Welke slag wonnen de moslims ondanks hun kleinere aantal?",
            answers = listOf("Slag van Badr", "Slag van Uḥud", "Slag bij Ḥunayn", "Slag bij Yamāmah"),
            correctAnswerIndex = 0,
            explanation = "Bij de Slag van Badr wonnen de moslims ondanks hun kleinere aantal.",
            hint = "Het was de eerste grote slag in de islamitische geschiedenis.",
            extraHint = "Er waren ca. 313 moslims tegenover een grotere strijdmacht.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 233,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Bij welke slag leden de moslims een tijdelijke tegenslag?",
            answers = listOf("Slag van Uḥud", "Slag van Badr", "Slag bij Ḥunayn", "Slag bij Khaybar"),
            correctAnswerIndex = 0,
            explanation = "Bij de Slag van Uḥud leden de moslims een tijdelijke tegenslag nadat boogschutters hun positie verlieten.",
            hint = "Het was na de Slag van Badr.",
            extraHint = "Ḥamzah رضي الله عنه werd hier martelaar.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 234,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Welke sahabi was de geliefde van de Profeet ﷺ en vader van Usāmah?",
            answers = listOf("Zayd ibn Ḥārithah رضي الله عنه", "Bilāl رضي الله عنه", "Salmān رضي الله عنه", "Saʿd رضي الله عنه"),
            correctAnswerIndex = 0,
            explanation = "Zayd ibn Ḥārithah رضي الله عنه was zeer geliefd bij de Profeet ﷺ en vader van Usāmah رضي الله عنه.",
            hint = "Zijn zoon heette Usāmah.",
            extraHint = "Hij behoorde tot de eerste moslims.",
            sourceCategory = "Seerah/Sahaba"
        ),
        Question(
            id = 235,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.HARD,
            question = "Welke jonge vrouw bracht voedsel naar de grot van Thawr tijdens de hijrah?",
            answers = listOf("Asmā' bint Abī Bakr رضي الله عنها", "Fāṭimah رضي الله عنها", "Ḥafṣah رضي الله عنها", "Ruqayyah رضي الله عنها"),
            correctAnswerIndex = 0,
            explanation = "Asmā' bint Abī Bakr رضي الله عنها bracht voedsel naar de grot tijdens de hijrah.",
            hint = "Zij was de dochter van Abū Bakr رضي الله عنه.",
            extraHint = "Zij staat bekend als Dhāt an-Niṭāqayn.",
            sourceCategory = "Seerah/Sahaba"
        ),
        Question(
            id = 236,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.HARD,
            question = "Hoe heetten de eden die vóór de hijrah bij al-ʿAqabah werden gesloten?",
            answers = listOf("Bayʿat al-ʿAqabah", "Ṣulḥ al-Ḥudaybiyah", "Fatḥ Makkah", "Ḥijjat al-Wadāʿ"),
            correctAnswerIndex = 0,
            explanation = "Bayʿat al-ʿAqabah verwijst naar de eden die een belangrijke rol speelden vóór de hijrah.",
            hint = "Bayʿah betekent eed of trouwbelofte.",
            extraHint = "Het gebeurde bij al-ʿAqabah.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 237,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Welke vrouw verzorgde de Profeet ﷺ na het overlijden van zijn moeder?",
            answers = listOf("Umm Ayman", "Khadījah رضي الله عنها", "Ḥafṣah رضي الله عنها", "Ṣafiyyah رضي الله عنها"),
            correctAnswerIndex = 0,
            explanation = "Umm Ayman, ook bekend als Barakah, verzorgde de Profeet ﷺ na het overlijden van zijn moeder.",
            hint = "Zij was een toegewijde verzorgster.",
            extraHint = "De Profeet ﷺ behandelde haar met groot respect.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 238,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.MEDIUM,
            question = "Welke eigenschap benadrukte de Profeet ﷺ centraal in zijn afscheidskhutbah?",
            answers = listOf("Gelijkheid en rechten van mensen", "Rijkdom en macht", "Afstand van anderen", "Strijd om land"),
            correctAnswerIndex = 0,
            explanation = "In de afscheidskhutbah benadrukte de Profeet ﷺ gelijkheid en rechten van mensen.",
            hint = "De boodschap gold voor alle mensen.",
            extraHint = "Hij benadrukte dat alle mensen gelijk zijn voor Allah.",
            sourceCategory = "Seerah/Akhlaaq"
        ),
        Question(
            id = 239,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.HARD,
            question = "In welke stad overleed de Profeet Muḥammad ﷺ?",
            answers = listOf("Madinah", "Makkah", "Ṭā'if", "Khaybar"),
            correctAnswerIndex = 0,
            explanation = "De Profeet Muḥammad ﷺ overleed in Madinah.",
            hint = "Het was de stad waarnaar hij migreerde.",
            extraHint = "Zijn graf bevindt zich in de Masjid an-Nabawī.",
            sourceCategory = "Seerah"
        ),
        Question(
            id = 240,
            category = QuizCategory.SEERAH,
            difficulty = Difficulty.HARD,
            question = "Welke kernles staat centraal in de sīrah van de Profeet ﷺ in Makkah?",
            answers = listOf("Geduld en standvastigheid bij beproeving", "Rijkdom boven waarheid", "Aanbidding uitstellen", "Hoogmoed tegenover zwakken"),
            correctAnswerIndex = 0,
            explanation = "De Makkaanse periode laat zien hoe de Profeet ﷺ en de vroege moslims geduld en standvastigheid toonden.",
            hint = "Denk aan de vervolging en moeilijke jaren in Makkah.",
            extraHint = "Ṣabr en standvastigheid zijn de kernlessen.",
            sourceCategory = "Seerah/Akhlaaq"
        )

    )

}

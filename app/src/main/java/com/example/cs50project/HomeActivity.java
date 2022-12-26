package com.example.cs50project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity implements UserAdapter.UserClickListener{


    RecyclerView rvUsers;
    UserAdapter userAdapter;
    List<UserModel> userModelList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        rvUsers = findViewById(R.id.rvUsers);
        setData();
        prepareRecyclerView();
    }

    public void setData() {
        userModelList.add(new UserModel(R.drawable.itendwithus,"It ends with us", "Colleen Hoover", "Category: romance", "Pages: 367 page.", "Date of publish: August 2, 2016", "It Ends with Us focuses on Lily Bloom, a young college graduate who moves to Boston and opens her own floral business. She develops feelings for surgeon Ryle Kincaid, who is initially reluctant about having a serious relationship with her. As their relationship blossoms, Lily has a sudden encounter with her first love, Atlas Corrigan. This reintroduction of Atlas threatens her relationship with Ryle and forces her to come to terms with the trauma of her past and present. Lily is forced to make a difficult decision when she is faced with an assault and finds out she is already pregnant with Ryle's child. Atlas initially helps her, but both decide they cannot be around each other casually. Ultimately, Lily decides to leave Ryle for the sake of her newborn baby. "));
        userModelList.add(new UserModel(R.drawable.book2,"The seven husbands of eleven evelyn hugo", "Taylor Jenkins Reid", "Category: historical fiction", "Pages: 400 page.", "Date of publish: June 13, 2017", "The Seven Husbands of Evelyn Hugo tells the story of old Hollywood actor Evelyn Hugo, determined to secure an A-List spot in the industry by doing whatever it takes to get there. While attempting to complete her rise to stardom, she marries  seven husbands and outlives them all. Later in her life, Hugo then hires a lesser-known journalist to write her memoir and, for the first time in her decorated life, tells details and secrets about her love life leaving readers with no choice but to keep turning the pages. Monique Grant – the journalist hired by Hugo – goes on her own journey while learning about the actress and as the book goes on, Grant seeks to discover why she was chosen to document Hugo’s life. The reason is later revealed, in a twist leaving readers on edge."));
        userModelList.add(new UserModel(R.drawable.book3,"A court of thorns and roses series", "Sarah J. Maas", "Category: fantasy", "Pages: 448 page.", "Date of publish: May 5, 2015", "When nineteen-year-old huntress Feyre kills a wolf in the woods, a terrifying creature arrives to demand retribution. Dragged to a treacherous magical land she knows about only from legends, Feyre discovers that her captor is not truly a beast, but one of the lethal, immortal faeries who once ruled her world. At least, he’s not a beast all the time.\n" +
                "As she adapts to her new home, her feelings for the faerie, Tamlin, transform from icy hostility into a fiery passion that burns through every lie she’s been told about the beautiful, dangerous world of the Fae. But something is not right in the faerie lands. An ancient, wicked shadow is growing, and Feyre must find a way to stop it, or doom Tamlin―and his world―forever.\n"));
        userModelList.add(new UserModel(R.drawable.book4, "The Great Alone", "Kristin Hannah", "Category: historical fiction", "pages: 576 page.", "February 6, 2018", "Ernt Allbright, a former POW, comes home from the Vietnam war a changed and volatile man. When he loses yet another job, he makes an impulsive decision: he will move his family north, to Alaska, where they will live off the grid in America’s last true frontier.\n" +
                "Thirteen-year-old Leni, a girl coming of age in a tumultuous time, caught in the riptide of her parents’ passionate, stormy relationship, dares to hope that a new land will lead to a better future for her family. She is desperate for a place to belong. Her mother, Cora, will do anything and go anywhere for the man she loves, even if means following him into the unknown...\n"));
        userModelList.add(new UserModel(R.drawable.book5,"Verity", "Colleen Hoover", "Category: thriller", "Pages: 336 page.", "Date of publish: January 2, 2019", "Lowen Ashleigh is a struggling writer on the brink of financial ruin when she accepts the job offer of a lifetime. Jeremy Crawford, husband of bestselling author Verity Crawford, has hired Lowen to complete the remaining books in a successful series his injured wife is unable to finish.\n" +
                "Lowen arrives at the Crawford home, ready to sort through years of Verity's notes and outlines, hoping to find enough material to get her started. What Lowen doesn't expect to uncover in the chaotic office is an unfinished autobiography Verity never intended for anyone to read. Page after page of bone-chilling admissions, including Verity's recollection of what really happened the day her daughter died...\n"));
        userModelList.add(new UserModel(R.drawable.book6,"Malibu rising", "Jennifer Longo", "Category: historical fiction", "Pages: 384 page.","Date of publish: June 1, 2021", "Malibu: August 1983. It's the day of Nina Riva's annual end-of-summer party, and anticipation is at a fever pitch. Everyone wants to be around the famous Rivas: Nina, the talented surfer and supermodel; brothers Jay and Hud, one a championship surfer, the other a renowned photographer; and their adored baby sister, Kit. Together the siblings are a source of fascination in Malibu and the world over—especially as the offspring of the legendary singer Mick Riva.\n" +
                "Malibu Rising is a story about one unforgettable night in the life of a family: the night they each have to choose what they will keep from the people who made them...and what they will leave behind."));
        userModelList.add(new UserModel(R.drawable.book7,"The invisible life of addie laRue", "V.E. Schwab", "Category: fantasy", "Pages: 448 page.", "Date of publish: October 6, 2020", "France, 1714: in a moment of desperation, a young woman makes a Faustian bargain to live forever and is cursed to be forgotten by everyone she meets.\n" +
                "Thus begins the extraordinary life of Addie LaRue, and a dazzling adventure that will play out across centuries and continents, across history and art, as a young woman learns how far she will go to leave her mark on the world.\n" +
                "But everything changes when, after nearly 300 years, Addie stumbles across a young man in a hidden bookstore and he remembers her name. \n" + " It was heavily praised and nominated for the 2021 Locus Award for Best Fantasy Novel. \n"));
        userModelList.add(new UserModel(R.drawable.book8,"Carrie soto is back", "Lolita Hernandez", "Category: historical fiction", "Pages: 384 page.", "Date of publish: August 19, 2021", "It’s 1994, and Carrie Soto, the legendary tennis player and record-holder for most Grand Slams is watching her reign crumble under the incredibly fast serves of Nicki Chan, a younger, faster, and tougher opponent. Soto decides to leave retirement which she announced in 1989 to re-enter professional competitions in an effort to defend her record. The plot moves back in time to follow Soto’s first rise to the top, and then we come along on her grueling training as she attempts to defend her title six years later. Playing a large role in Soto’s life is her father, a tennis player himself who was injured too young to make a significant mark like his daughter. . “Javier el Jaguar” finds purpose and joy in coaching Soto, and together they become obsessed with winning..."));
        userModelList.add(new UserModel(R.drawable.book9,"Rock, paper, scissors", "Layne Fargo", "Category: thriller", "Pages: 304 page.", "Date of publish: September 3, 2020", "Think you know the person you married? Think again…\n" +
                "Things have been wrong with Mr and Mrs Wright for a long time. When Adam and Amelia win a weekend away to Scotland, it might be just what their marriage needs. Self-confessed workaholic and screenwriter Adam Wright has lived with face blindness his whole life. He can’t recognize friends or family, or even his own wife.\n" +
                "Every anniversary the couple exchange traditional gifts and each year Adam’s wife writes him a letter that she never lets him read. Until now. They both know this weekend will make or break their marriage, but they didn’t randomly win this trip. One of them is lying, and someone doesn’t want them to live happily ever after.\n"));
        userModelList.add(new UserModel(R.drawable.book10,"Crescent city series", "Sarah J. Maas", "Category: fantasy", "Pages: 800 page.", "Date of publish: August 30, 2022", "Bryce Quinlan had the perfect life—working hard all day and partying all night—until a demon murdered her closest friends, leaving her bereft, wounded, and alone. When the accused is behind bars but the crimes start up again, Bryce finds herself at the heart of the investigation. She’ll do whatever it takes to avenge their deaths.\n" +
                "Hunt Athalar is a notorious Fallen angel, now enslaved to the Archangels he once attempted to overthrow. His brutal skills and incredible strength have been set to one purpose—to assassinate his boss’s enemies, no questions asked. But with a demon wreaking havoc in the city, he’s offered an irresistible deal: help Bryce find the murderer, and his freedom will be within reach...\n"));
        userModelList.add(new UserModel(R.drawable.book11,"One true loves", "Taylor Jenkins Reid", "Category: romance", "Pages: 352 page.", "Date of publish: June 14, 2016", "In her twenties, Emma Blair marries her high school sweetheart, Jesse. They build a life for themselves, far away from the expectations of their parents and the people of their hometown in Massachusetts. They travel the world together, living life to the fullest and seizing every opportunity for adventure. On their first wedding anniversary, Jesse is on a helicopter over the Pacific when it goes missing. Just like that, Jesse is gone forever.\n" +
                "Emma quits her job and moves home in an effort to put her life back together. Years later, now in her thirties, Emma runs into an old friend, Sam, and finds herself falling in love again..." + "Who is her one true love? What does it mean to love truly?\n" +
                "Emma knows she has to listen to her heart.\n"));
        userModelList.add(new UserModel(R.drawable.book12,"The silent patient", "Alex Michaelides", "Category: thriller", "Pages: 339 page.","Date of publish: February 5, 2019", "The Silent Patient is a shocking psychological thriller of a woman’s act of violence against her husband—and of the therapist obsessed with uncovering her motive.\n" +
                "Alicia Berenson’s life is seemingly perfect. A famous painter married to an in-demand fashion photographer, she lives in a grand house with big windows overlooking a park in one of London’s most desirable areas. One evening her husband Gabriel returns home late from a fashion shoot, and Alicia shoots him five times in the face, and then never speaks another word. Alicia’s refusal to talk, or give any kind of explanation, turns a domestic tragedy into something far grander, a mystery that captures the public imagination and casts Alicia into notoriety...\n"));
        userModelList.add(new UserModel(R.drawable.book13,"We are Brennans", "Carlene Bauer", "Category: fiction", "Pages: 288 page.","Date of publish: February 6, 2020", "We Are the Brennans is the story of an Irish-Catholic family fractured by shame and secrets. When eldest daughter Sunday wrecks her car after a night of heavy drinking in LA, she sets her pride aside and moves back east to her family's New York home. But her once tight-knit family is not as she left it: Her father is losing his memory, her brother is struggling to keep his pub afloat, and her ex-fiancé is now married to another woman. As Sunday tries to keep her head down and find her place in this changed home, tales of past mistakes and long-held secrets unfold, forcing the family to come together, rebuild, and find redemption."));
        userModelList.add(new UserModel(R.drawable.book14,"The inheritance games series", "Jennifer Lynn Barnes", "Category: fiction", "Pages: 400 page.", "Date of publish: August 4, 2020", "The Inheritance Games is a young adult mystery/thriller. It follows a teenage girl, Avery Kylie Grambs, who is unexpectedly left a billion-dollar fortune by a mysterious philanthropist, Tobias Hawthorne. In his will, Tobias stipulates that Avery must live in his mansion, Hawthorne House, for one year if she’s going to inherit. Avery shares the home with the Hawthornes, who are angry and confused as to why Tobias left his fortune to Avery. The book follows Avery’s journey as she unravels the clues Tobias left behind, hoping to understand why a man she doesn’t remember meeting left her billions of dollars.\n" +
                "The book was also nominated in the Best Young Adult Mystery category of the Edgar Awards.\n"));
        userModelList.add(new UserModel(R.drawable.book15,"Daisy Jones and the six", "Taylor Jenkins Reid", "Category: historical fiction", "Pages: 400 page.", "Date of publish: March 5, 2019", "Daisy is a girl coming of age in L.A. in the late sixties, sneaking into clubs on the Sunset Strip, sleeping with rock stars, and dreaming of singing at the Whisky a Go-Go. The sex and drugs are thrilling, but it’s the rock and roll she loves most. By the time she’s twenty, her voice is getting noticed, and she has the kind of heedless beauty that makes people do crazy things.Another band getting noticed is The Six, led by the brooding Billy Dunne. On the eve of their first tour, his girlfriend Camila finds out she’s pregnant, and with the pressure of impending fatherhood and fame, Billy goes a little wild on the road.\n" +
                "Daisy and Billy cross paths when a producer realizes the key to supercharged success is to put the two together. What happens next will become the stuff of legend.\n"));
        userModelList.add(new UserModel(R.drawable.book16,"The prisoner", "B.A Paris", "Category: thriller", "Pages: 317 page.", "Date of publish: January 7, 2020", "B. A. Paris took the psychological thriller to shocking new heights. Now she’ll hold you captive with THE PRISONE a stunning new thriller about one woman wed into a family with deadly intentions.\n"+ "Amelie has always been a survivor, from losing her parents as a child in Paris to making it on her own in London. As she builds a life for herself, she is swept up into a glamorous lifestyle where she married the handsome billionaire Ned Hawthorne.\n" +
                "But then, Amelie wakes up in a pitch-black room, not knowing where she is. Why has she been taken? Who are her mysterious captors? And why does she soon feel safer here, imprisoned, than she had begun to feel with her husband Ned?\n"));
        userModelList.add(new UserModel(R.drawable.book17,"Luckiest girl", "Jessica Koll", "Category: thriller", "Pages: 368 page.", "Date of publish: May 12, 2015", "HER PERFECT LIFE IS A PERFECT LIE\n" +
                "As a teenager at the prestigious Bradley School, Ani FaNelli endured a shocking, public humiliation that left her desperate to reinvent herself. Now, with a glamorous job, expensive wardrobe, and handsome blue blood fiancé, she’s this close to living the perfect life she’s worked so hard to achieve. But Ani has a secret. There’s something else buried in her past that still haunts her, something private and painful that threatens to bubble to the surface and destroy everything. \n" +
                "The question remains: will breaking her silence destroy all that she has worked fo or, will it at long last, set Ani free?\n"));
    }




    public void prepareRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvUsers.setLayoutManager(linearLayoutManager);
        preAdapter();
    }

    public void preAdapter() {
        userAdapter = new UserAdapter(userModelList, this, this::selectedUser);
        rvUsers.setAdapter(userAdapter);
    }

    @Override
    public void selectedUser(UserModel userModel) {
        startActivity(new Intent(this, SelectedUserActivity.class).putExtra("data", userModel));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.searchView){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        MenuItem menuItem = menu.findItem(R.id.searchView);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String searchStr = newText;
                userAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }


}

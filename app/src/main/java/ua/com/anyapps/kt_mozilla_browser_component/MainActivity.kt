package ua.com.anyapps.kt_mozilla_browser_component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.content.ContextCompat
import ua.com.anyapps.kt_mozilla_browser_component.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var sites = mutableListOf<Site>()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //title = "test"
        fillSites()

        val sitesGridViewListAdapter = SitesGridViewListAdapter(this, sites)
        binding.gvSites.adapter = sitesGridViewListAdapter
        binding.gvSites.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, "You clicked: ${sites[i]}", Toast.LENGTH_SHORT).show()
        }

        val s:ArrayList<String> = getRandomAccounts()
        Log.d("debapp", "Total: ${s.size}")
        for (n in 0..s.size-1) {
            Log.d("debapp", "Acc: ${s[n]}")
        }
    }

    private fun fillSites(){
        sites.add(Site("Bebo", Target.BEDO, "https://chattyheads.com/profile/login", R.drawable.ic_bebo, getRandomAccounts(), true))
        sites.add(Site("Behance", Target.BEHANCE, "https://www.behance.net", R.drawable.ic_behance, getRandomAccounts(), false))
        sites.add(Site("Blogger", Target.BLOGGER, "https://www.blogger.com", R.drawable.ic_blogger, getRandomAccounts(), false))
        sites.add(Site("Deviantart", Target.DEVIANTART, "https://www.deviantart.com/users/login", R.drawable.ic_deviantart, getRandomAccounts(), true))
        sites.add(Site("Digg", Target.DIGG, "https://digg.com", R.drawable.ic_digg, getRandomAccounts(), false))
        sites.add(Site("Dribbble", Target.DRIBBBLE, "https://dribbble.com/session/new", R.drawable.ic_dribbble, getRandomAccounts(), false))
        sites.add(Site("Facebook", Target.FACEBOOK, "https://www.facebook.com", R.drawable.ic_facebook, getRandomAccounts(), true))
        sites.add(Site("Flickr", Target.FLICKR, "https://www.flickr.com", R.drawable.ic_flickr, getRandomAccounts(), false))
        sites.add(Site("Forrst", Target.FORRST, "https://zurb.com", R.drawable.ic_forrst, getRandomAccounts(), false))
        sites.add(Site("Google+", Target.GOOGLE_PLUS, "https://www.google.com", R.drawable.ic_google_plus, getRandomAccounts(), false))
        sites.add(Site("Instagram", Target.INSTAGRAM, "https://www.instagram.com", R.drawable.ic_instagram, getRandomAccounts(), true))
        sites.add(Site("Line", Target.LINE, "https://line.me", R.drawable.ic_line, getRandomAccounts(), false))
        sites.add(Site("Linkedin", Target.LINKEDIN, "https://www.linkedin.com/login", R.drawable.ic_linkedin, getRandomAccounts(), true))
        sites.add(Site("Myspace", Target.MYSPACE, "https://myspace.com/signin", R.drawable.ic_myspace, getRandomAccounts(), true))
        sites.add(Site("Pinterest", Target.PINTEREST, "https://www.pinterest.com", R.drawable.ic_pinterest, getRandomAccounts(), false))
        sites.add(Site("Plurk", Target.PLURK, "https://www.plurk.com/login?r=", R.drawable.ic_plurk, getRandomAccounts(), true))
        sites.add(Site("Rss", Target.RSS, "https://dashboard.rss.com/auth/sign-in/", R.drawable.ic_rss, getRandomAccounts(), true))
        sites.add(Site("Skype", Target.SKYPE, "https://www.skype.com", R.drawable.ic_skype, getRandomAccounts(), true))
        sites.add(Site("Telegram", Target.TELEGRAM, "https://web.telegram.org/#/login", R.drawable.ic_telegram, getRandomAccounts(), false))
        sites.add(Site("Tumblr", Target.TUMBLR, "https://www.tumblr.com", R.drawable.ic_tumblr, getRandomAccounts(), false))
        sites.add(Site("Twitter", Target.TWITTER, "https://twitter.com/login", R.drawable.ic_twitter, getRandomAccounts(), true))
        sites.add(Site("Viber", Target.VIBER, "https://www.viber.com", R.drawable.ic_viber, getRandomAccounts(), false))
        sites.add(Site("Vimeo", Target.VIMEO, "https://vimeo.com", R.drawable.ic_vimeo, getRandomAccounts(), false))
        sites.add(Site("Vine", Target.VINE, "https://vine.co", R.drawable.ic_vine, getRandomAccounts(), false))
        sites.add(Site("Vk", Target.VK, "https://vk.com", R.drawable.ic_vk, getRandomAccounts(), true))
        sites.add(Site("Whatsapp", Target.WHATSAPP, "https://www.whatsapp.com", R.drawable.ic_whatsapp, getRandomAccounts(), false))
        sites.add(Site("Xing", Target.XING, "https://login.xing.com", R.drawable.ic_xing, getRandomAccounts(), true))
        sites.add(Site("Youtube", Target.YOUTUBE, "https://www.youtube.com", R.drawable.ic_youtube, getRandomAccounts(), false))
    }

    private fun getRandomAccounts():ArrayList<String>{
        val accounts: ArrayList<String> = arrayListOf()
        val rnds = (0..5).random()

        if(rnds>=1) {
            for (n in 0..rnds) {
                accounts.add("Account$n@gmail.com")
            }
        }
        return accounts
    }
}


package ua.com.anyapps.kt_mozilla_browser_component

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class SitesGridViewListAdapter(private val context: Context, private val sites: List<Site>): BaseAdapter() {
    private var layoutInflater: LayoutInflater? = null
    private lateinit var ivThumb: ImageView
    private lateinit var tvTitle: TextView
    private lateinit var tvTotalAccounts: TextView
    private lateinit var clInnerContainer: ConstraintLayout

    override fun getCount(): Int {
        return sites.size
    }

    override fun getItem(p0: Int): Any {
        return sites[p0]
    }

    override fun getItemId(p0: Int): Long {
        return sites[p0].id
    }

    override fun getView(p0: Int, convertView: View?, p2: ViewGroup?): View {
        var convertView = convertView
        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (convertView == null) {
            convertView = layoutInflater!!.inflate(R.layout.grid_item, null)
        }
        ivThumb = convertView!!.findViewById(R.id.ivThumb)
        tvTitle = convertView.findViewById(R.id.tvTitle)
        tvTotalAccounts = convertView.findViewById(R.id.tvTotalAccounts)
        clInnerContainer = convertView.findViewById(R.id.clInnerContainer)

        ivThumb.setImageResource(sites[p0].thumb)
        tvTitle.text = sites[p0].title
        tvTotalAccounts.text = "(${sites[p0].accounts.size.toString()})"

        when(sites[p0].success){
            true->clInnerContainer.background = context.resources.getDrawable(R.drawable.grid_item_border_success_on)
            false->clInnerContainer.background = context.resources.getDrawable(R.drawable.grid_item_border_success_off)
        }

        return convertView
    }
    
}
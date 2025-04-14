import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import app.webview.errorpage.R
import app.webview.errorpage.model.Item
import coil.load

class ItemAdapter(
    private val context: Context,
    private var items: List<Item>
) : BaseAdapter() {

    fun updateData(newItems: List<Item>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun getCount(): Int = items.size
    override fun getItem(position: Int): Item = items[position]
    override fun getItemId(position: Int): Long = items[position].id.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_list, parent, false)

        val imageView = view.findViewById<ImageView>(R.id.itemImage)
        val title = view.findViewById<TextView>(R.id.itemTitle)
        val description = view.findViewById<TextView>(R.id.itemDesc)

        val item = items[position]
        title.text = item.title
        description.text = "Price: $${item.price}"

        imageView.load(item.image) {
            placeholder(R.drawable.ic_launcher_background)
            error(R.drawable.ic_launcher_background)
        }

        return view
    }
}

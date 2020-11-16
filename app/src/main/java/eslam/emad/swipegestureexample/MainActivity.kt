package eslam.emad.swipegestureexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.daimajia.swipe.util.Attributes
import eslam.emad.swipegestureexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = Adapter(loadData(), this)
        adapter.mode = Attributes.Mode.Single

        binding.recyclerView.adapter = adapter
    }

    private fun loadData(): ArrayList<Book>{
        val mList = ArrayList<Book>()
        for (i in 1..10){
            mList.add(Book("Name $i", "Book $i"))
        }
        return mList
    }

    override fun onItemClick(book: Book) {
        Toast.makeText(this,"${book.bookName} Item clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onEditClick(book: Book) {
        Toast.makeText(this,"${book.bookName} Edit clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onShareClick(book: Book) {
        Toast.makeText(this,"${book.bookName} Share clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onDeleteClick(book: Book) {
        Toast.makeText(this,"${book.bookName} Delete clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onLocationClick(book: Book) {
        Toast.makeText(this,"${book.bookName} Location clicked", Toast.LENGTH_SHORT).show()
    }
}
package com.example.playground

import android.os.Parcel
import android.os.Parcelable
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.ObjectStreamException
import java.io.Serializable

// 기본 Serializable
data class UserSerializable(
    val id: Int,
    val name: String,
    val age: Int,
) : Serializable

// 커스텀 Serializable
data class UserCustomSerializable(
    val id: Int,
    val name: String,
    val age: Int,
) : Serializable {
    @Throws(IOException::class)
    private fun writeObject(out: ObjectOutputStream) {
        out.defaultWriteObject()
    }

    @Throws(IOException::class, ClassNotFoundException::class)
    private fun readObject(`in`: ObjectInputStream) {
        `in`.defaultReadObject()
    }

    @Throws(ObjectStreamException::class)
    private fun readObjectNoData() {
    }
}

// Parcelable
data class UserParcelable(
    val id: Int,
    val name: String,
    val age: Int,
) : Parcelable {
    override fun describeContents(): Int = 0

    override fun writeToParcel(
        parcel: Parcel,
        flags: Int,
    ) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeInt(age)
    }

    companion object CREATOR : Parcelable.Creator<UserParcelable> {
        override fun createFromParcel(parcel: Parcel): UserParcelable {
            val id = parcel.readInt()
            val name = parcel.readString() ?: ""
            val age = parcel.readInt()
            return UserParcelable(id, name, age)
        }

        override fun newArray(size: Int): Array<UserParcelable?> = arrayOfNulls(size)
    }
}

@RunWith(AndroidJUnit4::class)
class SerializationBenchmarkTest {
    private val repeatCount = 100_000

    // ------------------------------
    // Serializable 기본 테스트
    // ------------------------------
    private fun testSerializable(
        obj: Serializable,
        label: String,
    ) {
        val start = System.nanoTime()
        repeat(repeatCount) {
            val baos = ByteArrayOutputStream()
            val oos = ObjectOutputStream(baos)
            oos.writeObject(obj)
            oos.flush()

            val data = baos.toByteArray()
            val bais = ByteArrayInputStream(data)
            val ois = ObjectInputStream(bais)
            val newObj = ois.readObject() as Serializable

            // 참조해서 최적화 방지
            require(newObj.hashCode() >= 0)
        }
        val end = System.nanoTime()
        println("$label Elapsed = ${(end - start) / 1_000_000} ms")
    }

    // ------------------------------
    // Parcelable 테스트
    // ------------------------------
    private fun testParcelable(
        obj: Parcelable,
        label: String,
    ) {
        val start = System.nanoTime()
        repeat(repeatCount) {
            val parcel = Parcel.obtain()
            obj.writeToParcel(parcel, 0)
            parcel.setDataPosition(0)
            val newObj = UserParcelable.CREATOR.createFromParcel(parcel)
            require(newObj.id >= 0) // 읽은 객체를 참조함으로써 최적화 방지
            parcel.recycle()
        }
        val end = System.nanoTime()
        println("$label Elapsed = ${(end - start) / 1_000_000} ms")
    }

    // ------------------------------
    // 테스트 실행
    // ------------------------------
    @Test
    fun runBenchmark() {
        val basic = UserSerializable(1, "Alice", 30)
        val custom = UserCustomSerializable(1, "Alice", 30)
        val parcelable = UserParcelable(1, "Alice", 30)

        testSerializable(basic, "Default Serializable")
        testSerializable(custom, "Custom Serializable")
        testParcelable(parcelable, "Parcelable")
    }
}

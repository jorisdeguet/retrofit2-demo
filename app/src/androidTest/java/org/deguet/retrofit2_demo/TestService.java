package org.deguet.retrofit2_demo;

import android.util.Log;

import androidx.test.runner.AndroidJUnit4;

import org.deguet.retrofit2_demo.http.RetrofitUtil;
import org.deguet.retrofit2_demo.http.Service;
import org.deguet.retrofit2_demo.transfer.Repo;
import org.deguet.retrofit2_demo.transfer.Utilisateur;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class TestService {
    @Test
    public void testSimple() throws IOException {
        Service service = RetrofitUtil.get();
        Call<String> call = service.listReposString("jorisdeguet");
        Response<String> response = call.execute();
        String resultat = response.body();
        Log.i("RETROFIT", resultat);
    }

    @Test
    public void testStructures() throws IOException {
        Service service = RetrofitUtil.get();
        Call<List<Repo>> call = service.listRepos("jorisdeguet");
        Response<List<Repo>> response = call.execute();
        List<Repo> resultat = response.body();
        Log.i("RETROFIT", resultat.toString());
    }

    @Test
    public void testSimpleUtilisateur() throws IOException {
        Service service = RetrofitUtil.get();
        Call<String> call = service.utilisateurString("jorisdeguet");
        Response<String> response = call.execute();
        String resultat = response.body();
        Log.i("RETROFIT", resultat);
    }

    @Test
    public void testSimpleUtilisateurStructure() throws IOException {
        Service service = RetrofitUtil.get();
        Call<Utilisateur> call = service.utilisateur("jorisdeguet");
        Response<Utilisateur> response = call.execute();
        Utilisateur resultat = response.body();
        Log.i("RETROFIT", resultat.toString());
    }
}

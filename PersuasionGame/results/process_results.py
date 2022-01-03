import os
import pandas as pd
import matplotlib.pyplot as plt
from pandas.core.series import Series

def get_data():

    results = {}
    folder = "PersuasionGame/results/"

    for file in os.listdir(folder):

        if file.find(".txt") == -1:
            continue

        with open(folder+file, 'r') as f:
            info = f.readlines()
            
        for s in range(len(info)):
            fields = info[s].replace("\n","").split(": ")

            if fields[1] == "null": break

            try:
                fields[1] = int(fields[1])
            except ValueError:
                pass
            
            try:
                results[fields[0]].append(fields[1])
            except KeyError: 
                results[fields[0]] = [fields[1],]

    return results

def plot_unhetical_decisions_per_mode(df):

    df2 = pd.DataFrame()
    
    for mode in df["Robot mode"].unique():

        if len(list(df[df["Robot mode"]==mode]["Unethical decisions"])) >  len(df2):
            for _ in range(len(list(df[df["Robot mode"]==mode]["Unethical decisions"]))-len(df2)):
                df2 = df2.append(pd.Series(), ignore_index=True)


        df2[mode] = pd.Series(list(df[df["Robot mode"]==mode]["Unethical decisions"]))

    fig = plt.figure()
    boxplot = df2.boxplot(grid=True, rot=0)
    boxplot.set_title("Number of Unethical Decisions per Mode")
    boxplot.set_ylabel("Average of Decisions")

    fig.savefig('PersuasionGame/results/unethical_mode.png')

    breakpoint



if __name__ == "__main__":

    data = get_data()

    df = pd.DataFrame.from_dict(data)

    plot_unhetical_decisions_per_mode(df)

    breakpoint